package com.grupo02.videogamestore;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.TDAs.NodeList;
import com.grupo02.videogamestore.modelo.Juego;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TiendaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnCambiarUsuario;
    
    @FXML
    private Button btnBuscar;
    
    @FXML
    private TextField txtBuscador;

    @FXML
    private HBox hboxPrincipales;

    @FXML
    private HBox hboxCategorías;

    @FXML
    private HBox hbox1Top10;

    @FXML
    private HBox hbox2Top10;
    
    public static String textoaBuscar;
    @FXML
    private HBox hboxCabeza;
    @FXML
    private Button btnAdelante;
    @FXML
    private Button btnAtras;
    @FXML
    private ComboBox<?> cbxCategorías;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarPrincipales();
        cargarCategorías();
        cargarTOPJugados();
        cargarTOPVendidos();
        mostraBotones(hboxPrincipales, 0, 5);
        eliminarBotones(hboxPrincipales, 0, 6);
        mostraBotones(hboxCategorías, 0, 7);
        eliminarBotones(hboxCategorías, 0, 8);
    }

    private void mostraBotones(Pane p, int indice1, int indice2) {
        Button btndere = new Button(">");
        Button btnizq = new Button("<");
        p.addEventHandler(MouseEvent.MOUSE_ENTERED, me -> {
            p.getChildren().add(indice2, btndere);
            p.getChildren().add(indice1, btnizq);
            //mostrarAnteriores(btnizq);
            //mostrarSiguientes(btndere);
        });
        
        btndere.setOnAction(acte -> {
//            mostrarAnteriores();
        });
        btnizq.setOnAction(acte -> {
//            mostrarSiguientes();
        });
    }

    private void eliminarBotones(Pane p, int indice1, int indice2) {
        p.addEventHandler(MouseEvent.MOUSE_EXITED, me -> {
            p.getChildren().remove(indice2);
            p.getChildren().remove(indice1);
        });
    }

    public VBox cargarJuego(Juego juego){
        return null;
    }
    
    public void mostrarSiguientes(DoublyCircularLinkedList<Juego> l, Pane p){
        NodeList<Juego> temp = l.getFirst();
        NodeList<Juego> tempF = l.getLast();
        int size = l.size();
        for (int x = 0; x < size; x++){
            p.getChildren().add(cargarJuego(temp.getContent()));
            temp = temp.getNext();
            tempF = tempF.getNext();
            l.addLast(tempF.getContent());
            l.removeFirst();
        }
        
    }
    
    public void mostrarAnteriores(DoublyCircularLinkedList<Juego> l, Pane p){
        NodeList<Juego> temp = l.getLast();
        NodeList<Juego> tempF = l.getFirst();
        int size = l.size();
        for (int x = 0; x < size; x++){
            p.getChildren().add(cargarJuego(temp.getContent()));
            temp = temp.getPrevius();
            tempF = tempF.getPrevius();
            l.addFirst(tempF.getContent());
            l.removeLast();
        }
    }
    
    
    private void mostrarSiguientes(Button btn) {
        btn.setOnAction(acte -> {
            System.out.println(btn.getParent().getId() + "NEXT");
        });
    }

    private void mostrarAnteriores(Button btn, DoublyCircularLinkedList<Juego> l, Juego juego) {
        btn.setOnAction(acte -> {
            
            // Limpia el flowpane
            // Carga los 6 antes del primero
            System.out.println(btn.getParent().getId() + "BACK");
        });
    }

    @FXML
    private void cambiarUsuario() throws IOException {
        Stage s = (Stage) btnCambiarUsuario.getScene().getWindow();
        s.close();
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("Inicial.fxml"));
        Parent root = fxmLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void buscarVideojuego() throws IOException {
        if (!txtBuscador.getText().isBlank()){
            textoaBuscar = txtBuscador.getText();
            FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("buscar.fxml"));
            Parent root = fxmLoader.load();
            btnBuscar.getScene().setRoot(root);
        }
    }
    

    private void cargarPrincipales() {
        // temp = null;
        for (int x = 1; x <= 5; x++) {
            VBox vbx = new VBox();
            try ( FileInputStream input = new FileInputStream(App.fileImage + "lupa.png")) {
                Image img = new Image(input);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(100);
                imgview.setFitWidth(100);
                vbx.getChildren().addAll(imgview, new Label("TITULO"));
                hboxPrincipales.getChildren().add(vbx);
            } catch (IOException ex) {
                System.out.println("Error imagen 1");
            }
        }
        hboxPrincipales.setSpacing(60);
        hboxPrincipales.setAlignment(Pos.CENTER);
    }

    private void cargarCategorías() {
        for (int x = 1; x <= 7; x++) {
            VBox vbx = new VBox();
            try ( FileInputStream input = new FileInputStream(App.fileImage + "lupa.png")) {
                Image img = new Image(input);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(100);
                imgview.setFitWidth(100);
                vbx.getChildren().addAll(imgview, new Label("TITULO 1"), new Label("TITULO 2"), new Label("OTROS DATOS"), new Label("OTROS DATOS 2"));
                hboxCategorías.getChildren().add(vbx);
            } catch (IOException ex) {
                System.out.println("Error imagen 2");
            }
        }
        hboxCategorías.setSpacing(30);
        hboxCategorías.setAlignment(Pos.CENTER);
    }

    private void cargarTOPJugados() {
        for (int x = 1; x <= 10; x++) {
            VBox vbx = new VBox();
            try ( FileInputStream input = new FileInputStream(App.fileImage + "lupa.png")) {
                Image img = new Image(input);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(70);
                imgview.setFitWidth(20);
                vbx.getChildren().addAll(imgview, new Label("TITULO 1"), new Label("TITULO 2"), new Label("OTROS DATOS"), new Label("OTROS DATOS 2"));
                hbox1Top10.getChildren().add(vbx);
            } catch (IOException ex) {
                System.out.println("Error imagen 3");
            }
        }
        hbox1Top10.setSpacing(30);
        hbox1Top10.setAlignment(Pos.CENTER_LEFT);
    }

    private void cargarTOPVendidos() {
        for (int x = 1; x <= 10; x++) {
            VBox vbx = new VBox();
            try ( FileInputStream input = new FileInputStream(App.fileImage + "lupa.png")) {
                Image img = new Image(input);
                ImageView imgview = new ImageView(img);
                imgview.setFitHeight(70);
                imgview.setFitWidth(20);
                vbx.getChildren().addAll(imgview, new Label("TITULO 1"), new Label("TITULO 2"), new Label("OTROS DATOS"), new Label("OTROS DATOS 2"));
                hbox2Top10.getChildren().add(vbx);
            } catch (IOException ex) {
                System.out.println("Error imagen 4");
            }
        }
        hbox2Top10.setSpacing(30);
        hbox2Top10.setAlignment(Pos.CENTER_LEFT);
    }

    @FXML
    private void irAdelante(ActionEvent event) {
    }

    @FXML
    private void irAtras(ActionEvent event) {
    }

}