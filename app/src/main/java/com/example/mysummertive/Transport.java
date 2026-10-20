package com.example.mysummertive;

public class Transport {
    private String modeOfTransport;
    private String transportType;
    private String recommendation;
    private String transportCostCategory;
    private String dateReport;

    private double distanceTravelled;
    private double costPerKilometre;
    private double dailyTransportCost;
    private double monthlyTransportCost;
    private double monthlyTravelDistance;

    private int travelDays;


    //default constructor
    public Transport() {
    }


    //parameterised constructor
    public Transport(String modeOfTransport, String transportType, double distanceTravelled,
                     double costPerKilometre, int travelDays, double dailyTransportCost, double monthlyTransportCost,
                     double monthlyTravelDistance, String transportCostCategory, String recommendation, String dateReport) {
        this.modeOfTransport = modeOfTransport;
        this.transportType = transportType;
        this.distanceTravelled = distanceTravelled;
        this.costPerKilometre = costPerKilometre;
        this.travelDays = travelDays;
        this.dailyTransportCost = dailyTransportCost;
        this.monthlyTransportCost = monthlyTransportCost;
        this.monthlyTravelDistance = monthlyTravelDistance;
        this.transportCostCategory = transportCostCategory;
        this.recommendation = recommendation;
        this.dateReport = dateReport;
    }

    //get and set for modeOfTransport
    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }


    //get and set for transportType
    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    //get and set for distanceTravelled
    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    //get and set for costPerKilometre
    public double getCostPerKilometre() {
        return costPerKilometre;
    }

    public void setCostPerKilometre(double costPerKilometre) {
        this.costPerKilometre = costPerKilometre;
    }

    //get and set for travelDays
    public int getTravelDays() {
        return travelDays;
    }

    public void setTravelDays(int travelDays) {
        this.travelDays = travelDays;
    }

    //get and set for dateReport
    public String getDateReport() {
        return dateReport;
    }

    public void setDateReport(String dateReport) {
        this.dateReport = dateReport;
    }

    //get and set for dailyTransportCost
    public double getDailyTransportCost() {
        return dailyTransportCost;
    }

    public void setDailyTransportCost(double dailyTransportCost) {
        this.dailyTransportCost = dailyTransportCost;
    }

    //get and set for monthlyTransportCost
    public double getMonthlyTransportCost() {
        return monthlyTransportCost;
    }

    public void setMonthlyTransportCost(double monthlyTransportCost) {
        this.monthlyTransportCost = monthlyTransportCost;
    }

    //get and set for monthlyTravelDistance
    public double getMonthlyTravelDistance() {
        return monthlyTravelDistance;
    }

    public void setMonthlyTravelDistance(double monthlyTravelDistance) {
        this.monthlyTravelDistance = monthlyTravelDistance;
    }

    //get and set for transportCostCategory
    public String getTransportCostCategory() {
        return transportCostCategory;
    }

    public void setTransportCostCategory(String transportCostCategory) {
        this.transportCostCategory = transportCostCategory;
    }


    //get and set for recommendation
    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
