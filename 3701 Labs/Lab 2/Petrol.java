public class Petrol{
	public static void main(String[] args) {
		PetrolPurchase p = new PetrolPurchase("Shell", "Octane 88", 10, 5.00, .02);

		System.out.printf("At the %s gas station, I bought %d liters of %s that cost %.2f per liter. I had a dicount of %.2f percent. The total cost was  $%.2f", p.getLocation(), p.getLiters(), p.getType(), p.getPrice(), p.getDiscount(), p.getPurchaseAmount());
	}
}