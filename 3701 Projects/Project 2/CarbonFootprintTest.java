import java.util.ArrayList;

interface CarbonFootprint {
    double getCarbonFootprint();
}
class Building implements CarbonFootprint {
    private int squareFootage;
    private int occupants;

    public Building(int squareFootage, int occupants) {
        this.squareFootage = squareFootage;
        this.occupants = occupants;
    }

    public double getCarbonFootprint() {
        return squareFootage * 0.05 + occupants * 0.02;
    }
}

class Car implements CarbonFootprint {
    private double milesPerGallon;
    private double gallonsPerYear;

    public Car(double milesPerGallon, double gallonsPerYear) {
        this.milesPerGallon = milesPerGallon;
        this.gallonsPerYear = gallonsPerYear;
    }

    public double getCarbonFootprint() {
        return gallonsPerYear * 19.4 / milesPerGallon;
    }
}

class Bicycle implements CarbonFootprint {
    private double milesPerYear;

    public Bicycle(double milesPerYear) {
        this.milesPerYear = milesPerYear;
    }

    public double getCarbonFootprint() {
        return milesPerYear * 0;
    }
}

public class CarbonFootprintTest {
    public static void main(String[] args) {
        ArrayList<CarbonFootprint> items = new ArrayList<CarbonFootprint>();
        items.add(new Building(1000, 4));
        items.add(new Car(30, 1000));
        items.add(new Bicycle(500));

        for (CarbonFootprint item : items) {
            System.out.println(item.getClass().getSimpleName() + " carbon footprint: " + item.getCarbonFootprint() + " metric tons");
        }
    }
}
