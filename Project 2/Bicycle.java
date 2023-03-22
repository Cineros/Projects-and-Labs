class Bicycle implements CarbonFootprint {
    private double milesPerYear;

    public Bicycle(double milesPerYear) {
        this.milesPerYear = milesPerYear;
    }

    public double getCarbonFootprint() {
        return milesPerYear * 0;
    }
}