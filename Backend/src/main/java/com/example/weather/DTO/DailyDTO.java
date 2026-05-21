package com.example.weather.DTO;

public class DailyDTO {

    private String date;
    private double minTemp;
    private double maxTemp;
    private String condition;

    public DailyDTO(String date, double minTemp, double maxTemp, String condition) {
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.condition = condition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}