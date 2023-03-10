package de.bcxp.challenge.weather;

// Used by weatherTask to represent the required data of a single weather day

public class weatherDay {
    private String day;
    private int maxTemp;
    private int minTemp;

    public weatherDay(String day, int maxTemp, int minTemp){
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDay(){
        return this.day;
    }

    public int tempSpread(){
        return this.maxTemp - this.minTemp;
    }
}