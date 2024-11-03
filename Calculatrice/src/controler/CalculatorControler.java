package controler;

import java.util.List;

import model.CalculatorModel;
import model.CalculatorModelInterface;
import view.CalculatorGUI;
import view.CalculatorGUIInterface;

public class CalculatorControler implements CalculatorControlerInterface {

	private CalculatorModelInterface model;
	private CalculatorGUIInterface gui;
	
	public CalculatorControler(CalculatorModelInterface model, CalculatorGUIInterface gui) {
		this.model = model;
		this.gui = gui;
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
