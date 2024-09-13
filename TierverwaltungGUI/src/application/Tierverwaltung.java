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
	private Button deleteButton;
	private Button changeButton;
	private Button iterateButton;
	
	public Tierverwaltung() {
		tiere = new ArrayList<>();
	}
	
	public GridPane createLayout() {
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		nameLabel = new Label("Verwalten Sie die Tiere nach Ihrer Wahl.");
		nameLabel.setFont(new Font(20));
		grid.setConstraints(nameLabel, 1, 2);
		
		
		
		
		grid.getChildren().addAll(nameLabel);
		
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
