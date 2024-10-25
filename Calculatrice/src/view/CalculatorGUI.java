package view;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorGUI implements CalculatorGUIInterface {
	
	public static boolean b = false;
	
	public CalculatorGUI() {};
	
	@Override
	public void affiche(Stage primaryStage) {
		Pane root = new Pane();
		Scene scene = new Scene(root,500,600);
		
		Button b0 = new Button();
		b0.setText("0");
		b0.setLayoutX(25);
		b0.setLayoutY(525);
		
		Button b1 = new Button();
		b1.setText("1");
		b1.setLayoutX(25);
		b1.setLayoutY(450);
		
		Button b2 = new Button();
		b2.setText("2");
		b2.setLayoutX(200);
		
		Button b3 = new Button();
		b3.setText("3");
		b3.setLayoutX(200);
		
		
		Button b4 = new Button();
		b4.setText("4");
		b4.setLayoutX(25);
		b4.setLayoutY(375);
		
		Button b5 = new Button();
		b5.setText("5");
		b5.setLayoutX(100);
		b5.setLayoutY(100);
		
		Button b6 = new Button();
		b6.setText("6");
		b6.setLayoutX(50);
		b6.setLayoutY(50);
		
		Button b7 = new Button();
		b7.setText("7");
		b7.setLayoutX(25);
		b7.setLayoutY(300);
		
		Button b8 = new Button();
		b8.setText("8");
		b8.setLayoutX(200);
		b8.setLayoutY(300);
		
		Button b9 = new Button();
		b9.setText("9");
		b9.setLayoutX(300);
		b9.setLayoutY(300);
	
		root.getChildren().add(b0);
		root.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8,b9);
		
		VBox historique = new VBox();
		
		
		Label lab = new Label();
		historique.getChildren().add(lab);
		
		
		lab.setLayoutX(100);
		lab.setLayoutY(200);
		lab.setScaleX(2);
		lab.setScaleY(2);
				
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				b =!b;
				if(b) {
					lab.setText("affichage");
				}
				else {
					lab.setText("");
				}
			}
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	@Override
	public void change(String accu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change(List<Double> stackData) {
		// TODO Auto-generated method stub
		
	}
	
}
