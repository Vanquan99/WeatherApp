package com.vanquan.weatherapp;

public class WeatherModel {
    private String time;
    private  String temperature;
    private String icon;
    private String windSpeed;

    public WeatherModel(String time, String temperator, String icon, String windSpeed) {
        this.time = time;
        this.temperature = temperator;
        this.icon = icon;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperator() {
        return temperature;
    }

    public void setTemperator(String temperator) {
        this.temperature = temperator;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
