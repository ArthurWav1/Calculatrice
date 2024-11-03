package model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface{
	private String accu;
	private Stack<Double> memory;
	
	public CalculatorModel() {
		this.memory = new Stack<Double>();
		this.accu = "";
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
	public double add() throws Exception {
		if(!this.memory.empty() && !this.accu.isEmpty()) { //Si on a mis des chiffres dans l'accumulateur
			return this.memory.pop() + this.memory.pop();
		}
		else {
			if(this.hasTwoNumber()) { //Cas ou on utilise juste la pile (rien dans l'accumulateur, on a juste appuyé sur "+" avec un accu vide pour arriver là)
					
			}
		}
		return 0;
	}

	/**
	 * Pareil que l'addition
	 */
	@Override
	public double substract() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Pareil que l'addition
	 */
	@Override
	public double multiply() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Pareil que l'addition et vérifie qu'on ne divise pas par 0 !
	 */
	@Override
	public double divide() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Met dans l'accumulateur l'opposé de l'élément qui est en haut de pile ou bien l'élément de l'accumulateur (s'ils existent)
	 */
	@Override
	public double opposite() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Ajoute à la pile le résultat d'une opération
	 */
	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Si existant, retire le dernier élément de la pile et le renvoie
	 */
	@Override
	public double pop() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Si existant, retire le dernier élément de la pile sans le renvoyer
	 */
	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Échange si possible les deux éléments du dessus de la pile (ou bien l'élément du dessus et l'élement de l'accumulateur si possible)
	 */
	@Override
	public void swap() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Vide la pile et l'accumulateur
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
