package de.bcxp.challenge.country;

public class countryData {
    private String name;
    private float population;
    private float area;
    //either change population or area to double (in order to make the division less complicated); probably rather area since it's a smaller number

    public countryData(String name, float population, float area){
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
