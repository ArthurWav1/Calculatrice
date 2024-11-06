package controler;

import java.util.ArrayList;
import java.util.List;

import customException.CalculatorException;
import javafx.scene.control.Label;
import model.CalculatorModel;
import model.CalculatorModelInterface;
import view.CalculatorGUI;
import view.CalculatorGUIInterface;

/**
 * Controlleur qui fait le lien entre la vue et le modèle
 */
public class CalculatorControler implements CalculatorControlerInterface {

	//Modèle de l'application qui gère toutes les opérations mathématiques et les actions 
	//comme la suppression de l'élément du dessus de la pile des résultats, le push de la valeur de l'accumulateur dans la pile etc...
	private CalculatorModelInterface model; 
	//Vue de l'application qui permet à l'utilisateur d'intéragir avec la calculatrice
	private CalculatorGUIInterface gui;
	
	//Correspond à l'accumulateur du côté de la vue, uniquement là pour alléger le code (éviter de nombreux cast qui rendent le code illisible)
	private Label current;
	
	/**
	 * Constructeur du controlleur 
	 * @param model
	 * @param gui
	 */
	public CalculatorControler(CalculatorModel model, CalculatorGUI gui) {
		this.model = model;
		this.gui = gui;
		
		//Affectation d'une méthode à exécuter pour chaque boutons pour refléter les instructions de l'utilisateur sur la calculatrice
		//handleNumberClick pour les chiffres, la virgule et le signe
		//handleOperationClick pour les opérations mathématiques
		//handleActionClick pour les autres actions disponibles sur la calculatrice
		((CalculatorGUI) this.gui).getB0().setOnAction(event -> handleNumberClick("0"));
		((CalculatorGUI) this.gui).getB1().setOnAction(event -> handleNumberClick("1"));
		((CalculatorGUI) this.gui).getB2().setOnAction(event -> handleNumberClick("2"));
		((CalculatorGUI) this.gui).getB3().setOnAction(event -> handleNumberClick("3"));
		((CalculatorGUI) this.gui).getB4().setOnAction(event -> handleNumberClick("4"));
		((CalculatorGUI) this.gui).getB5().setOnAction(event -> handleNumberClick("5"));
		((CalculatorGUI) this.gui).getB6().setOnAction(event -> handleNumberClick("6"));
		((CalculatorGUI) this.gui).getB7().setOnAction(event -> handleNumberClick("7"));
		((CalculatorGUI) this.gui).getB8().setOnAction(event -> handleNumberClick("8"));
		((CalculatorGUI) this.gui).getB9().setOnAction(event -> handleNumberClick("9"));
		((CalculatorGUI) this.gui).getbAdd().setOnAction(event -> handleOperationClick("+"));
		((CalculatorGUI) this.gui).getbSub().setOnAction(event -> handleOperationClick("-"));
		((CalculatorGUI) this.gui).getbProd().setOnAction(event -> handleOperationClick("*"));
		((CalculatorGUI) this.gui).getbDiv().setOnAction(event -> handleOperationClick("/"));
		((CalculatorGUI) this.gui).getbComa().setOnAction(event -> handleNumberClick("."));
		((CalculatorGUI) this.gui).getbSign().setOnAction(event -> handleNumberClick("+/-"));
		((CalculatorGUI) this.gui).getbSwitch().setOnAction(event -> handleActionClick("Switch"));
		((CalculatorGUI) this.gui).getbDel().setOnAction(event -> handleActionClick("Del/Drop"));
		((CalculatorGUI) this.gui).getbEnter().setOnAction(event -> handleActionClick("Enter"));		
		((CalculatorGUI) this.gui).getbClear().setOnAction(event -> handleActionClick("Clear"));		

		//Accumulateur du côté de la vue
		this.current = ((CalculatorGUI) this.gui).getCurrent();
	}

