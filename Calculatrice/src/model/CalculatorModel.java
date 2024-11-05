package model;

import java.util.ArrayList;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface{
	//Accumulateur du côté du modèle
	private double accu;
	//Pile des résultats
	private Stack<Double> memory;
	
	public CalculatorModel() {
		this.memory = new Stack<Double>();
		this.accu = 0;
	}
	
	/**
	 * Méthode de push d'une pile, ajoute number au dessus de la pile
	 */
	public void push(Double number) {
		memory.push(number);
	}
	
	/**
	 * Méthode pour additionner les deux nombres du dessus de la pile ou bien
	 * le nombre du dessus de la pile et l'accumulateur si celui-ci est non nul
	 */
	@Override
	public void add() {
		if(this.accu != 0) { //Dans le cas où l'accumulateur est non nul, on l'ajoute à la pile avant de faire l'addition
			this.memory.push(this.accu);
		}
		this.memory.push(this.memory.pop()+this.memory.pop());
		this.accu = 0;
	}

	/**
	 * Méthode basée sur le même principe que l'addition mais pour la soustraction
	 * La soustraction s'effectue dans le sens : élément le plus haut de la pile - deuxième élément le plus haut de la pile
	 */
	@Override
	public void substract() {
		if(this.accu != 0) {
			this.memory.push(this.accu);
		}
		this.memory.push(this.memory.pop()-this.memory.pop());
		this.accu = 0;
	}

	/**
	 * Méthode basée sur le même principe que l'addition mais pour la multiplication
	 */
	@Override
	public void multiply() {
		if(this.accu != 0) {
			this.memory.push(this.accu);
		}
		if(this.hasTwoNumber()) { //On vérifie bien que la pile contient au moins 2 éléments pour faire la multiplication
			this.memory.push(this.memory.pop()*this.memory.pop());
			this.accu = 0;
		}
	}

	/**
	 * Méthode basée sur le même principe que l'addition mais pour la division
	 */
	@Override
	public void divide() {
		if(this.accu!=0) {
			this.memory.push(accu);
		}
		if(this.hasTwoNumber()) {
			double acc = this.memory.pop();
			double acc2 = this.memory.pop();
			if(acc2 != 0) { //On ne divise pas par 0
				this.memory.push(acc/acc2);
				this.accu = 0;
			}
		}
	}

	/**
	 * Change le signe du nombre dans l'accumulateur
	 */
	@Override
	public void opposite() {
		this.accu = -this.accu;
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
		return 0; //A VOIR
	}

	/**
	 * Retire l'élément du dessus de la pile sans le retourner
	 */
	@Override
	public void drop() {
		this.memory.pop();
	}

	/**
	 * Échange si possible les deux éléments du dessus de la pile
	 */
	@Override
	public void swap() {
		if(this.hasTwoNumber()) {
			double acc1 = this.pop();
			double acc2 = this.pop();
			this.push(acc1);
			this.push(acc2);
		}
	}

	/**
	 * Vide la pile et l'accumulateur
	 */
	@Override
	public void clear() {
		this.memory.clear();
		this.accu = 0;
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
	
	/**
	 * Fournit les 4 éléments du dessus de la pile
	 * S'il y a moins de 4 éléments dans la pile on remplit le reste de la liste avec des éléments null ce qui permet d'indiquer à CalculatorControler
	 * de placer des String vide dans les Label correspondants
	 * @return Une liste contenant les 4 éléments du dessus de la pile (des double et des éléments null)
	 */
	public ArrayList<Double> topFourNumbers(){
		ArrayList<Double> fourNumbers = new ArrayList<>();
		for(int i=0;i<4;i++) { 
			if(!this.memory.empty()) { //On dépile l'élément du dessus de la pile si possible
				fourNumbers.add(this.pop());
			}
			else { //Sinon on place un élément null dans la liste
				fourNumbers.add(null);
			}
		}
		for(int i=3;i>=0;i--) { //On replace dans le même ordre les éléments dans la pile
			if(fourNumbers.get(i) != null) {
				this.memory.push(fourNumbers.get(i));
			}
		}
		return fourNumbers;
	}
	
	//********Getters et setters********//
		public double getAccu() {
			return this.accu;
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
	
	
}
