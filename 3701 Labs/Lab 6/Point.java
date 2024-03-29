public class Point{
	private double x;
	private double y;

public Point (double x, double y){
		this.x = x;
		this.y = y;
	}
	public double getY(){
		return y;
	}

	public double getX(){
		return x;
	}

	@Override
	public String toString(){
		return String.format("(%.1f, %.1f)",getX(), getY());
	}


}