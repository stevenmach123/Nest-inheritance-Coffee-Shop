
import javafx.application.Application;


import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font; 
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CoffeeShop extends Application {
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	int time_order =0;
	double total_cost  =0; 
	double cost_per_order =0;
	
  
    
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("Who want's coffee!!!");
		
		
		 try {
	            // Read file fxml and draw interface.
			 System.out.println("start");
	            Parent root = FXMLLoader.load(getClass()
	                    .getResource("/FXML/ha.fxml"));
	            
	            
	            
	            primaryStage.setTitle("My Application");
	            Scene s1 = new Scene(root);
	            
	            s1.getStylesheets().add("/Style/style.css");
	            
	            primaryStage.setScene(s1);
	            primaryStage.show();
	         
	        } catch(Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
		 
		
		
		TextField t_cream = new TextField("asdasd");
		t_cream.setMaxWidth(80);
		t_cream.setStyle("-fx-background-color:#ff4d4d");
		TextField t_sugar = new TextField("");
		t_sugar.setMaxWidth(80);
		TextField t_shot = new TextField("");
		t_shot.setMaxWidth(80);
		TextField t_flavor = new TextField("777");
		t_flavor.setMaxWidth(80);
		TextField t_season = new TextField("");
		t_season.setMaxWidth(80);
		
	
		
		Text remind = new Text("LEAVEs BLANK WHEN NO NEED, AND NO SPACE.THANK!");
		remind.setFont(Font.font("verdana",FontWeight.BOLD,15));
		
		VBox box = new VBox(5);
		
		VBox box1 = new VBox(3);
		
		box1.getChildren().addAll(new Text("aaa"));
		Text cr = new Text("3.light $0.222");
		box1.getChildren().add(cr);
		
		Text welcome = new Text("WELCOME TO BLACKCOFFE SHOP!");
		welcome.setFont(Font.font("verdana",FontWeight.BOLD,30));
	    
		//cream price board
		HBox bcream = new HBox(60);	
		Text cream1 = new Text("CREAM:  1.heavy $0.5");
		Text cream2 = new Text("2.half-half $0.4");
		Text cream3 = new Text("3.light $0.2");
		
		bcream.getChildren().addAll(cream1, cream2, cream3, new Text("Type '1' or '2' or '3' for option."));
        //sugar price board
		HBox bsugar = new HBox(60);
		Text sugar1 = new Text("SUGAR: $0.1"); 
		bsugar.getChildren().addAll(sugar1,new Text("Type 'y' for yes or 'n' for no "));
		// shot price board
		HBox bshot = new HBox(60);
		Text shot1 = new Text("EXTRA-SHOT: $1.2");
		bshot.getChildren().addAll(shot1,new Text("Type 'y' for yes or 'n' for no "));
		
		//flavor price board
		HBox bflavor = new HBox(60);
		Text flavor1 = new Text("FLAVOR:  1.capochi $1.0");
		Text flavor2 = new Text("2.choco $1.2");
		Text flavor3 = new Text("3.mint $1.3");
	  
		bflavor.getChildren().addAll(flavor1, flavor2, flavor3,new Text("Type '1' or '2' or '3' for option"));
        
			
		//season price board
		HBox bseason = new HBox(60);
		Text season1 = new Text("SEASON:  1.brown $0.2");
		Text season2 = new Text("2.pepperoni $0.3");
		Text season3 = new Text("3.greentea $0.4");
		bseason.getChildren().addAll(season1, season2, season3,new Text("Type '1' or '2' or '3' for option"));
		
		//detail, place, cancel button
		Button detail = new Button("DETAIL");
		Text detail_text = new Text("");
		HBox bot = new HBox(30);
 		Button place = new Button("PLACE ORDER");
		Button cancel = new Button("CANCEL ORDER");
		Button pay_next = new Button("PAY & NEXT CUSTOMER");
		bot.getChildren().addAll(place,cancel,pay_next);
		place.setDisable(true);
		cancel.setDisable(true);
		
		
		Text my_order_text  = new Text("Time Orders: "+time_order+"Total Cost: "+total_cost);
		box.getChildren().addAll(remind,bflavor,t_flavor,bshot,t_shot,bcream,t_cream,bsugar,t_sugar,bseason,t_season,detail,detail_text,bot,my_order_text);
		
		
		
		
		
		
		//Want to know detail of your order ? 
		detail.setOnAction(e->{	
			// evaluate  character inserted, should be either 1,2,3 or y,n 	
			if(evalNum(t_flavor.getText())==true && evalNum(t_season.getText()) ==true  && evalNum(t_cream.getText()) ==true 
			   && evalY(t_sugar.getText())==true &&   evalY(t_shot.getText())==true   ){
			    System.out.println("in here!!2");
			    Coffee order = new BasicCoffee();
			    //if not blank, or No, then add order with extra topping
			   
				if(!t_flavor.getText().equals("")) {
					order = new Flavor(order,Double.valueOf(t_flavor.getText()));
				}
				if(!t_shot.getText().equals("n") && !t_shot.getText().equals("N") && !t_shot.getText().equals("")) {
					order = new ExtraShot(order,Double.valueOf(t_shot.getText()));
				}
				if(!t_cream.getText().equals("")) {
					order = new Cream(order,Double.valueOf(t_cream.getText()));
				}
				if(!t_sugar.getText().equals("n") && !t_sugar.getText().equals("N") && !t_sugar.getText().equals("")) {
					order = new Sugar(order,Double.valueOf(t_sugar.getText()));
				}
				if(!t_season.getText().equals("") ) {
					order = new Season(order,Double.valueOf(t_season.getText()));
				}
				
			    //System.out.println(t_flavor.getText());
			    //System.out.println(t_shot.getText());
				System.out.println("--");
				//Coffee order = new Season(new Sugar(new Cream(new ExtraShot( new Flavor(new BasicCoffee(), t_flavor.getText()), t_shot.getText()), t_cream.getText()), t_sugar.getText()), t_season.getText());
				cost_per_order =order.makeCoffee();
				//detail of topping and coffee for current customer
				detail_text.setText(order.displayOrder()+"\n"+"  Total: $"+cost_per_order);	
				
				detail.setDisable(true);
				place.setDisable(false);
				cancel.setDisable(false);
				t_flavor.setEditable(false);
				//after click detail, no allow to edit textfield
				t_shot.setEditable(false);
				t_cream.setEditable(false);
				t_sugar.setEditable(false);
				t_season.setEditable(false);
				
			}				
					
			System.out.println("--");
		    
		});
		//cancel current order
		cancel.setOnAction(e->{	
			
			place.setDisable(true);
			cancel.setDisable(true);
			detail.setDisable(false);
			detail_text.setText("");
			t_flavor.setEditable(true);
			t_shot.setEditable(true);
			t_cream.setEditable(true);
			t_sugar.setEditable(true);
			t_season.setEditable(true);
			
			
		});
		//add current order to total list price
		place.setOnAction(e->{
			total_cost += cost_per_order;
			time_order++;
			detail_text.setText("");
			place.setDisable(true);
			cancel.setDisable(true);
			detail.setDisable(false);
			t_flavor.setEditable(true);
			t_shot.setEditable(true);
			t_cream.setEditable(true);
			t_sugar.setEditable(true);
			t_season.setEditable(true);
			my_order_text.setText("Time Orders: "+time_order+" Total Cost: "+total_cost);
		
			
		});
		
		//reset order and price for new customer
		pay_next.setOnAction(e->{
			total_cost = 0;
			time_order =0;
			detail_text.setText("");	
			detail.setDisable(false);
			cancel.setDisable(true);
			place.setDisable(true);
			
			t_flavor.setEditable(true);
			t_shot.setEditable(true);
			t_cream.setEditable(true);
			t_sugar.setEditable(true);
			t_season.setEditable(true);
			my_order_text.setText("Time Orders: "+time_order+" Total Cost: "+total_cost);
		
	   });
		
		
		
		
		
		
		/*Scene scene = new Scene(box,900,900);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		  */
		
		System.out.println("Dones");
		
	}
	//evaluate correctly insert 1,2,3
	  public boolean evalNum(String c) {
	    	 String a = c.replaceAll("\\s","");
	    	
	  
	    	if(a.equals("1") || a.equals("2") ||a.equals("3") ||a.equals("")) {
	    		return true;
	    	}
	    	else {
	    		
	    		return false;
	    		
	    	}
	    }
	//evaluate correctly insert y,n
	    public boolean evalY(String c) {
	    	 String a = c.replaceAll("\\s","");
	    	 
	    	
	    	if(a.equals("y") || a.equals("n") ||a.equals("")||a.equals("Y") ||a.equals("N")) {
	    		return true;
	    	}
	    	else {
	    		
	    		return false;
	    	}
	    	
	    }
	
}
