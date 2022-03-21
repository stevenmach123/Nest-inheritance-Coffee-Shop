
public class BasicCoffee implements Coffee {

	private double cost = 3.0;
	
	@Override
	public double makeCoffee() {

		
		
		return cost;
	}
	public String displayOrder() {
		return  "Black Coffee: $3.0";
	}
	

}
