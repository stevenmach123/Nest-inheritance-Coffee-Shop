
public class Cream extends CoffeeDecorator{

	private double cost = 0;
	Cream(Coffee specialCoffee,double c){
		super(specialCoffee);
		System.out.println("In Cream");
		cost =c;
	
		
	}
	
	public double makeCoffee() {
		System.out.println("Cream-makeCoffee");
		return specialCoffee.makeCoffee() + addCream();
		
	}
	public String displayOrder() {
		return specialCoffee.displayOrder()+"\n" +" + cream: $"+cost;
		
	}
	
	private double addCream() {
		
	
		
		return cost;
	}
}
