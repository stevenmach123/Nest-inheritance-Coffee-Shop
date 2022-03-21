
public class Flavor extends CoffeeDecorator{

private double cost = 0;
	
     Flavor(Coffee specialCoffee,double c){
		super(specialCoffee);
		System.out.println("In Sugar");
		cost =c;
			
		
	}
	
	public double makeCoffee() {
		System.out.println("Flavor-makeCoffee");
		return specialCoffee.makeCoffee()+ addSugar();
	}
	
	public String displayOrder() {
		return specialCoffee.displayOrder()+"\n" +" + flavor: $"+cost;
		
	}
	
	private double addSugar() {
		
		
		
		return cost;
	}
}
