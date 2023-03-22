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
