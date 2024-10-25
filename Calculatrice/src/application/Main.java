package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.CalculatorGUI;
import view.CalculatorGUIInterface;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		CalculatorGUIInterface gui = new CalculatorGUI(primaryStage);
	}

}
