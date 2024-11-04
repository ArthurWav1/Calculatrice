package model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface{
	private double accu;
	private Stack<Double> memory;
	
	public CalculatorModel() {
		this.memory = new Stack<Double>();
		this.accu = 0;
	}
	
	public Stack<Double> push() {
		memory.push(getAccu());
		setAccu(0);
		return memory;
	}
	
	public double getAccu() {
		return accu;
	}
	
	public void setAccu(double accu) {
		this.accu = accu;
	}
	
	public Stack<Double> getMemory() {
		return this.memory;
	}
	
	public void setMemory(Stack<Double> memory) {
		this.memory = memory;
	}

	
	/**
	 * S'il y a au moins 2 nombres dans la pile, additionne les deux du dessus,
	 * S'il y a un seul nombre dans la pile et un nombre dans l'accumulateur, additionne ces deux nombres
	 * S'il n'y a pas assez d'opérandes pour effectuer l'addition, informe l'utilisateur d'une erreur.
	 */
	@Override
	public Stack<Double> add() {
		setAccu(getAccu()+pop());
		return(memory);
	}

	/**
	 * Pareil que l'addition
	 */
	@Override
	public Stack<Double> substract() {
		setAccu(pop()-getAccu());
		return(memory);
	}

	/**
	 * Pareil que l'addition
	 */
	@Override
	public Stack<Double> multiply() {
		setAccu(getAccu()*pop());
		return(memory);
	}

	/**
	 * Pareil que l'addition et vérifie qu'on ne divise pas par 0 !
	 */
	@Override
	public Stack<Double> divide() {
		if(getAccu() != 0) {
			setAccu(pop()/getAccu());
		}
		return(memory);
	}

	/**
	 * Met dans l'accumulateur l'opposé de l'élément qui est en haut de pile ou bien l'élément de l'accumulateur (s'ils existent)
	 */
	@Override
	public Stack<Double> opposite() {
		setAccu(-getAccu());
		return(memory);
	}
	
	/**
	 * Si existant, retire le dernier élément de la pile et le renvoie
	 */
	@Override
	public double pop() {
		if(memory.size()>0) {
			double out = memory.pop();
			return out;
		}
		else {
			return 0;
		}
	}

	/**
	 * Si existant, retire le dernier élément de la pile sans le renvoyer
	 */
	@Override
	public Stack<Double> drop() {
		if(memory.size()>0) {
			setAccu(memory.pop());
		}
		return memory;
	}

	/**
	 * Échange si possible les deux éléments du dessus de la pile (ou bien l'élément du dessus et l'élement de l'accumulateur si possible)
	 */
	@Override
	public Stack<Double> swap() {
		if(memory.size()>1) {
			double acc0 = getAccu();
			double acc1 = pop();
			double acc2 = pop();
			setAccu(acc1);
			push();
			setAccu(acc2);
			push();
			setAccu(acc0);
		}
		return(memory);
	}

	/**
	 * Vide la pile et l'accumulateur
	 */
	@Override
	public Stack<Double> clear() {
		memory.clear();
		setAccu(0);
		return(memory);
	}
	
	/**
	 * Informe si la pile contient deux éléments ou plus
	 * @return renvoie true s'il y a au moins deux nombres et false si elle n'en contient qu'un seul ou aucun
	 * 
	 */
	public boolean hasTwoNumber() {
		if(!this.memory.empty()) { //Test s'il y a au moins un élément
			//On retire cet élément pour réitérer le test
			double element = this.memory.pop();
			if(!this.memory.empty()) {
				this.memory.push(element);
				return true;
			}
			this.memory.push(element);
			return false;
		}
		return false;
	}
	
}
