
public class ExtraShot extends CoffeeDecorator {

	private double cost = 0;
	
	ExtraShot(Coffee specialCoffee,double c){
		super(specialCoffee);
		System.out.println("In ExtraShot");
		cost=c;
		
	}
	
	public double makeCoffee() {
		System.out.println("ExtraShot-makeCoffee");
		return specialCoffee.makeCoffee() + addShot();
	}
	public String displayOrder() {
		return specialCoffee.displayOrder()+"\n" +" + extra-shot: $"+cost;
		
	}
	
	private double addShot() {
	
		
		return cost;
	}
}
