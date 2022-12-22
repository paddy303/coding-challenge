package de.bcxp.challenge;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.List;


public class csvReader {

    //reads csvFile (excluding the first line with the attributes) and returns the lines as a list of strings
    public static List<String[]> csvToStringArray(String fileName){
        List<String[]> fileContents;
        try (CSVReader reader = new CSVReaderBuilder(new java.io.FileReader(fileName)).withSkipLines(1).build()){
            fileContents = reader.readAll();
        }
        catch (IOException | CsvException e){
            throw new RuntimeException(e);
        }
        if (fileContents.isEmpty()){
            System.out.println("WARNING: Loaded file is empty.");
        }
        return fileContents;
    } 

}