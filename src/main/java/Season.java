
public class Season extends CoffeeDecorator{

private double cost = 0;
	
     Season(Coffee specialCoffee,double c){
		super(specialCoffee);
		System.out.println("In Sugar");
		cost= c;
	
	}
     
	
 	public String displayOrder() {
		return specialCoffee.displayOrder()+"\n" +" + season: $"+cost;
		
	}
     
	public double makeCoffee() {
		System.out.println("Season-makeCoffee");
		return specialCoffee.makeCoffee()+ addSugar();
	}
	
	
	
	private double addSugar() {				
		return cost;
	}
}
