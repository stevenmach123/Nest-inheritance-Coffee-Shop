

import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyController   {
	
	
	@FXML
	 private Button flavor1;
	 @FXML
	 private Button flavor2;
	@FXML
	private Button flavor3;
	@FXML
	private Button flavor4;
	@FXML  
	 private Button detail;
	
	@FXML
	 private Button extra1;
	@FXML
	 private Button extra2;
	  
	@FXML
	 private Button cream1;
	@FXML
	 private Button cream2;
	@FXML
	private Button cream3;
	@FXML 
	private Button sugar1;
	@FXML 
	private Button sugar2;
	
	
	@FXML
	private Button cream4;
	@FXML 
	private Button season1;
	@FXML 
	private Button season2;
	@FXML 
	private Button season3;
	@FXML 
	private Button season4;
	
	
	@FXML 
	private Text detail_t;
	
	@FXML
	private Button place;
	
	@FXML
	private Button cancel;
	@FXML
	private Button pay;
	@FXML
	private Text my_order;
	@FXML
	private VBox root;
	
	@FXML
	private BorderPane root2;
    
    @FXML
    private TextField textField;
    
    @FXML
    private TextField putText;
    
    //static so each instance of controller can access to update 
    private static String textEntered = "";
    Coffee order = new BasicCoffee();
	double cream; //temporary variable for each ingredient 
    double extra; 
    double flavor; 
    double sugar;
    double season;
    int time_order =0;   //count #order per customer
	double total_cost  =0; 
	double cost_per_order =0; //cost of per order
	
	
	@FXML
	public void initialize() {
		System.out.println("init");
		// TODO Auto-generated method stub
		root.getChildren().add(new TextField("aa"));
        
	}
	
	public void deact() {
		cream1.setDisable(true);
		cream2.setDisable(true);
		cream3.setDisable(true);
		cream4.setDisable(true);
		
		flavor1.setDisable(true);
		flavor2.setDisable(true);
		flavor3.setDisable(true);
		flavor4.setDisable(true);
		
		extra1.setDisable(true);
		extra2.setDisable(true);
		sugar1.setDisable(true);
		sugar2.setDisable(true);
		season1.setDisable(true);
		season2.setDisable(true);
		season3.setDisable(true);
		season4.setDisable(true);
	}
	public void act() {
		cream1.setDisable(false);
		cream2.setDisable(false);
		cream3.setDisable(false);
		cream4.setDisable(false);
		
		flavor1.setDisable(false);
		flavor2.setDisable(false);
		flavor3.setDisable(false);
		flavor4.setDisable(false);
		
		extra1.setDisable(false);
		extra2.setDisable(false);
		sugar1.setDisable(false);
		sugar2.setDisable(false);
		season1.setDisable(false);
		season2.setDisable(false);
		season3.setDisable(false);
		season4.setDisable(false);
	}
	//switch button and change cost of flavor; 
	public void  fla1(ActionEvent e) throws IOException{
		 flavor1.setStyle("-fx-background-color: blue");
		 flavor2.setStyle("");
		 flavor3.setStyle("");
		 flavor4.setStyle("");
		 flavor = 1;
		
	}
	public void  fla2(ActionEvent e) throws IOException{
		 flavor1.setStyle("");
		 flavor2.setStyle("-fx-background-color: red");
		 flavor3.setStyle("");
		 flavor4.setStyle("");
		 flavor=1.2;
		 
	}
	
	public void  fla3(ActionEvent e) throws IOException{
		 flavor1.setStyle("");
		 flavor2.setStyle("");
		 flavor3.setStyle("-fx-background-color: red");
		 flavor4.setStyle("");
		 flavor=1.3;
	}
	//no for flavor
	public void  fla4(ActionEvent e) throws IOException{
		 flavor1.setStyle("");
		 flavor2.setStyle("");
		 flavor3.setStyle("");
		 flavor4.setStyle("-fx-background-color: red");
		 flavor =0;
	}
	
	//switch button and change cost of extrashot; 
	public void  ext1(ActionEvent e) throws IOException{
		 extra1.setStyle("-fx-background-color: red");
		 extra2.setStyle("");
		 extra =1.2 ;
		
	}
	public void  ext2(ActionEvent e) throws IOException{
		 extra1.setStyle("");
		 extra2.setStyle("-fx-background-color: red");
		 extra =0;
		 
	}      
	//switch button and change cost of cream; 
	public void  cre1(ActionEvent e) throws IOException{
		cream1.setStyle("-fx-background-color: red");
		cream2.setStyle("");
		cream3.setStyle("");
		cream4.setStyle("");
		cream = 0.5;
		
	}
	public void  cre2(ActionEvent e) throws IOException{
		cream1.setStyle("");
		cream2.setStyle("-fx-background-color: red");
		cream3.setStyle("");
		cream4.setStyle("");
		cream =0.4;
	}
	public void  cre3(ActionEvent e) throws IOException{
		cream1.setStyle("");
		cream2.setStyle("");
		cream3.setStyle("-fx-background-color: red");
		cream4.setStyle("");
		cream =0.2;
	}
	public void  cre4(ActionEvent e) throws IOException{
		cream1.setStyle("");
		cream2.setStyle("");
		cream3.setStyle("");
		cream4.setStyle("-fx-background-color: red");
		cream =0;
	}
	//switch button and change cost of sugar; 
	public void  sug1(ActionEvent e) throws IOException{
		sugar1.setStyle("-fx-background-color: red");
		sugar2.setStyle("");
		
		
		sugar=0.1;
	}
	public void  sug2(ActionEvent e) throws IOException{
		sugar1.setStyle("");
		sugar2.setStyle("-fx-background-color: red");		
		
		sugar=0;
	}
	//switch button and change cost of season; 
	public void  sea1(ActionEvent e) throws IOException{
		season1.setStyle("-fx-background-color: red");
		season2.setStyle("");
		season3.setStyle("");
		season4.setStyle("");
		season =0.2;
	}	
	public void  sea2(ActionEvent e) throws IOException{
		season1.setStyle("");
		season2.setStyle("-fx-background-color: red");
		season3.setStyle("");
		season4.setStyle("");
		season =0.3;
	}	
	public void  sea3(ActionEvent e) throws IOException{
		season1.setStyle("");
		season2.setStyle("");
		season3.setStyle("-fx-background-color: red");
		season4.setStyle("");
		season =0.4;
	}	
	public void  sea4(ActionEvent e) throws IOException{
		season1.setStyle("");
		season2.setStyle("");
		season3.setStyle("");
		season4.setStyle("-fx-background-color: red");
		season =0;
	}	
	
	
	
	public void  Detail(ActionEvent e) throws IOException{
		
		
		
		// if those temporary cost variable !=0, implement those classes nested order;
		if(flavor!=0) {
			order = new Flavor(order,flavor);
		}
		if(extra!=0) {
			order = new ExtraShot(order,extra);
		}
		if(cream!=0) {
			order = new Cream(order,cream);
		}
		if(sugar!=0) {
			order = new Sugar(order,sugar);
		}
		if(season!=0) {
			order = new Season(order,season);
		}
		cost_per_order =order.makeCoffee();
		
		detail_t.setText(order.displayOrder()+"\n"+"  Total: $"+cost_per_order); // display info of per order
		deact();
		detail.setDisable(true);   //set detail button, option ingredients disable
		place.setDisable(false); //set detail place, cancel order able
		cancel.setDisable(false);
		
	}
	
	public void  Place(ActionEvent e) throws IOException{
	
		cost_per_order =order.makeCoffee();
		total_cost += cost_per_order;
		time_order +=1;
		place.setDisable(true); //set detail button, option ingredients able
		cancel.setDisable(true);//set detail place, cancel order disable
		detail.setDisable(false);
		act();
		detail_t.setText("");
		my_order.setText("Time Orders: "+time_order+" Total Cost: "+total_cost); //display total order and total cost per customer
		order = new BasicCoffee();	
		
	}
	
	public void  Cancel(ActionEvent e) throws IOException{
		place.setDisable(true);
		cancel.setDisable(true);//set detail place, cancel order disable
		detail.setDisable(false);//set detail button, option ingredients able
		detail_t.setText("");
		act();
		order = new BasicCoffee();
	}
	//pay and next customer,
	public void  Pay(ActionEvent e) throws IOException{
		total_cost = 0;
		time_order =0;
		detail_t.setText("");	
		detail.setDisable(false);
		cancel.setDisable(true);
		place.setDisable(true);
		my_order.setText("Time Orders: "+time_order+" Total Cost: "+total_cost);
		
		
		act();
		order = new BasicCoffee();
		
	}
	
  
	
	

}
