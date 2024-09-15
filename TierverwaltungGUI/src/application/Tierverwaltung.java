package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import Tiere.Tier;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Tierverwaltung {
	
	private List<Tier> tiere;
	private Label nameLabel;
	
	private TextField tierFeld;
	
	private Button insertButton;
	private Button removeButton;
	private Button changeButton;
	private Button showButton;
	
	public Tierverwaltung() {
		tiere = new ArrayList<>();
		tiere.add(new Tier("Hund", "Braun", "02.02.2020"));
	}
	
	public GridPane createLayout() {
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		

		nameLabel = new Label("Verwalten Sie die Tiere nach Ihrer Wahl.");
		nameLabel.setFont(new Font(20));
		grid.setConstraints(nameLabel, 0, 0);
		
		insertButton = new Button("Insert");
		insertButton.setFont(new Font(20));
		//insertButton.setOnAction(e -> einfuegen(tiere));
		grid.setConstraints(insertButton, 1, 0);
		
		removeButton = new Button("Remove");
		removeButton.setFont(new Font(20));
		//removeButton.setOnAction(e -> loeschen());
		grid.setConstraints(removeButton, 1, 1);
		
		changeButton = new Button("Change");
		changeButton.setFont(new Font(20));
		grid.setConstraints(changeButton, 2, 0);
		
		showButton = new Button("Show Tiere");
		showButton.setFont(new Font(20));
		grid.setConstraints(showButton, 2, 1);
		
		
		
		
		
		grid.getChildren().addAll(nameLabel, insertButton, removeButton, changeButton, showButton);
		
		return grid;
	}
	
	private void einfuegen(Tier tier) {
			tiere.add(tier);
		
	}
	
	private void loeschen(Tier tier) {
		tiere.remove(tier);
	}
	
	private void ausgeben(Tier tier) {
		for(Tier ausgabe : tiere) {
			System.out.print("Ausgabe: " + ausgabe);
		}
	}

}
