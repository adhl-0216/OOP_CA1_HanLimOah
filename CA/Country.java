package CA;

import javax.swing.*;
import java.util.Arrays;

public class Country {
    private String name;
    private String capital;
    private int population;
    private int area;
    private City[] cities;
    private String currency;
    private String language;

    public Country(String name,
                   String capital,
                   int population,
                   int area,
                   City[] cities,
                   String currency,
                   String language) {
        setName(name);
        setCapital(capital);
        setPopulation(population);
        setArea(area);
        setCities(cities);
        setCurrency(currency);
        setLanguage(language);
    }

    @Override
    public String toString() {
        StringBuilder output =
                new StringBuilder("Name: " + getName() +
                        "\nCapital: " + getCapital() +
                        "\nPopulation: " + getPopulation() +
                        "\nArea: " + getArea() +
                        "\nCities: \n\n");
        for (City city : cities) {
            if (city != null) {
                output.append(city).append("\n");
            }
        }
        output.append("\nCurrency: ").append(getCurrency()).append("\nLanguage: ").append(getLanguage());
        return output.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = Math.max(population, 0);
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public City getMostPopulousCity(){
        int maxPopulation = Integer.MIN_VALUE;
        int targetIdx = 0;
        for (int i = 0; i < cities.length ; i++) {
            if (cities[i].getPopulation() > maxPopulation){
                maxPopulation = cities[i].getPopulation();
                targetIdx = i;
            }
        }
        return cities[targetIdx];
    }
    public void sortCitiesByName(){
        City[] arr = Arrays.copyOf(cities, cities.length);
        for (int i = 0; i < arr.length; i++) {
            int m = i;
            City temp;
            for (int j = i+1; j < arr.length-1; j++) {
                if (arr[j].getName().compareTo(arr[m].getName()) < 0){
                    m = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[m];
            arr[i] = temp;
        }
        StringBuilder output = new StringBuilder("The cities sorted by name are: \n\n");
        for (City city : arr) {
            if (city != null) {
                output.append(city).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, output, "Cities Sorted by Name", JOptionPane.INFORMATION_MESSAGE);
    }
}
