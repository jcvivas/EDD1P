package com.grupo02.videogamestore;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.Readers.Reader;
import com.grupo02.videogamestore.modelo.Juego;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import com.grupo02.videogamestore.modelo.Usuario;

// Probando git
/**
 * JavaFX App
 */
public class App extends Application {
    public static DoublyCircularLinkedList<Juego> juegos;
    private static Scene scene;
    public static String filePath = "src/main/resources/archivos/";
    public static String fileImage = "src/main/resources/imagenes/";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Inicial"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        //a
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        App.scene = scene;
    }

}