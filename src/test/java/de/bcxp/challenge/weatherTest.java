package de.bcxp.challenge;

import de.bcxp.challenge.weather.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class weatherTest{

    @Test
    void setUpDays(){
        /* 
        weatherDay w1 = new weatherDay("1", 19, 5);
        weatherDay w2 = new weatherDay("2", 33, 23);
        weatherDay w3 = new weatherDay("3", 24, 9);
        weatherDay w4 = new weatherDay("4", 5, (-8));
        List<weatherDay> weather = List.of(w1, w2, w3, w4);
        */

        String testFile = "src/main/resources/de/bcxp/challenge/weatherTestFile.csv";
        weatherTask task = new weatherTask(testFile);

        assertEquals(13, task.getWeatherDays().get(3).tempSpread());
        assertEquals("2", task.minTempSpread());

    }
}