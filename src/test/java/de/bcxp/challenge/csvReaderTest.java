package de.bcxp.challenge;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class csvReaderTest{

    @Test
    void loadEmptyCsv(){
        List<String[]> empty = csvReader.csvToStringArray("src/main/resources/de/bcxp/challenge/empty.csv");
        assertTrue(empty.isEmpty());
    }
}