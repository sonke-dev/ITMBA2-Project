package com.example.mysummertive;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "transport.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "transport_reports";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "mode_of_transport TEXT, " +
                "transport_type TEXT, " +
                "distance_travelled REAL, " +
                "cost_per_km REAL, " +
                "travel_days INTEGER, " +
                "daily_cost REAL, " +
                "monthly_cost REAL, " +
                "monthly_distance REAL, " +
                "cost_category TEXT, " +
                "recommendation TEXT, " +
                "date_created TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertReport(Transport transport) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mode_of_transport", transport.getModeOfTransport());
        values.put("transport_type", transport.getTransportType());
        values.put("distance_travelled", transport.getDistanceTravelled());
        values.put("cost_per_km", transport.getCostPerKilometre());
        values.put("travel_days", transport.getTravelDays());
        values.put("daily_cost", transport.getDailyTransportCost());
        values.put("monthly_cost", transport.getMonthlyTransportCost());
        values.put("monthly_distance", transport.getMonthlyTravelDistance());
        values.put("cost_category", transport.getTransportCostCategory());
        values.put("recommendation", transport.getRecommendation());
        values.put("date_created", transport.getDateReport());

        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }
}