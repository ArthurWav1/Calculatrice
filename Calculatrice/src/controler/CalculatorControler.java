package controler;

import java.util.List;
import java.util.Stack;

import model.CalculatorModel;
import model.CalculatorModelInterface;
import view.CalculatorGUI;
import view.CalculatorGUIInterface;

public class CalculatorControler implements CalculatorControlerInterface {


	private CalculatorModel model;
	private CalculatorGUI gui;
	
	public CalculatorControler(CalculatorModel model, CalculatorGUI gui) {
		this.model = model;
		this.gui = gui;
	}

	
	@Override
	public void change(String accu) {
		if(accu == "") {
			model.setAccu(0);
		}
		else {
			model.setAccu(Double.parseDouble(accu));
		}
		
	}

	@Override
	public void change(List<Double> stackData) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Stack<Double> push() {
		// TODO Auto-generated method stub
		return model.push();
	}
	
	@Override
	public Stack<Double> drop() {
		// TODO Auto-generated method stub
		return(model.drop());
	}

	@Override
	public Stack<Double> swap() {
		// TODO Auto-generated method stub
		return(model.swap());
	}

	@Override
	public Stack<Double> clear() {
		// TODO Auto-generated method stub
		return(model.clear());
	}

	@Override
	public Stack<Double> add() {
		// TODO Auto-generated method stub
		return(model.add());
	}

	@Override
	public Stack<Double> substract() {
		// TODO Auto-generated method stub
		return(model.substract());
	}

	@Override
	public Stack<Double> multiply() {
		// TODO Auto-generated method stub
		return(model.multiply());
	}

	@Override
	public Stack<Double> divide() {
		// TODO Auto-generated method stub
		return(model.divide());
	}

	@Override
	public Stack<Double> opposite() {
		// TODO Auto-generated method stub
		return(model.opposite());
	}

}
