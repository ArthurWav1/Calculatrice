package controler;

import java.util.List;
import java.util.Stack;

public interface CalculatorControlerInterface {
	public void change(String accu);
	public void change(List<Double> stackDatea);
	public Stack<Double> push();
	public Stack<Double> swap();
	public Stack<Double> clear();
	public Stack<Double> add();
	public Stack<Double> substract();
	public Stack<Double> multiply();
	public Stack<Double> divide();
	public Stack<Double> opposite();
	public Stack<Double> drop();
}
