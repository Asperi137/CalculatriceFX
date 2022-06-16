package fr.afpa.main;

import static fr.afpa.utils.Calcul.factorielle;
import static fr.afpa.utils.Calcul.nEntierOptimise;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import fr.afpa.main.validation.ChiffreValidator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements Initializable {
	@FXML
	private TextField chiffre;
	@FXML
	private ChoiceBox<String> calcul;
	@FXML
	private TextField resultat;
	@FXML
	private Button OK;

	// Bouton OK → quand on clique dessus
	@FXML
	protected void onOKButtonClick() {
		String calc = calcul.getSelectionModel().getSelectedItem();
		String resu = "";
		final String texteChiffre = chiffre.getText();
		final BigDecimal nombre = new BigDecimal(texteChiffre);

		try {
			switch (calc) {
			case "Somme n entier" -> {
				resu = String.valueOf(nEntierOptimise(nombre));
			}
			case "Factorielle" -> {
				resu = String.valueOf(factorielle(nombre));
			}
			case "Carré" -> {
				resu = String.valueOf(nombre.multiply(nombre));
			}
			}
			resultat.setText(resu);
		} catch (Exception e) {
			resultat.setText("veuillez entrer un entier valide SVP !");
		}
		OK.setDisable(true);
	}

	// Bouton annuler → quand on clique dessus
	@FXML
	protected void onAnnulerButtonClick() {
		chiffre.setText("");
		resultat.setText("");
		OK.setDisable(true);
	}

	// Bouton quitter → quand on clique dessus
	@FXML
	protected void onQuitButtonClick() {
		Platform.exit();
	}

//	 initialize la liste de choix
//	 attention se lance a l'initialisation du controller mais pas de la scène,
//	 ne se lancera donc pas en cas de changement de scène si le controller est deja initialisé.
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		init();

	}

	// On pourra appeller cette methode de l'extérieur si besoin pour initialiser
	// une scène.
	public void init() {

		resultat.setEditable(false);
		resultat.setText("Veuillez entrer un entier positif");

		calcul.getItems().addAll("Somme n entier", "Factorielle", "Carré");
		calcul.getSelectionModel().selectFirst();

		OK.setDisable(true);

		// Event lancer a chaque fois que le texte de chiffre est modifié.
		chiffre.textProperty().addListener(observable -> checkInput());

		// Event lancer a chaque fois que l'item selectionné change.
		calcul.valueProperty().addListener(observable -> checkInput());

	}

	@FXML
	protected void onEnterPress(KeyEvent e) {

		if (e.getCode().equals(KeyCode.ENTER) && !chiffre.getText().isBlank()) {
//			OK.setDisable(false);
		}

	}

	private void checkInput() {

		final ChiffreValidator validator = new ChiffreValidator();

		resultat.clear();

		if (!validator.validate(chiffre.getText())) {

			for (String erreur : validator.getErreurs()) {

				resultat.appendText(erreur);
			}
			OK.setDisable(true);
			return;

		}

		OK.setDisable(false);

	}

}