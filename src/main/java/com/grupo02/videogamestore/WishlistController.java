/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.grupo02.videogamestore;

import com.grupo02.videogamestore.modelo.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IMPORTSOLUTION
 */
public class WishlistController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private VBox vboxExterior;
    
    @FXML
    private FlowPane fpJuegos;
    
    @FXML
    private Button btnVolver;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TiendaController.cargarJuegos(TiendaController.wishlist, 4, fpJuegos, vboxExterior, 200, 450);
    }
    
    @FXML
    private void volverTienda() throws IOException {
        Stage s = (Stage) btnVolver.getScene().getWindow();
        s.close();
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("tienda.fxml"));
        Parent root = fxmLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
