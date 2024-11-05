package view;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorGUI implements CalculatorGUIInterface {
	
	//Dimensions des boutons
	private static final int BUTTON0_PREF_WIDTH = 180;
	private static final int BUTTON_PREF_WIDTH = 85; 
	private static final int BUTTON_PREF_HEIGHT = 60;
	//Dimensiosn des Labels
	private static final int LABEL_PREF_WIDTH = 465 ;
	private static final int LABEL_PREF_HEIGHT = 60;

	
	//Label contenant le nombre actuellement manipulé dans l'accumulateur (le Label "current")
	//Les 4 autres labels correspondent respectivement aux 4 nombres du dessus de la pile, l1 contenant l'élément du dessus de la pile et l2 le suivant etc...
	private Label current;
	private Label l1;
	private Label l2;
	private Label l3;
	private Label l4;
	
	//Les différents boutons de la calculatrice 
	//Les boutons des 10 chiffres
	private Button b0;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	private Button b6;
	private Button b7;
	private Button b8;
	private Button b9;
	private Button bAdd; //Addition
	private Button bSub; //Soustraction
	private Button bProd; //Produit
	private Button bDiv; //Division
	private Button bComa; //Virgule
	private Button bSign; //Signe
	private Button bSwitch; //Échange des deux éléments du dessus de la pile
	private Button bDel; //Fonction pour supprimer le chiffre de droite de l'accumulateur ou bien l'élément du dessus de la pile si l'accumulateur est vide
	private Button bEnter; //Permet de placer la valeur de l'accumulateur au dessus de la pile
	private Button bClear; //Permet de vider complètement la pile et l'accumulateur
		
	//Éléments de JavaFX pour créer la fenêtre et tout le visuel de l'application
	private Pane root;
	private Scene scene;
	
	public CalculatorGUI(Stage primaryStage) {
		root = new Pane();
		scene = new Scene(root,500,630);
		affiche(primaryStage);
		
	};
	
	@Override
	public void affiche(Stage primaryStage) {
		
		//Création des boutons de la calculatrice
		this.b0 = new Button("0");
		this.b1 = new Button("1");
		this.b2 = new Button("2");
		this.b3 = new Button("3");
		this.b4 = new Button("4");
		this.b5 = new Button("5");
		this.b6 = new Button("6");
		this.b7 = new Button("7");
		this.b8 = new Button("8");
		this.b9 = new Button("9");
		this.bAdd = new Button("+");
		this.bSub = new Button("-");
		this.bProd = new Button("*");
		this.bDiv = new Button("/");
		this.bComa = new Button(".");
		this.bSign = new Button("+/-");
		this.bSwitch = new Button("Switch");
		this.bDel = new Button("Del/Drop");
		this.bEnter = new Button("Enter");
		this.bClear = new Button("Clear");
		
		//Liste permettant d'alléger le code en permettant d'affecter les dimensions de chaque bouton de manière concise
		ArrayList<Button> buttonList = new ArrayList<>(); 
		
		//Ajout des boutons à une liste pour mieux les manipuler
		buttonList.add(b0);
		buttonList.add(b1);
		buttonList.add(b2);
		buttonList.add(b3);
		buttonList.add(b4);
		buttonList.add(b5);
		buttonList.add(b6);
		buttonList.add(b7);
		buttonList.add(b8);
		buttonList.add(b9);
		buttonList.add(bAdd);
		buttonList.add(bSub);
		buttonList.add(bProd);
		buttonList.add(bDiv);
		buttonList.add(bComa);
		buttonList.add(bSign);
		buttonList.add(bSwitch);
		buttonList.add(bDel);
		buttonList.add(bEnter);
		
		//Attribution des dimensions du bouton 0 séparément des autres car il est d'une taille particulière
		b0.setPrefWidth(BUTTON0_PREF_WIDTH);
		b0.setPrefHeight(BUTTON_PREF_HEIGHT);
		
		//Attribution des dimensions des autres boutons
		for(int i=1;i<buttonList.size();i++) {
			buttonList.get(i).setPrefWidth(BUTTON_PREF_WIDTH);
			buttonList.get(i).setPrefHeight(BUTTON_PREF_HEIGHT);
		}
		
		//Placement des boutons dans l'affichage
		b0.setLayoutX(20);
		b0.setLayoutY(520);

		b1.setLayoutX(20);
		b1.setLayoutY(455);
		
		b2.setLayoutX(115);
		b2.setLayoutY(455);

		b3.setLayoutX(210);
		b3.setLayoutY(455);
		
		b4.setLayoutX(20);
		b4.setLayoutY(390);
		
		b5.setLayoutX(115);
		b5.setLayoutY(390);
		
		b6.setLayoutX(210);
		b6.setLayoutY(390);
		
		b7.setLayoutX(20);
		b7.setLayoutY(325);
		
		
		b8.setLayoutX(115);
		b8.setLayoutY(325);
		
		b9.setLayoutX(210);
		b9.setLayoutY(325);
		
		bAdd.setLayoutX(305);
		bAdd.setLayoutY(455);
	
		bSub.setLayoutX(305);
		bSub.setLayoutY(390);
		bSub.setFont(new Font(20)); //Permet de mieux distinguer le - et le . dans la fenêtre
		
		bProd.setLayoutX(305);
		bProd.setLayoutY(325);
		
		bComa.setLayoutX(210);
		bComa.setLayoutY(520);
		
		bSign.setLayoutX(305);
		bSign.setLayoutY(520);
		
		bDiv.setLayoutX(400);
		bDiv.setLayoutY(325);
		
		bSwitch.setLayoutX(400);
		bSwitch.setLayoutY(390);
		
		bDel.setLayoutX(400);
		bDel.setLayoutY(455);
		
		bEnter.setLayoutX(400);
		bEnter.setLayoutY(520);
		
		bClear.setPrefWidth(465);
		bClear.setPrefHeight(40);
		bClear.setLayoutX(20);
		bClear.setLayoutY(585);
		
		//Ajout des boutons dans le Pane
		root.getChildren().addAll(buttonList);
		root.getChildren().add(bClear);
		
		//Création de l'historique des résultats
		VBox history = new VBox(); //Contient des éléments superposés verticalement
		history.setLayoutX(20);
		history.setLayoutY(20);
		history.setPrefWidth(460);
		history.setPrefHeight(300);
		
		//Permet de forcer les objets contenus dans l'historique à remplir toute la place disponible
		history.setFillWidth(true);
		
		//Création des Label pour l'accumulateur et pour le dessus de la pile
		current = new Label("");
		l1 = new Label("");
		l2 = new Label("");
		l3 = new Label("");
		l4 = new Label("");
		
		//Positionnement du texte des Label au centre du bord droit du Label
		current.setAlignment(Pos.CENTER_RIGHT);
		l1.setAlignment(Pos.CENTER_RIGHT);
		l2.setAlignment(Pos.CENTER_RIGHT);
		l3.setAlignment(Pos.CENTER_RIGHT);
		l4.setAlignment(Pos.CENTER_RIGHT);

		//Dimensionnement des 
		current.setPrefWidth(LABEL_PREF_WIDTH);
		current.setPrefHeight(LABEL_PREF_HEIGHT);
		l1.setPrefWidth(LABEL_PREF_WIDTH);
		l1.setPrefHeight(LABEL_PREF_HEIGHT);
		l2.setPrefWidth(LABEL_PREF_WIDTH);
		l2.setPrefHeight(LABEL_PREF_HEIGHT);
		l3.setPrefWidth(LABEL_PREF_WIDTH);
		l3.setPrefHeight(LABEL_PREF_HEIGHT);
		l4.setPrefWidth(LABEL_PREF_WIDTH);
		l4.setPrefHeight(LABEL_PREF_HEIGHT);
		
		//Ligne séparatrice de l'accumulateur et de la pile
		Line line = new Line();
		line.setLayoutX(20);
		line.setLayoutY(250);
		line.setStartX(0);
		line.setStartY(0);
		line.setEndX(465);
		line.setEndY(0);
		
		//Rectangle pour "simuler" un écran de calculatrice
		Rectangle rect = new Rectangle(20,20,465,300);
		rect.setSmooth(true);
		rect.setStrokeWidth(2);
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(Color.BLACK);
		
		//Ajout des derniers éléments dans le Pane
		history.getChildren().addAll(l4,l3,l2,l1,current);
		root.getChildren().add(line);
		root.getChildren().add(history);
		root.getChildren().add(rect);
		
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false); //Bloque le redimensionnement de la fenêtre par l'utilisateur
		primaryStage.show();	
	}

	/**
	 * Change la valeur du texte de l'accumulateur (l'entrée courrante de la calculatrice)
	 */
	@Override
	public void change(String accu) {
		current.setText(current.getText() + accu);
		current.setText(accu);
	}

	/**
	 * Change les valeurs affichées dans les 4 Label de l'historique
	 */
	@Override
	public void change(List<String> stackData) {
		l1.setText(stackData.get(0));
		l2.setText(stackData.get(1));
		l3.setText(stackData.get(2));
		l4.setText(stackData.get(3));
	}
	
	
	//********Getters et setters********//
	public Label getCurrent() {
		return current;
	}

	public void setCurrent(Label current) {
		this.current = current;
	}

	public Label getL1() {
		return l1;
	}

	public Label getL2() {
		return l2;
	}

	public Label getL3() {
		return l3;
	}

	public Label getL4() {
		return l4;
	}

	public Button getB0() {
		return b0;
	}

	public Button getB1() {
		return b1;
	}

	public Button getB2() {
		return b2;
	}

	public Button getB3() {
		return b3;
	}

	public Button getB4() {
		return b4;
	}

	public Button getB5() {
		return b5;
	}

	public Button getB6() {
		return b6;
	}

	public Button getB7() {
		return b7;
	}

	public Button getB8() {
		return b8;
	}

	public Button getB9() {
		return b9;
	}

	public Button getbAdd() {
		return bAdd;
	}

	public Button getbSub() {
		return bSub;
	}

	public Button getbProd() {
		return bProd;
	}

	public Button getbDiv() {
		return bDiv;
	}

	public Button getbComa() {
		return bComa;
	}

	public Button getbSign() {
		return bSign;
	}

	public Button getbSwitch() {
		return bSwitch;
	}

	public Button getbDel() {
		return bDel;
	}

	public Button getbEnter() {
		return bEnter;
	}

	public Button getbClear() {
		return bClear;
	}
	
	public Pane getRoot() {
		return root;
	}

	public Scene getScene() {
		return scene;
	}

}
