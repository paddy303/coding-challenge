package de.bcxp.challenge.country;

import de.bcxp.challenge.csvReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
 * Creates a list of the single countries (of class country) based on the given csv file 
 * and operates on it (e.g. to compare the respective population data)
 */

public class countryTask {

    List<country> countries;

    public countryTask(String fileName){
        this.countries = countriesFromFile(fileName);
    }
    
    public List<country> countriesFromFile(String fileName){
        //initialize empty list, then reads file and inserts the data for the task
        List<country> countriesAndPopulationData = new ArrayList<>();
        List<String[]> fileContent = csvReader.csvToStringArray(fileName);
        for (String[] stringLine : fileContent){
            List<String> line = Arrays.stream(Arrays.toString(stringLine).split(";")).collect(Collectors.toList());
            countriesAndPopulationData.add(dataStringToFloat(line.get(0), line.get(3), line.get(4)));
        }
        return countriesAndPopulationData;
    }

    public List<country> getCountries(){
        return this.countries;
    }

    private country dataStringToFloat(String name, String population, String area){
        //converts the required data from type String to Int and removes unnecessary whitespaces and other regular expressions
        try{ 
            String parsedName = name.replaceAll("\\s+", "").replaceAll("\\[", "");
            float parsedPopulation = Float.parseFloat(population.replaceAll("\\.", "")
                .replaceAll(",.+", "") //removed every character after comma since population cant be a fractional number anyway
                .replaceAll("\\s+", ""));
            float parsedArea = Float.parseFloat(area.replaceAll("\\s+", "").replaceAll("]", ""));
            return new country(parsedName, parsedPopulation, parsedArea);
        } catch (NumberFormatException e){
            System.out.printf("The given String could not be converted to a number."
                             + " Please check your input file for correctness (Country: %s).", name);
            //e.printStackTrace();
            return new country("failed", 0, 1);
        }
    }

    public String maxPopulationDensity(){
        //compares countries by population density and returns country with highest value
        country res = this.countries.get(0);
        for (int i = 1; i < this.countries.size(); i++){
            if (res.populationDensity() < this.countries.get(i).populationDensity()){
                res = this.countries.get(i);
            }
        }
        return res.getName();
    }

}
