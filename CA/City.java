package CA;

public class City {
    private String name;
    private int population;
    private Location location;

    public City(String name, int population, Location location) {
        setName(name);
        setPopulation(population);
        setLocation(location);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Location getLocation() {
        return new Location(location.getLatitude(), location.getLongitude());
    }

    public void setLocation(Location location) {
        this.location = new Location(location.getLatitude(), location.getLongitude());
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "  Population: " + getPopulation() +
                "  Location: " + getLocation();
    }

    public static double getDistanceBetween(City city1, City city2){
        double[] city1Loc = {city1.getLocation().getLatitude(),city1.getLocation().getLongitude()};
        double[] city2Loc = {city2.getLocation().getLatitude(),city2.getLocation().getLongitude()};
        double city2LatInRads = Math.PI*city2Loc[0]/180;
        double distance = Math.pow(city1Loc[0]-city2Loc[0],2)+Math.pow(((city1Loc[1]-city2Loc[1])*Math.cos(city2LatInRads)),2);
        return 110.25*(Math.sqrt(distance));
    }
}
