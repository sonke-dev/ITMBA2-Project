package com.example.mysummertive;

public class Recommendation {
    public String determineCategory(double monthlyTransportCost) {
        if (monthlyTransportCost < 1000) {
            return "Low Cost";
        } else if (monthlyTransportCost < 2000) {
            return "Moderate";
        } else if (monthlyTransportCost < 3000) {
            return "High";
        } else if (monthlyTransportCost < 5000) {
            return "Very High";
        } else {
            return "Excessive";
        }
    }



    public String determineRecommendation(double monthlyTransportCost) {
        String category = determineCategory(monthlyTransportCost);

        if (category.equals("Low Cost")) {
            return "Continue using your current transport method.";
        } else if (category.equals("Moderate")) {
            return "Consider carpooling where possible.";
        } else if (category.equals("High")) {
            return "Reduce unnecessary trips and combine errands.";
        } else if (category.equals("Very High")) {
            return "Consider public transport for regular commuting.";
        } else {
            return "Immediate action is recommended to reduce transport costs.";
        }
    }
}
