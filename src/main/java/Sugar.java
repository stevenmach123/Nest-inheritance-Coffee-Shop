
public class Sugar extends CoffeeDecorator{

private double cost = 0;
	
	Sugar(Coffee specialCoffee, double c){
		super(specialCoffee);
		System.out.println("In Sugar");
		cost =c;
		
	}
	
	public double makeCoffee() {
		System.out.println("Sugar-makeCoffee");
		return specialCoffee.makeCoffee()+ addSugar();
	}
	public String displayOrder() {
		return specialCoffee.displayOrder()+"\n" +" + sugar: $"+cost;
		
	}
	private double addSugar() {
		
		return cost;
	}
	
}
