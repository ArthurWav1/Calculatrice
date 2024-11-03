package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.*;
import model.*;
import controler.*;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		CalculatorGUIInterface gui = new CalculatorGUI(primaryStage);
		CalculatorModelInterface model = new CalculatorModel();
		CalculatorControlerInterface controler = new CalculatorControler(model,gui);
	}

}
