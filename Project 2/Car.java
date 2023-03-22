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