package model;

public interface CalculatorModelInterface {
	
	public double add() throws Exception;
	public double substract();
	public double multiply();
	public double divide();
	public double opposite();
	public void push();
	public double pop();
	public void drop();
	public void swap();
	public void clear();
}
