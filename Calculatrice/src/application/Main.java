package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.*;
import model.*;
import controler.*;

/**
 * Main de l'application qui est une calculatrice basée sur la notation polonaise inverse
 */
public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		//Création du controlleur qui crée toute la calculatrice.
		CalculatorControlerInterface controler = new CalculatorControler(new CalculatorModel(), new CalculatorGUI(primaryStage));
	}

}