	/**
	 * Permet d'effectuer les bons changement sur la vue et le model de l'accumulateur lorsque c'est nécessaire
	 */
	@Override
	public void change(String accu) {
		
		if(accu == "") { //Cas pour réinitialiser l'accumulateur
			((CalculatorModel) this.model).setAccu(0);
			current.setText("");
			((CalculatorGUI) this.gui).getCurrent().setText("");
		}
		else { //Changement de l'accumulateur
			((CalculatorModel) model).setAccu(Double.parseDouble(accu)); //Changement pour le modèle
			current.setText(accu);
			((CalculatorGUI) this.gui).getCurrent().setText(accu); //Changement pour la vue
		}
	}

	/**
	 * Permet d'effectuer les bons changements sur l'historique des résultats lorsque c'est nécessaire
	 * Cet historique est affiché à l'aide des 4 labels l1, l2, l3, l4 de CalculatriceGUI
	 * l1 correspondant à l'élement du dessus de la pile puis l2 l'élément d'en dessous etc...
	 */
	@Override
	public void change(List<Double> stackData) {
		//Un élément null indique qu'il y a moins de 4/3/2 ou 1 élément dans la pile selon les cas
		//Lorsque l'élément n'est pas null, on affecte au label correspondant la bonne valeur 
		//Lorsque l'élément est null, on affecte au label un String vide
		
		if(stackData.get(0) != null) {
		((CalculatorGUI) this.gui).getL1().setText(stackData.get(0).toString());
		}
		else {
			((CalculatorGUI) this.gui).getL1().setText("");
		}
		
		if(stackData.get(1) != null) {
		((CalculatorGUI) this.gui).getL2().setText(stackData.get(1).toString());
		}
		else {
			((CalculatorGUI) this.gui).getL2().setText("");
		}
		
		if(stackData.get(2) != null) {
		((CalculatorGUI) this.gui).getL3().setText(stackData.get(2).toString());
		}
		else {
			((CalculatorGUI) this.gui).getL3().setText("");
		}
		
		if(stackData.get(3) != null) {
		((CalculatorGUI) this.gui).getL4().setText(stackData.get(3).toString());
		}
		else {
			((CalculatorGUI) this.gui).getL4().setText("");
		}
	}
	
	/**
	 * Modifie le message d'erreur de la calculatrice
	 */
	public void changeError(String error) {
		this.gui.changeError(error);
	}
	
	/**
	 * Méthode gérant les actions à réaliser sur la vue et le model selon quel bouton a été 
	 * utilisé par l'opérateur parmi les boutons 0;1;2;3;4;5;6;7;8;9;.;+/- (+/- correspond au signe du nombre)
	 * @param nb : nombre (ou virgule ou signe) correspondant au bouton appuyé par l'utilisateur sous forme de String
	 */
	public void handleNumberClick(String nb){
		switch(nb) { //Selon le bouton appuyé on effectue les actions nécessaires pour refléter les actions de l'utilisateur
		case "+/-":
			if(current.getText() == null || current.getText().equals("")) { //On vérifie que l'on ne change pas le signe de "rien"
				this.changeError("On ne peut pas changer le signe d'un nombre inexistant");
			}
			else if (current.getText().charAt(0) == '-') { //Cas si le nombre d'origine est négatif
				this.change(current.getText().substring(1));
				this.gui.changeError("");
			}
			else{ //Cas positif
				this.change("-"+current.getText());
				this.gui.changeError("");
			}
			break;
		case ".":
			if (!current.getText().contains(".")) { //On ne peut ajouter une virgule uniquement s'il n'y en a pas déjà une
				if(current.getText().equals("")) { //Si le texte de base est vide on ajoute automatiquement "0."
					this.change('0'+current.getText()+nb);
					this.gui.changeError("");
				}
				else { //On ajoute la virgule
					this.change(current.getText()+nb);
					this.gui.changeError("");
				}
			}
			break;
		case "0": //Cas spécial pour 0 afin d'éviter de pouvoir ajouter plusieurs 0 à gauche du nombre
			if (!current.getText().equals("0")) {
				this.change(current.getText()+nb);
				this.gui.changeError("");
			}
			break;
		default: //Cas pour les chiffres 1;2;3;4;5;6;7;8;9, on ajoute simplement le chiffre à droite du nombre
			this.change(current.getText()+nb);
			this.gui.changeError("");
		}
	}
		
