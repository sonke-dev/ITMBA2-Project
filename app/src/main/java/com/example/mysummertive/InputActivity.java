package com.example.mysummertive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InputActivity extends AppCompatActivity {

    EditText etModeOfTransport, etDistanceTravelled, etCostPerKilometre;
    DatePicker dpTravelDays;
    Spinner spTransportType;
    Button btnCalculateAndSave, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etModeOfTransport = findViewById(R.id.etModeOfTransport);
        etDistanceTravelled = findViewById(R.id.etDistanceTravelled);
        etCostPerKilometre = findViewById(R.id.etCostPerKilometre);
        dpTravelDays = findViewById(R.id.dpTravelDays);
        spTransportType = findViewById(R.id.spTransportType);
        btnCalculateAndSave = findViewById(R.id.btnCalculateAndSave);
        btnClear = findViewById(R.id.btnClear);

        btnCalculateAndSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String modeText = etModeOfTransport.getText().toString().trim();
                String distanceText = etDistanceTravelled.getText().toString().trim();
                String costText = etCostPerKilometre.getText().toString().trim();


                if (modeText.isEmpty()) {
                    etModeOfTransport.setError("Mode of transport is required");
                    return;
                }
                if (distanceText.isEmpty()) {
                    etDistanceTravelled.setError("Distance travelled is required");
                    return;
                }
                if (costText.isEmpty()) {
                    etCostPerKilometre.setError("Cost per kilometre is required");
                    return;
                }


                double distance;
                try {
                    distance = Double.parseDouble(distanceText);
                } catch (NumberFormatException e) {
                    etDistanceTravelled.setError("Enter a valid number");
                    return;
                }

                double costPerKm;
                try {
                    costPerKm = Double.parseDouble(costText);
                } catch (NumberFormatException e) {
                    etCostPerKilometre.setError("Enter a valid number");
                    return;
                }


                int selectedYear = dpTravelDays.getYear();
                int selectedMonth = dpTravelDays.getMonth(); // 0-indexed
                int travelDays = calculateWeekdaysInMonth(selectedYear, selectedMonth);

                String transportType = spTransportType.getSelectedItem().toString();


                TransportCalculator calculator = new TransportCalculator();
                double dailyCost = calculator.calculateDailyCost(distance, costPerKm);
                double monthlyCost = calculator.calculateMonthlyCost(dailyCost, travelDays);
                double monthlyDistance = calculator.calculateMonthlyDistanceCost(distance, travelDays);


                Recommendation rec = new Recommendation();
                String category = rec.determineCategory(monthlyCost);
                String recommendationText = rec.determineRecommendation(monthlyCost);


                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String dateCreated = sdf.format(new Date());


                Transport transport = new Transport(
                        modeText,
                        transportType,
                        distance,
                        costPerKm,
                        travelDays,
                        dailyCost,
                        monthlyCost,
                        monthlyDistance,
                        category,
                        recommendationText,
                        dateCreated
                );

                //9b
                DatabaseHelper dbHelper = new DatabaseHelper(InputActivity.this);
                dbHelper.insertReport(transport);


                Intent intent = new Intent(InputActivity.this, ResultsActivity.class);
                intent.putExtra("mode", transport.getModeOfTransport());
                intent.putExtra("transportType", transport.getTransportType());
                intent.putExtra("dailyCost", transport.getDailyTransportCost());
                intent.putExtra("monthlyCost", transport.getMonthlyTransportCost());
                intent.putExtra("monthlyDistance", transport.getMonthlyTravelDistance());
                intent.putExtra("category", transport.getTransportCostCategory());
                intent.putExtra("recommendation", transport.getRecommendation());
                startActivity(intent);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etModeOfTransport.setText("");
                etDistanceTravelled.setText("");
                etCostPerKilometre.setText("");
            }
        });
    }


    private int calculateWeekdaysInMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekdayCount = 0;

        for (int day = 1; day <= daysInMonth; day++) {
            calendar.set(year, month, day);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                weekdayCount++;
            }
        }
        return weekdayCount;
    }
}