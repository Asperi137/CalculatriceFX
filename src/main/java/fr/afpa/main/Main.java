package fr.afpa.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		System.out.println("[system] Lancement de l'application.");

		// Lancement de l'application par l'appel de launch().
		launch(args);
	}

	@Override
	public void start(Stage myStage) throws Exception {

		// On appelle la feuille de style fxml
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("calcFX.fxml"));

		// Création d'une scène
		Scene myScene = new Scene(fxmlLoader.load());
		// Nom de la fenêtre
		myStage.setTitle("Calculatrice");
		// Integration de la scene dans la fenêtre
		myStage.setScene(myScene);
		// Affichage de la fenêtre
		myStage.show();
	}

}