package fr.afpa.main;

import fr.afpa.utils.calculException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import static fr.afpa.utils.calcul.factorielle;
import static fr.afpa.utils.calcul.NEntier;

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
    protected void onOKButtonClick() throws calculException {
        String calc = calcul.getSelectionModel().getSelectedItem();
        String resu = "";
        try {
            switch (calc) {
                case "Somme n entier" -> {
                    resu = String.valueOf(NEntier(new BigDecimal(chiffre.getText())));
                }
                case "Factorielle" -> {
                    resu = String.valueOf(factorielle(new BigDecimal(chiffre.getText())));
                }
                case "Carré" -> {
                    resu = String.valueOf(new BigDecimal(chiffre.getText()).multiply(new BigDecimal(chiffre.getText())));
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

    // initialize la liste de choix
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calcul.getItems().addAll("Somme n entier", "Factorielle", "Carré");
        calcul.getSelectionModel().selectFirst();
    }

    @FXML
    protected void onEnterPress(KeyEvent e) {
        {
            if (e.getCode().equals(KeyCode.ENTER) && !chiffre.getText().isBlank()) {
                OK.setDisable(false);
            }
        }
    }
}