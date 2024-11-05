package model;


public interface CalculatorModelInterface {
	
	public void add();
	public void substract();
	public void multiply();
	public void divide();
	public void opposite();
	public void push(Double number);
	public double pop();
	public void drop();
	public void swap();
	public void clear();
}
