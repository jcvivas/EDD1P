package com.grupo02.videogamestore;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.TDAs.NodeList;
import com.grupo02.Readers.Reader;
import com.grupo02.TDAs.LinkedList;
import com.grupo02.comparators.ByGenre;
import com.grupo02.comparators.ByName;
import com.grupo02.comparators.ByYear;
import com.grupo02.videogamestore.modelo.Juego;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TiendaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnCambiarUsuario;

    @FXML
    private FlowPane fpTienda;

    @FXML
    private Button btnBuscar;

    @FXML
    private TextField txtBuscador;

    @FXML
    private VBox vboxPrincipal;

    @FXML
    private HBox hboxCategorías;

    @FXML
    private HBox juegosCategorías;

    public static String textoaBuscar;

    @FXML
    private VBox rootPrincipal;
    @FXML
    private VBox vboxP;

    @FXML
    private ComboBox<String> cbxCategorias;

    public static DoublyCircularLinkedList<Juego> listaJuegos;
    public static HashSet<String> generos;
    public static HashSet<String> desarrolladoras;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaJuegos = Reader.cargarJuegos("games_data.bin");
        cargarPrinciapal();
        cbxCategorias.getItems().addAll(Reader.generos);
        //Reader.leerJuegos("games_data.csv");
    }
    
    @FXML
    public void cargarCategorias() throws IOException{
        if(vboxP.getChildren().size()==2){
            vboxP.getChildren().remove(1);
        }
        HBox paneCategoria = new HBox();
        paneCategoria.setAlignment(Pos.CENTER);
        HBox hboxCategoria = new HBox();
        hboxCategoria.setAlignment(Pos.CENTER);
        hboxCategoria.setSpacing(10);
        paneCategoria.getChildren().add(hboxCategoria);
        vboxP.getChildren().add(paneCategoria);
        Juego jBuscar = new Juego("");
        String cat = cbxCategorias.getValue();
        jBuscar.getGenero().addFirst(cat);
        
        DoublyCircularLinkedList<Juego> mostrar = listaJuegos.findAll(jBuscar, new ByGenre());
        TiendaController.cargarJuegos(mostrar, 3, hboxCategoria, paneCategoria, 75, 200);
            
        

    }

    public static VBox cargarJuego(Juego j, int largo, int ancho) {//LUIS
        VBox vbx = new VBox();
        Label l = new Label(j.getTitulo());
        l.setFont(Font.font("Verdana", 15));
        l.setWrapText(true);
        l.setPrefWidth(ancho);
        vbx.getChildren().addAll(Reader.obtenerImagen(j.getImagen(), largo, ancho), l);
        vbx.setOnMouseClicked(mc -> cargarDetalleJuego(j));
        return vbx;
    }

    public static void cargarDetalleJuego(Juego j) { //LUIS
        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, 880, 520);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(0, 10, 0, 10));
        VBox datos = new VBox();
        Label lbltitulo = new Label(j.getTitulo());
        Label lbldes = new Label(j.getDescripcion());
        Label lbldev = new Label("DESARROLLADOR");
        Label lblgenero = new Label("GENERO");
        Label lblreseña = new Label("RESEÑAS");
        datos.getChildren().addAll(lbltitulo, lbldes, lbldev, lblgenero, lblreseña);
        datos.setAlignment(Pos.CENTER);
        datos.setStyle("-fx-background-color:#86b5fc");
        root.setSpacing(20);
        root.getChildren().addAll(Reader.obtenerImagen(j.getImagen(), 180, 320), datos);
        stage.setScene(scene);
        stage.show();
    }

    private static void mostraBotones(Pane pJuegos, Pane pExterior, DoublyCircularLinkedList<Juego> mostrados, DoublyCircularLinkedList<Juego> originales, int largo, int ancho) {

        Button btn2 = new Button("SIGUIENTE");
        Button btn1 = new Button("ATRÁS");
        pExterior.addEventHandler(MouseEvent.MOUSE_ENTERED, me -> {
            pExterior.getChildren().add(1, btn2);
            pExterior.getChildren().add(0, btn1);
        });
        btn1.setOnAction(acte -> {
            mostrarAnteriores(pJuegos, mostrados, originales, largo, ancho);
        });
        btn2.setOnAction(acte -> {
            mostrarSiguientes(pJuegos, mostrados, originales, largo, ancho);
        });
    }

    private static void eliminarBotones(Pane pExterior) {
        pExterior.addEventHandler(MouseEvent.MOUSE_EXITED, me -> {
            pExterior.getChildren().remove(2);
            pExterior.getChildren().remove(0);
        });
    }

    private static void renderizarJuegos(DoublyCircularLinkedList<Juego> juegos, Pane p, int largo, int ancho) {
        if (!juegos.isEmpty()) {
            for (Juego j : juegos) {
                p.getChildren().add(cargarJuego(j, largo, ancho));
            }
        }
    }

    private static void mostrarSiguientes(Pane p, DoublyCircularLinkedList<Juego> mostrados, DoublyCircularLinkedList<Juego> originales, int largo, int ancho) {
        p.getChildren().clear();
        NodeList<Juego> tempF = originales.getNode(mostrados.getLast().getContent());
        int size = mostrados.size();
        for (int x = 0; x < size; x++) {
            tempF = tempF.getNext();
            mostrados.addLast(tempF.getContent());
            mostrados.removeFirst();
        }
        renderizarJuegos(mostrados, p, largo, ancho);

    }

    public static void mostrarAnteriores(Pane p, DoublyCircularLinkedList<Juego> mostrados, DoublyCircularLinkedList<Juego> originales, int largo, int ancho) {
        p.getChildren().clear();
        NodeList<Juego> tempF = originales.getNode(mostrados.getFirst().getContent());
        int size = mostrados.size();
        for (int x = 0; x < size; x++) {
            tempF = tempF.getPrevius();
            mostrados.addFirst(tempF.getContent());
            mostrados.removeLast();
        }
        renderizarJuegos(mostrados, p, largo, ancho);
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
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("buscar.fxml"));
        Parent root = fxmLoader.load();
        btnBuscar.getScene().setRoot(root);

    }

    public static void cargarJuegos(DoublyCircularLinkedList<Juego> originales, int cantidadJuegos, Pane pJuegos, Pane pExterior, int largo, int ancho) {
        
        DoublyCircularLinkedList<Juego> mostrados = Reader.inicializarLista(originales, cantidadJuegos);
        renderizarJuegos(mostrados, pJuegos, largo, ancho);
        mostraBotones(pJuegos, pExterior, mostrados, originales, largo, ancho);
        eliminarBotones(pExterior);
    }

    private void cargarPrinciapal() {
        cargarJuegos(listaJuegos, 6, fpTienda, vboxPrincipal, 110, 330);
        cargarJuegos(listaJuegos, 3, juegosCategorías, hboxCategorías, 75, 200);
    }

}
