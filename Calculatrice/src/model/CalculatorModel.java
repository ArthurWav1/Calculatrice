package model;

import java.util.Stack;

public class CalculatorModel {
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
	
	
	
}
