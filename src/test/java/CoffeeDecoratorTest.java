import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
class CoffeeDecoratorTest {
	Coffee order1; 
	Coffee order2; 
    double double1;
    double double2;
	@BeforeEach
	void init() {
		order1 = new BasicCoffee();
		order2 = new BasicCoffee();
		
	}
	
	@Test
	void eval_2Top() {
		 double1 = 0.4+0.1+3;
		 double2 = 1.3+0.4+3; 
		order1 = new Sugar( new Cream(order1,2),1);
		order2 = new Cream( new Flavor(order2,"3"),"2");
		assertEquals(double1,order1.makeCoffee());
		assertEquals(double2,order2.makeCoffee());
	}
	@Test 
	void eval_3Top(){
		double1 = 1.2+0.4+0.1+3;
		double2 = 1.3+1.2+0.4+3; 
		order1 = new Sugar(new Cream( new ExtraShot(order1,"Y"),"2"),"Y");
		order2 = new Cream(new ExtraShot( new Flavor(order2,"3"),"Y"),"2");
		assertEquals(double1,order1.makeCoffee());
		assertEquals(double2,order2.makeCoffee());
	}
	@Test
	void Ver1_3Top_2No() {
		double1 = 1.2+0.1+0.4+3;				
		order1 = new Season(new Sugar( new Cream(  new ExtraShot(new Flavor(order1,"2"),"N"),""),"Y"),"3");
		assertEquals(double1,order1.makeCoffee());
		
	}
	@Test 
	void Ver2_3Top_2No() {
		double2 = 1.2+ 0.1+0.4+3;
		order2 = new Season(new Sugar( new Cream(  new ExtraShot(new Flavor(order2,"2"),"N"),""),"Y"),"3");
		assertEquals(double2,order2.makeCoffee());
		
	}
	
	
	
	@Test
	void Ver1_3Top_With1No() {
		double1 = 1.2+0.1+3;	
		order1 =new Sugar(new Cream(new ExtraShot(order1,"Y"),""),"Y");	
		assertEquals(double1,order1.makeCoffee());
		
	}
	@Test
	void Ver2_3Top_With1No() {
		double2 = 0.2+0.3+3; 
		order2 = new Season(new Sugar(new Cream(order2,"3"),"N"),"2");
		assertEquals(double2,order2.makeCoffee());
	}
	
	
	
	@Test
	void Ver1_4Top() {
		double1 = 1.2+1.2+0.2+0.1+3;
		order1 =new Sugar(new Cream(new ExtraShot(new Flavor(order1,"2"),"Y"),"3"),"Y");	
		assertEquals(double1,order1.makeCoffee());
		
	}
	@Test
	void Ver2_4Top() {
		double2 = 1.2+0.4+0.1+0.3+3; 
		order2 = new Season(new Sugar(new Cream( new ExtraShot(order2,"Y"),"2"),"Y"),"2");
		assertEquals(double2,order2.makeCoffee());
	}
	
	@Test
    void Ver1_2Top_2No() {
		double1 = 1.3+0.1+3;		
		order1 =new Season(new Sugar(new ExtraShot(new Flavor(order1,"3"),""),"Y"),"");	
		assertEquals(double1,order1.makeCoffee());
		
	}
	@Test
	void Ver2_2Top_2No(){
		double2 = 1.2+0.4+3; 
		order2 = new Season(new Cream(new ExtraShot( new Flavor(order2,""),"Y"),""),"3");
		assertEquals(double2,order2.makeCoffee());
	}
	

}
