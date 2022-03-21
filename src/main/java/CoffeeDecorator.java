
abstract class CoffeeDecorator implements Coffee{
protected Coffee specialCoffee;
	
	public CoffeeDecorator(Coffee specialCoffee) {
		System.out.println("in CoffeeDecorator");
		this.specialCoffee = specialCoffee;
	}
	
	public double makeCoffee() {
		System.out.println("CoffeeDecorator-makeCoffee");
		return specialCoffee.makeCoffee();
	}
}
