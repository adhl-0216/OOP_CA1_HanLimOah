package CA;

import javax.swing.*;

public class TestCountry {
    public static void main(String[] args) {
        City cork = new City("Cork", 124391, new Location(51.8985, 8.4756));
        City galway = new City("Galway", 79934, new Location(53.2707, 9.0568));
        City dublin = new City("Dublin", 544107, new Location(53.3498, 6.2603));
        City limerick = new City("Limerick", 194899, new Location(52.6638, 8.6267));
        City waterford = new City("Waterford", 53504, new Location(52.2593, 7.1101));

        City[] cities = new City[5];
        cities[0] = cork;
        cities[1] = galway;
        cities[2] = dublin;
        cities[3] = limerick;
        cities[4] = waterford;

        Country ireland = new Country("Ireland","Dublin",4904000,70273, cities, "euro", "English");

        JOptionPane.showMessageDialog(null, ireland, "Country Details", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                String.format("The distance between Limerick and Dublin is: %.2fkm " ,City.getDistanceBetween(limerick,dublin)),
                "Distance Between Limerick and Dublin", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "The details of the most populous city are: \n\n" + ireland.getMostPopulousCity(),
                "Details of the Most Populous City", JOptionPane.INFORMATION_MESSAGE);

        ireland.sortCitiesByName();

        System.exit(0);
    }
}
