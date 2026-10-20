package com.example.mysummertive;

public class TransportCalculator {

    public double calculateDailyCost(double distancePerDay, double costPerKilometre) {
        return distancePerDay * costPerKilometre;
    }

    public double calculateMonthlyCost(double dailyTransportCost, int travelDays){
        return dailyTransportCost * travelDays;
    }

    public double calculateMonthlyDistanceCost(double distanceTravelledPerDay, int travelDays){
        return distanceTravelledPerDay * travelDays;
    }
}
