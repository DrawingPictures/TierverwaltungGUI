package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import Tiere.Tier;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Tierverwaltung {
	
	private List<Tier> tiere;
	private Label nameLabel;
	
	private TextField typFeld;
	private TextField hautfarbeFeld;
	private TextField geburtsdatumFeld;
	
	private Button insertButton;
	private Button removeButton;
	private Button changeButton;
	private Button showButton;
	private Label ausgabeLabel;
	
	private boolean anzeige = false;
	
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
		
		typFeld = new TextField();
		typFeld.setPromptText("Geben Sie den Typ ein...");
		grid.setConstraints(typFeld, 0, 1);
		
		hautfarbeFeld = new TextField();
		hautfarbeFeld.setPromptText("Geben Sie die Hautfarbe ein...");
		grid.setConstraints(hautfarbeFeld, 0, 2);
		
		geburtsdatumFeld = new TextField();
		geburtsdatumFeld.setPromptText("Geben Sie das Geburtsdatum des Tieres ein...");
		grid.setConstraints(geburtsdatumFeld, 0, 3);
		
		insertButton = new Button("Insert");
		insertButton.setFont(new Font(20));
		insertButton.setOnAction(e -> einfuegen());
		grid.setConstraints(insertButton, 1, 0);
		
		removeButton = new Button("Remove");
		removeButton.setFont(new Font(20));
		removeButton.setOnAction(e -> loeschen());
		grid.setConstraints(removeButton, 1, 1);
		
		changeButton = new Button("Change");
		changeButton.setFont(new Font(20));
		grid.setConstraints(changeButton, 2, 0);
		
		showButton = new Button("Show Tiere");
		showButton.setFont(new Font(20));
		showButton.setOnAction(e -> ausgeben());
		grid.setConstraints(showButton, 2, 1);
		
		
		
		
		
		grid.getChildren().addAll(nameLabel, typFeld, hautfarbeFeld, geburtsdatumFeld,
				insertButton, removeButton, changeButton, showButton);
		
		return grid;
	}
	
	private void einfuegen() {
			String typ = typFeld.getText();
			String hautfarbe = hautfarbeFeld.getText();
			String geburtsdatum = geburtsdatumFeld.getText();
			
			if(typ.isEmpty() || hautfarbe.isEmpty() || geburtsdatum.isEmpty()) {
				zeigeFehlermeldung("Bitte füllen Sie die Felder aus");
			} else {
				anzeige = anzeigeFenster("Operation bestätigt");
			}
			
			Tier neuesTier = new Tier(typ, hautfarbe, geburtsdatum);
			tiere.add(neuesTier);
			
			
			
			typFeld.clear();
			hautfarbeFeld.clear();
			geburtsdatumFeld.clear();
		
	}
	
	private void loeschen() {
		
		try {
			int id = Integer.parseInt(typFeld.getText());
		
			//Filtert die Tier-ID aus der Tier-Liste
			Optional<Tier> entferntesTier = tiere.stream()
					.filter(tier -> tier.getId() == id)
					.findFirst();
			
			if(entferntesTier.isPresent()) {
				tiere.remove(entferntesTier);
				anzeigeFenster("Tier mit ID" + id + "wurde entfernt.");
			} else {
				
				zeigeFehlermeldung("Kein Tier mit ID" + id + "gefunden.");
			}
			
		} catch(NumberFormatException e) {
			zeigeFehlermeldung("Bitte eine gültige Id eingeben");
		}
		
		
		typFeld.clear();
		
	}
	
	private void aendern() {
		String typ = typFeld.getText();
		String hautfarbe = hautfarbeFeld.getText();
		String geburtsdatum = geburtsdatumFeld.getText();
	}
	
	private void ausgeben() {
		
		tiere.forEach((i) -> System.out.println(i));
	}
	
	public void zeigeFehlermeldung(String text) {
		
		//Erstelle neues Fenster, das die Fehlermeldung anzeigt
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Fehlermeldung");
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
	}
	
	public boolean anzeigeFenster(String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bestätigung");
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
		
		return true;
	}

}
