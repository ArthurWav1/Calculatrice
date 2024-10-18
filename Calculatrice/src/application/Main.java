package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.CalculatorGUI;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		CalculatorGUI gui = new CalculatorGUI();
		
		gui.affiche(primaryStage);
		
		
	}

}
