package model;

import customException.CalculatorException;

public interface CalculatorModelInterface {
	
	public void add() throws CalculatorException ;
	public void substract() throws CalculatorException;
	public void multiply() throws CalculatorException;
	public void divide() throws CalculatorException;
	public void opposite();
	public void push(Double number) throws CalculatorException;
	public double pop() throws CalculatorException;
	public void swap() throws CalculatorException;
	public void clear();
}
