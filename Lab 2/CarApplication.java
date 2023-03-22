public class CarApplication {
    public static void main(String[] args) {
        Car A = new Car("Honda Civic", "2020", 24000.00, .02);
        Car B = new Car("Audi TT", "2000", 7000.00, .05);
        System.out.printf("Car A is a %s %s, it costs $%.2f, with a discount it actually costs $%.2f.%n", A.getYear(), A.getModel(), A.getPrice(), A.getDiscountPrice());
        System.out.printf("Car B is a %s %s, it costs $%.2f, with a discount it actually costs $%.2f.%n",B.getYear(), B.getModel(), B.getPrice(), B.getDiscountPrice());
    }
}