		/**
		 * Gère les boutons liés aux opérations mathématiques
		 * @param operation : operation correspondante sous forme de String : "+" ; "-" ; "*" ; "/"
		 */
	public void handleOperationClick(String operation) {
		ArrayList<Double> newHistory = new ArrayList<>(); //Liste qui contient les 4 nouveaux éléments du dessus de la pile
		try {
		switch(operation) {
			case "+":
				this.model.add(); 
				newHistory = ((CalculatorModel) this.model).topFourNumbers(); //On récupère les 4 nouveaux éléments du dessus de la pile
				this.change(""); //Après l'addition on vide l'accumulateur (le résultat se retrouve en haut de la pile)
				this.change(newHistory); //On modifie sur la vue les 4 Label affichant le dessus de la pile
				this.gui.changeError("");
				break;
			case "-": //On applique la même logique que pour "+"
				this.model.substract();
				newHistory = ((CalculatorModel) this.model).topFourNumbers();
				this.change("");
				this.change(newHistory);
				this.gui.changeError("");
				break;
			case "*": //On applique la même logique que pour "+"
				this.model.multiply();
				newHistory = ((CalculatorModel) this.model).topFourNumbers();
				this.change("");
				this.change(newHistory);
				this.gui.changeError("");
				break;
			case "/": //On applique la même logique que pour "+", la méthode divide se charge de vérifier la division par 0
				this.model.divide();
				newHistory = ((CalculatorModel) this.model).topFourNumbers();
				this.change("");
				this.change(newHistory);
				this.gui.changeError("");
				break;
			}
		}
		catch(CalculatorException e) {
			this.gui.changeError(e.getMessage());
		}
	}
		
	/**
	 * Gère les boutons Del/Drop;Enter;Switch;Clear
	 * @param action : String indiquant quelle action doit être effectuée parmi les 4
	 */
	public void handleActionClick(String action) {
		ArrayList<Double> newHistory = new ArrayList<>(); //Même principe que pour la méthode handleOperationClick
		try {
		switch(action) {
			case "Enter": //On ajoute simplement dans la pile l'élément de l'accumulateur puis on vide ce dernier
				if(!current.getText().equals("")) {
					this.model.push(Double.parseDouble(current.getText()));
					newHistory = ((CalculatorModel) this.model).topFourNumbers();
					this.change(newHistory);
					this.change("");
					this.gui.changeError("");
				}
				else {
					changeError("Impossible de push un nombre vide");
				}
				break;
			case "Del/Drop": //Bouton avec 2 fonctionnalité
				if(!current.getText().equals("")) { //Dans le cas où le texte n'est pas vide 
													//la fonction du bouton est de retirer le chiffre de droite dans l'accumulateur
					change(current.getText().substring(0,current.getText().length()-1));
					this.gui.changeError("");
				}
				else { //Dans  le cas où le texte de l'accumulateur est vide la fonction du bouton est de supprimer le résultat du dessus de la pile
					this.model.pop();
					newHistory = ((CalculatorModel) this.model).topFourNumbers();
					this.change(newHistory);
					this.gui.changeError("");
				}
				break;
				
			case "Switch": //Dans le cas où il y a au moins deux éléments dans la pile on échange les 2 du dessus
				if( ((CalculatorModel) this.model).hasTwoNumber()) { 
					this.model.swap();
				}
				newHistory = ((CalculatorModel) this.model).topFourNumbers();
				this.change(newHistory);
				this.gui.changeError("");
				break;
			case "Clear": //On vide entièrement la pile et l'accumulateur
				this.model.clear();
				newHistory = ((CalculatorModel) this.model).topFourNumbers();
				this.change("");
				this.change(newHistory);
				this.gui.changeError("");
				break;
			}
		}
		catch(CalculatorException e) {
			this.gui.changeError(e.getMessage());
		}
	}
}
