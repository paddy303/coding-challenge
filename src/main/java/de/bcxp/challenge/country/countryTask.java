package de.bcxp.challenge.country;

import de.bcxp.challenge.csvReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


public class countryTask {

    List<countryData> country;

    public countryTask(){
        this.country = getCountriesFromFile("src/main/resources/de/bcxp/challenge/countries.csv");
    }
    
    public List<countryData> getCountriesFromFile(String fileName){
        //initialize empty list, then reads file and inserts the data for the task
        List<countryData> countriesAndPopulationData = new ArrayList<>();
        List<String[]> fileContent = csvReader.csvToStringArray(fileName);
        for (String[] stringLine : fileContent){
            List<String> line = Arrays.stream(Arrays.toString(stringLine).split(";")).collect(Collectors.toList());
            countriesAndPopulationData.add(dataStringToFloat(line.get(0), line.get(3), line.get(4)));
        }
        return countriesAndPopulationData;
    }

    private countryData dataStringToFloat(String name, String population, String area){
        //converts the required data from type String to Int and removes unnecessary whitespaces and other regular expressions 
        String parsedName = name.replaceAll("\\[", "").replaceAll("\\s+", "");
        float parsedPopulation = Float.parseFloat(population.replaceAll("\\.", "")
            .replaceAll(",.+", "") //removed every character after comma since population cant be a fractional number anyway
            .replaceAll("\\s+", ""));
        float parsedArea = Float.parseFloat(area.replaceAll("\\s+", "").replaceAll("]", ""));
        return new countryData(parsedName, parsedPopulation, parsedArea);
    }

    public String maxPopulationDensity(){//List<countryData> countriesAndPopulationData){
        //compares countries by population density and returns country with highest value
        countryData res = this.country.get(0);//countriesAndPopulationData.get(0);
        for (int i = 1; i < this.country.size(); i++){
            if (res.populationDensity() < this.country.get(i).populationDensity()){
                res = this.country.get(i);
            }
        }
        return res.getName();
    }

}
