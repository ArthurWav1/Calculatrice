package model;

import java.util.Stack;

public interface CalculatorModelInterface {
	
	public Stack<Double> add() throws Exception;
	public Stack<Double> substract();
	public Stack<Double> multiply();
	public Stack<Double> divide();
	public Stack<Double> opposite();
	public Stack<Double> push();
	public double pop();
	public Stack<Double> drop();
	public Stack<Double> swap();
	public Stack<Double> clear();
}
