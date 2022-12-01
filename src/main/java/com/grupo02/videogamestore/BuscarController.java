package com.grupo02.videogamestore;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.TDAs.LinkedList;
import com.grupo02.TDAs.List;
import com.grupo02.comparators.ByName;
import com.grupo02.comparators.ByYear;
import com.grupo02.videogamestore.modelo.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class BuscarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnvolver;
    
    @FXML
    private CheckBox byTitle;
    
    @FXML
    private CheckBox byDate;

    @FXML
    private TextField textTitle;
    
    @FXML
    private TextField textDate;
    
    @FXML
    private VBox rootBuscar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Hola");
    }

    @FXML
    private void volver() throws IOException {
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("tienda.fxml"));
        Parent root = fxmLoader.load();
        btnvolver.getScene().setRoot(root);
    }
    
    
    @FXML
    private void buscarJuegos() throws IOException{
        if(rootBuscar.getChildren().size()==3){
            rootBuscar.getChildren().remove(2);
        }
        VBox paneBusqueda = new VBox();
        paneBusqueda.setAlignment(Pos.CENTER);
        FlowPane fpBusqueda = new FlowPane();
        fpBusqueda.setAlignment(Pos.CENTER);
        fpBusqueda.setHgap(10);
        fpBusqueda.setVgap(10);
        paneBusqueda.getChildren().add(fpBusqueda);
        rootBuscar.getChildren().add(paneBusqueda);
        LinkedList<Set<Juego>> setJuegos = new LinkedList();
        Set<Juego> temporales;
        if (byTitle.isSelected() && !textTitle.getText().isBlank()) {
            temporales = TiendaController.listaJuegos.findAllSet( new Juego(textTitle.getText()), new ByName());
            setJuegos.addLast(temporales);
        }
        if (byDate.isSelected() && !textDate.getText().isBlank()){
            temporales = TiendaController.listaJuegos.findAllSet(new Juego(new Date(Integer.parseInt(textDate.getText())-1900,1,1)), new ByYear());
            setJuegos.addLast(temporales);
        }
        
        if (!setJuegos.isEmpty()) {
            Set<Juego> intercepcion = setJuegos.getFirst().getContent();
            for(Set<Juego> set : setJuegos){
                intercepcion.retainAll(set);
            }
            if (!intercepcion.isEmpty()){
                DoublyCircularLinkedList<Juego> mostrar = new DoublyCircularLinkedList();
                for (Juego juego: intercepcion){
                    mostrar.addLast(juego);
                }
                TiendaController.cargarJuegos(mostrar, 4, fpBusqueda, paneBusqueda, 190, 435);
            }
        }
    }

}
