package application.control;

import application.Main;
import application.view.AppMainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Classe de controleur de Dialogue de la fenêtre du menu principal de l'application.
 */
public class AppMainMenu extends Application {

    // Stage de la fenêtre principale construite par DailyBankMainFrame
    private Stage primaryStage;

    /**
     * Méthode de démarrage (JavaFX).
     */
    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        try {

            // Chargement du source fxml
            FXMLLoader loader = new FXMLLoader(
                    AppMainMenuController.class.getResource("AppMainMenu.fxml"));
            BorderPane root = loader.load();

            // Paramétrage du Stage : feuille de style, titre
            Scene scene = new Scene(root, root.getPrefWidth() + 20, root.getPrefHeight() + 10);
            scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Menu Principal");

            AppMainMenuController mainMenu = loader.getController();
            mainMenu.initContext(this, primaryStage);

            mainMenu.displayDialog();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Méthode principale de lancement de l'application.
     */
    public static void runApp() {
        Application.launch();
    }
}
