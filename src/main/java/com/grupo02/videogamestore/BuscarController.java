package com.grupo02.videogamestore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class BuscarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnvolver;

    @FXML
    private Label lblBusqueda;

    @FXML
    private FlowPane paneResultado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblBusqueda.setText("RESULTADOS DE LA BÚSQUEDA: \"" + TiendaController.textoaBuscar + "\"");
    }

    @FXML
    private void volver() throws IOException {
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("tienda.fxml"));
        Parent root = fxmLoader.load();
        btnvolver.getScene().setRoot(root);
    }

}
