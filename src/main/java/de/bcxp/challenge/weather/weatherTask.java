package de.bcxp.challenge.weather;

import de.bcxp.challenge.csvReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


public class weatherTask {

    List<weatherData> weather;

    public weatherTask(){
        this.weather = getDayTemperaturesFromFile("src/main/resources/de/bcxp/challenge/weather.csv");
    }
    
    public List<weatherData> getDayTemperaturesFromFile(String fileName){
        //initialize empty list, then reads file and inserts the data for the task
        List<weatherData> daysWithTemperatures = new ArrayList<>();
        List<String[]> fileContent = csvReader.csvToStringArray(fileName);
        for (String[] stringLine : fileContent){
            List<String> line = Arrays.stream(Arrays.toString(stringLine).split(",")).collect(Collectors.toList());
            daysWithTemperatures.add(dataStringToInt(line.get(0), line.get(1), line.get(2)));
        }
        return daysWithTemperatures;
    }

    private weatherData dataStringToInt(String day, String maxTemp, String minTemp) {
        //converts the required data from type String to Int and removes unnecessary whitespaces and other regular expressions 
        String parsedDay = day.replaceAll("\\[", "").replaceAll("\\s+", "");
        int parsedMaxTemp = Integer.parseInt(maxTemp.replaceAll("\\s+", ""));
        int parsedMinTemp = Integer.parseInt(minTemp.replaceAll("\\s+", "").replaceAll("]", ""));
        return new weatherData(parsedDay, parsedMaxTemp, parsedMinTemp);
    }

    public String minTempSpread(){//List<weatherData> daysWithTemperatures){
        //compares temperature spreads of each day and returns the day with the smallest difference
        weatherData res = this.weather.get(0);//daysWithTemperatures.get(0);
        for (int i = 1; i < this.weather.size(); i++){
            if (res.tempSpread() > this.weather.get(i).tempSpread()){
                res = this.weather.get(i);
            }
        }
        return res.getDay();
    }

}
