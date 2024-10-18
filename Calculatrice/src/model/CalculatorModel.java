package model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface{
	private static String accu = "";
	private static Stack<Double> memory;
	
	
	
	
	public CalculatorModel() {
		memory = new Stack<Double>();
	}
	
	public void push(double a) {
		this.memory.push(a);
	}
	
	
	public String getAccu() {
		return accu;
	}
	public void setAccu(String accu) {
		this.accu = accu;
	}
	public Stack getMemory() {
		return memory;
	}
	public void setMemory(Stack memory) {
		this.memory = memory;
	}

	@Override
	public double add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double substract() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double multiply() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double divide() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double opposite() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double pop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
