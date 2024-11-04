package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CalculatorGUI implements CalculatorGUIInterface {
	
	//Dimensions des boutons
	private static final int BUTTON0_PREF_WIDTH = 180;
	private static final int BUTTON_PREF_WIDTH = 85; 
	private static final int BUTTON_PREF_HEIGHT = 60;
	
	private Label current;
	private Label l1;
	private Label l2;
	private Label l3;
	private Label l4;
	
	private ArrayList<Button> buttonList = new ArrayList<>();
	
	
	public static boolean b = false;
		
	private Pane root;
	private Scene scene;
	
	public CalculatorGUI(Stage primaryStage) {
		root = new Pane();
		scene = new Scene(root,500,600);
		affiche(primaryStage);
		
	};
	
	@Override
	public void affiche(Stage primaryStage) {
		
		//Création des boutons de la calculatrice
		Button b0 = new Button("0");
		Button b1 = new Button("1");
		Button b2 = new Button("2");
		Button b3 = new Button("3");
		Button b4 = new Button("4");
		Button b5 = new Button("5");
		Button b6 = new Button("6");
		Button b7 = new Button("7");
		Button b8 = new Button("8");
		Button b9 = new Button("9");
		Button bAdd = new Button("+");
		Button bSub = new Button("-");
		Button bProd = new Button("*");
		Button bDiv = new Button("/");
		Button bComa = new Button(".");
		Button bSign = new Button("+/-");
		Button bSwitch = new Button("Switch");
		Button bDel = new Button("Del");
		Button bEnter = new Button("Enter");
		
		//Gestion des actions des boutons
		
		b0.setOnAction(event -> handleNumberClick("0"));
		b1.setOnAction(event -> handleNumberClick("1"));
		b2.setOnAction(event -> handleNumberClick("2"));
		b3.setOnAction(event -> handleNumberClick("3"));
		b4.setOnAction(event -> handleNumberClick("4"));
		b5.setOnAction(event -> handleNumberClick("5"));
		b6.setOnAction(event -> handleNumberClick("6"));
		b7.setOnAction(event -> handleNumberClick("7"));
		b8.setOnAction(event -> handleNumberClick("8"));
		b9.setOnAction(event -> handleNumberClick("9"));
		bAdd.setOnAction(event -> handleOperationClick("+"));
		bSub.setOnAction(event -> handleOperationClick("-"));
		bProd.setOnAction(event -> handleOperationClick("*"));
		bDiv.setOnAction(event -> handleOperationClick("/"));
		bComa.setOnAction(event -> handleNumberClick("."));
		bSign.setOnAction(event -> handleNumberClick("+/-"));
		bSwitch.setOnAction(event -> handleActionClick("Del"));
		bEnter.setOnAction(event -> handleActionClick("Enter"));
		
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
		
		//Ajout des boutons dans le Pane
		root.getChildren().addAll(buttonList);
		
		//Création de l'historique des résultats
		VBox history = new VBox();
		history.setLayoutX(20);
		history.setLayoutY(20);
		history.setPrefWidth(460);
		history.setPrefHeight(300);
		
		//Les objets contenus dans l'historique remplissent toute la place disponible
		history.setFillWidth(true);
		
		//Historique des derniers résultats
		current = new Label("");
		l1 = new Label("");
		l2 = new Label("");
		l3 = new Label("");
		l4 = new Label("");
		
		current.setAlignment(Pos.CENTER_RIGHT);
		l1.setAlignment(Pos.CENTER_RIGHT);
		l2.setAlignment(Pos.CENTER_RIGHT);
		l3.setAlignment(Pos.CENTER_RIGHT);
		l4.setAlignment(Pos.CENTER_RIGHT);

		current.setPrefWidth(465);
		current.setPrefHeight(60);
		l1.setPrefWidth(465);
		l1.setPrefHeight(60);
		l2.setPrefWidth(465);
		l2.setPrefHeight(60);
		l3.setPrefWidth(465);
		l3.setPrefHeight(60);
		l4.setPrefWidth(465);
		l4.setPrefHeight(60);
		
		Rectangle rect = new Rectangle(20,20,465,300);
		rect.setSmooth(true);
		rect.setStrokeWidth(2);
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(Color.BLACK);
		
		//Ajout de l'historique dans le Pane
		history.getChildren().addAll(l4,l3,l2,l1,current);
		root.getChildren().add(history);
		root.getChildren().add(rect);

		//TEST	
		//b1.setOnAction(new EventHandler<ActionEvent>() {
			//public void handle(ActionEvent event) {
				//b =!b;
				//if(b) {
					//test();
				//}
				//else {
					//current.setText(current.getText()+'1');
				//}
			//}
		//});
		
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	public void test() {
		ArrayList<String> liste = new ArrayList<>();
		liste.add("test1");
		liste.add("test2");
		liste.add("test3");
		liste.add("test4");
		change(liste);
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
	 * Change les valeurs affichées dans l'historique des 4 dernières valeurs de la calculatrice
	 * Utilisée lorsqu'on appuie sur "entrée" sur la calculatrice avec succès (pas d'erreur)
	 */
	@Override
	public void change(List<String> stackData) {
		l1.setText(stackData.get(0));
		l2.setText(stackData.get(1));
		l3.setText(stackData.get(2));
		l4.setText(stackData.get(3));
	}
	
	public void handleNumberClick(String nb) {
		//Gère les boutons 0123456789  .  +/-
		if (nb == "+/-") {
			if (current.getText().charAt(0) == '-') {
				current.setText(current.getText().substring(1));
			}
			else {
				current.setText("-"+current.getText());
			}
		}
		else if (nb == ".") {
			if (!current.getText().contains(".")) {
				current.setText(current.getText()+nb);
			}
		}
		else {
			current.setText(current.getText()+nb);
		}
	}
	
	public void handleOperationClick(String operation) {
		//Gère les boutons   +-*/
	}
	
	public void handleActionClick(String action) {
		//Gère les boutons Del Enter
	}
}
