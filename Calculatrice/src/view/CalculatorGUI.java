package view;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorGUI implements CalculatorGUIInterface {
	
	private static boolean b;
	
	public CalculatorGUI() {};
	
	@Override
	public void affiche(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,300);
		
		Button bouton_un = new Button();
		bouton_un.setText("");
		root.setCenter(bouton_un);
		
		VBox historique = new VBox();
		
		
		Label lab = new Label();
		root.getChildren().add(lab);
		lab.setLayoutX(100);
		lab.setLayoutY(200);
		lab.setScaleX(2);
		lab.setScaleY(2);
		
				
		bouton_un.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				b = !b;
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
