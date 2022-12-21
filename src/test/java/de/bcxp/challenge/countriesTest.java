package de.bcxp.challenge;

import de.bcxp.challenge.country.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


class countriesTest{

    @Test
    void populationDensity(){
        /* Overview of the relevant test file data
        country c1 = new country("USA", 50000, 4000);
        country c2 = new country("USB", 60000, 4500);
        country c3 = new country("USC", 55000, 4600);

        List<country> usNations = List.of(c1, c2, c3);
        */
        String testFile = "src/main/resources/de/bcxp/challenge/countriesTestFile.csv";
        countryTask task = new countryTask(testFile);

        //check if the correct fictional country will be selected as the one with highest population density
        assertEquals("USB", task.maxPopulationDensity());
        assertEquals(13.333333015441895, task.getCountries().get(1).populationDensity());
    }

}