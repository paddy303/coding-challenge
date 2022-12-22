package de.bcxp.challenge.country;

// Used by countryTask to represent the required data of a single country

public class country {
    private String name;
    private float population;
    private float area;

    public country(String name, float population, float area){
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName(){
        return name;
    }

    public double populationDensity(){
        return population / area;
    }
}
