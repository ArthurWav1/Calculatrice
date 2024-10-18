package view;

import java.util.List;

import javafx.stage.Stage;

public interface CalculatorGUIInterface {
	public void affiche(Stage primaryStage);
	public void change(String accu);
	public void change(List<Double> stackData);
}
