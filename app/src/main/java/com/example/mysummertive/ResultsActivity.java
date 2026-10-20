package com.example.mysummertive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView tvResultModeOfTransport, tvResultDailyCost, tvResultMonthlyCost,
            tvResultMonthlyDistance, tvResultCategory, tvResultRecommendation;
    Button btnResultCalculateAgain, btnResultExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Linking views
        tvResultModeOfTransport = findViewById(R.id.tvResultModeOfTransport);
        tvResultDailyCost = findViewById(R.id.tvResultDailyCost);
        tvResultMonthlyCost = findViewById(R.id.tvResultMonthlyCost);
        tvResultMonthlyDistance = findViewById(R.id.tvResultMonthlyDistance);
        tvResultCategory = findViewById(R.id.tvResultCategory);
        tvResultRecommendation = findViewById(R.id.tvResultRecommendation);
        btnResultCalculateAgain = findViewById(R.id.btnResultCalculateAgain);
        btnResultExit = findViewById(R.id.btnResultExit);

        // getting values passed from InputActivity
        String mode = getIntent().getStringExtra("mode");
        String transportType = getIntent().getStringExtra("transportType");
        double dailyCost = getIntent().getDoubleExtra("dailyCost", 0.0);
        double monthlyCost = getIntent().getDoubleExtra("monthlyCost", 0.0);
        double monthlyDistance = getIntent().getDoubleExtra("monthlyDistance", 0.0);
        String category = getIntent().getStringExtra("category");           // 10b
        String recommendation = getIntent().getStringExtra("recommendation"); // 10c


        tvResultModeOfTransport.setText("Mode of Transport: " + mode + " (" + transportType + ")");


        tvResultDailyCost.setText("Daily Transport Cost: R" + String.format("%.2f", dailyCost));
        tvResultMonthlyCost.setText("Monthly Transport Cost: R" + String.format("%.2f", monthlyCost));
        tvResultMonthlyDistance.setText("Monthly Distance Travelled: " + String.format("%.2f", monthlyDistance) + " km");


        tvResultCategory.setText("Transport Cost Category: " + category);

        //  showing recommendation
        tvResultRecommendation.setText("Recommendation: " + recommendation);

        // Calculate Again
        btnResultCalculateAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, InputActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // exit
        btnResultExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}