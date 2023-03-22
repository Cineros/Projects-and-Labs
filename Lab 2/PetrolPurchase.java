public class PetrolPurchase{

	private String location;
	private String type;
	private int liters;
	private double price;
	private double discount;

	public PetrolPurchase(String location, String type, int liters, double price, double discount){

		this.location = location;
		this.type = type;
		this.liters = liters;
		this.price = price;
		this.discount = discount;

	}
	public void setLocation(String location){
		this.location = location;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setLiters(int liters){
		this.liters = liters;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setDiscount(double discount){
		this.discount = discount;
	}

	public String getLocation(){return location;}
	public String getType(){return type;}
	public int getLiters(){return liters;}
	public double getPrice(){return price;}
	public double getDiscount(){return discount;}

	public double getPurchaseAmount(){
		return (liters*price)-(liters*(price*discount));
	}

}