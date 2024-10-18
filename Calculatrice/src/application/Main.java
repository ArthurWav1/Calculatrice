package application;
	
import java.util.Stack;

import javafx.application.Application;
import javafx.stage.Stage;
import model.CalculatorModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			CalculatorModel CalculatorModel = new CalculatorModel();
			
			CalculatorModel.setAccu("3");
			System.out.println(CalculatorModel.getAccu());
			
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
