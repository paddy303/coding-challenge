package de.bcxp.challenge;

import de.bcxp.challenge.country.countryTask;
import de.bcxp.challenge.weather.weatherTask;


/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        String weatherFile = "src/main/resources/de/bcxp/challenge/weather.csv";
        weatherTask weatherApp = new weatherTask(weatherFile);

        String countriesFile = "src/main/resources/de/bcxp/challenge/countries.csv";
        countryTask countryApp = new countryTask(countriesFile);
        

        String dayWithSmallestTempSpread = weatherApp.minTempSpread(); // Your day analysis function call … 
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = countryApp.maxPopulationDensity(); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
