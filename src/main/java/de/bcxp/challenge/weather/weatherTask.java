package de.bcxp.challenge.weather;

import de.bcxp.challenge.csvReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
 * Creates a list of the single weather days (of class weatherDay) based on the given csv file 
 * and operates on it (e.g. to compare the respective temperature spreads)
 */

public class weatherTask {

    List<weatherDay> weatherData;

    public weatherTask(String weatherFile){
        this.weatherData = importWeatherFromFile(weatherFile);
    }
    
    public List<weatherDay> importWeatherFromFile(String fileName){
        //initialize empty list, then reads file and inserts the data for the task
        List<weatherDay> daysWithTemperatures = new ArrayList<>();
        List<String[]> fileContent = csvReader.csvToStringArray(fileName);
        for (String[] stringLine : fileContent){
            List<String> line = Arrays.stream(Arrays.toString(stringLine).split(",")).collect(Collectors.toList());
            daysWithTemperatures.add(dataStringToInt(line.get(0), line.get(1), line.get(2)));
        }
        return daysWithTemperatures;
    }

    public List<weatherDay> getWeatherDays(){
        return this.weatherData;
    }

    private weatherDay dataStringToInt(String day, String maxTemp, String minTemp) {
        //converts the required data from type String to Int and removes unnecessary whitespaces and other regular expressions
        try{ 
            String parsedDay = day.replaceAll("\\s+", "").replaceAll("\\[", "");
            int parsedMaxTemp = Integer.parseInt(maxTemp.replaceAll("\\s+", ""));
            int parsedMinTemp = Integer.parseInt(minTemp.replaceAll("\\s+", "").replaceAll("]", ""));
            return new weatherDay(parsedDay, parsedMaxTemp, parsedMinTemp);
        } catch (NumberFormatException e){
            System.out.printf("The given String could not be converted to a number."
                            + " Please check your input file for correctness. (Day: %s)\n", day);
            //e.printStackTrace(); 
            return new weatherDay("failed", 100, 0);
        }
    }

    public String minTempSpread(){
        //compares temperature spreads of each day and returns the day with the smallest difference
        weatherDay res = this.weatherData.get(0);
        for (int i = 1; i < this.weatherData.size(); i++){
            if (res.tempSpread() > this.weatherData.get(i).tempSpread()){
                res = this.weatherData.get(i);
            }
        }
        return res.getDay();
    }

}
