package com.grupo02.videogamestore;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.TDAs.NodeList;
import com.grupo02.Readers.Reader;
import com.grupo02.TDAs.LinkedList;
import com.grupo02.comparators.*;
import com.grupo02.videogamestore.modelo.Juego;
import com.grupo02.videogamestore.modelo.Resena;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
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
    private Button btnwishList;

    @FXML
    private FlowPane fpTienda;

    @FXML
    private Button btnBuscar;

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
    
    public static DoublyCircularLinkedList<Juego> wishlist = new DoublyCircularLinkedList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Reader.leerJuegos("games_data.csv");
        listaJuegos = Reader.cargarJuegos("games_data.bin");
        cargarPrinciapal();
        cbxCategorias.getItems().addAll(Reader.generos);
    }

    @FXML
    public void cargarCategorias() throws IOException {
        if (vboxP.getChildren().size() == 2) {
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

    public static void renderizarResenas(VBox paneResenas, Resena r) {
        HBox reseña = new HBox();//una solo reseña, la la imagen del critico y la descripción
        VBox descripcionBox = new VBox();//va la cabecera y la reseña como tal
        HBox cabeceradescripción = new HBox();//estrellas y la fecha
        cabeceradescripción.getChildren().add(new Label(r.getFecha().toString()));
        for (int x = 1; x <= r.getCalificacion(); x++) {
            cabeceradescripción.getChildren().add(Reader.obtenerImagen("estrella.png", 15, 15));
        }
        cabeceradescripción.setSpacing(5);
        descripcionBox.getChildren().addAll(cabeceradescripción, new Label(r.getMensaje()));
        descripcionBox.setPadding(new Insets(5, 5, 5, 5));
        reseña.getChildren().addAll(Reader.obtenerImagen("user.png", 25, 25), descripcionBox);
        reseña.setStyle("-fx-background-color:#EEECFF");
        reseña.setPadding(new Insets(5, 5, 5, 5));
        paneResenas.getChildren().add(reseña);
    }

    public static void cargarDetalleJuego(Juego j) { //LUIS
        Stage stage = new Stage();
        VBox contenido = new VBox();
        ScrollPane root = new ScrollPane();
        contenido.setAlignment(Pos.CENTER);
        contenido.setPadding(new Insets(0, 10, 0, 10));
        HBox datos = new HBox();
        VBox infoBox = new VBox();
        Label lbltitulo = new Label(j.getTitulo());
        lbltitulo.setFont(Font.font("Verdana", 30));
        lbltitulo.setWrapText(true);
        Label lbldes = new Label(j.getDescripcion());
        lbldes.setPrefWidth(400);
        lbldes.setFont(Font.font("Verdana", 20));
        lbldes.setWrapText(true);
        Label lbldev = new Label();
        String textodev = "Desarrolladores: " + j.getDesarrollador().toString();
        lbldev.setPrefWidth(400);
        lbldev.setText(textodev);
        lbldev.setFont(Font.font("Verdana", 10));
        lbldev.setWrapText(true);
        Label lblgenero = new Label();
        String textogenero = "Géneros:" + j.getGenero().toString();
        lblgenero.setPrefWidth(400);
        lblgenero.setText(textogenero);
        lblgenero.setFont(Font.font("Verdana", 10));
        lblgenero.setWrapText(true);
        infoBox.getChildren().addAll(Reader.obtenerImagen(j.getImagen(), 200, 340), lbltitulo, lbldes, lbldev, lblgenero);
        infoBox.setStyle("-fx-background-color:#F8ECFF");
        infoBox.setSpacing(15);
        infoBox.setAlignment(Pos.CENTER);
        Separator sv = new Separator(Orientation.VERTICAL);
        sv.setPrefHeight(200);
        VBox capturasbBox = new VBox();
        Label lblcap = new Label("Capturas del juego");
        lblcap.setFont(Font.font("Verdana", 24));
        lblcap.setAlignment(Pos.CENTER);
        FlowPane caps = new FlowPane();
        for (String filecap : j.getCapturas()) {
            caps.getChildren().add(Reader.obtenerImagen(filecap, 100, 180));
        }
        caps.setHgap(30);
        caps.setVgap(30);
        capturasbBox.getChildren().addAll(lblcap, caps);
        capturasbBox.setAlignment(Pos.CENTER);
        capturasbBox.setSpacing(15);
        datos.setSpacing(15);
        datos.setAlignment(Pos.CENTER);
        datos.getChildren().addAll(infoBox, sv, capturasbBox);
        Separator sh = new Separator(Orientation.HORIZONTAL);
        sh.setPrefWidth(15);
        VBox reseñasBox = new VBox();//caja de reseñas y carga una por una todo lo que viene debajo
        HBox cabeceraReseñas = new HBox();
        Label lblr = new Label("Reseñas ordenar por:");
        lblr.setFont(Font.font("Verdana", 20));
        ComboBox<String> cbxReseña = new ComboBox();
        cbxReseña.getItems().addAll("Puntuación de menor a mayor", "Puntucación de mayor a menor", "Reseñas recientes", "Reseñas antiguas");
        cabeceraReseñas.getChildren().addAll(lblr, cbxReseña);
        cabeceraReseñas.setSpacing(20);
        reseñasBox.getChildren().add(cabeceraReseñas);
        VBox contenedorResenas = new VBox();
        for (Resena r : j.getResenas()) {
            renderizarResenas(contenedorResenas, r);
        }
        reseñasBox.getChildren().add(contenedorResenas);
        cbxReseña.setOnAction(eh -> {
            
            LinkedList<Resena> resenasMostrar = j.getResenas();
            PriorityQueue<Resena> resenasOrdenadas = null;
            String vc = cbxReseña.getValue();
            contenedorResenas.getChildren().clear();
            if (vc.equals("Reseñas antiguas")) {
                resenasOrdenadas = new PriorityQueue<Resena>((o1, o2) -> {
                    if (o1.getFecha().getYear() - o2.getFecha().getYear() != 0) {
                        return o1.getFecha().getYear() - o2.getFecha().getYear();
                    }
                    if (o1.getFecha().getMonth() - o2.getFecha().getMonth() != 0) {
                        return o1.getFecha().getMonth() - o2.getFecha().getMonth();
                    }
                    return o1.getFecha().getDay() - o2.getFecha().getDay();

                });
            } else if (vc.equals("Reseñas recientes")) {
                resenasOrdenadas = new PriorityQueue<Resena>((o1, o2) -> {
                    Resena temp = o1;
                    o1 = o2;
                    o2 = temp;
                    if (o1.getFecha().getYear() - o2.getFecha().getYear() != 0) {
                        return o1.getFecha().getYear() - o2.getFecha().getYear();
                    }
                    if (o1.getFecha().getMonth() - o2.getFecha().getMonth() != 0) {
                        return o1.getFecha().getMonth() - o2.getFecha().getMonth();
                    }
                    return o1.getFecha().getDay() - o2.getFecha().getDay();
                });
            } else if (vc.equals("Puntuación de menor a mayor")) {
                resenasOrdenadas = new PriorityQueue<Resena>((o1, o2) -> {
                    return o1.getCalificacion() - o2.getCalificacion();

                });
            }
            else if (vc.equals("Puntucación de mayor a menor")) {
                resenasOrdenadas = new PriorityQueue<Resena>((o1, o2) -> {
                    return o2.getCalificacion() - o1.getCalificacion();
                });
            }
            for (Resena r: resenasMostrar){
                resenasOrdenadas.offer(r);
            }
            for (Resena r = resenasOrdenadas.poll(); r != null ; r = resenasOrdenadas.poll()) {
                renderizarResenas(contenedorResenas,r);
            }

        });

        reseñasBox.setAlignment(Pos.CENTER_LEFT);
        reseñasBox.setSpacing(15);
        contenido.setSpacing(15);
        HBox top = new HBox();
        Button whishlistButton = new Button("Agregar a mi lista de deseos");
        whishlistButton.setOnAction(acte -> agregaraWishList(j));
        top.getChildren().add(whishlistButton);
        top.setPadding(new Insets(10, 10, 10, 10));
        top.setAlignment(Pos.CENTER_RIGHT);
        contenido.getChildren().addAll(top, datos, sh, reseñasBox);
        root.setContent(contenido);
        Scene scene = new Scene(root, 900, 700);
        stage.setScene(scene);
        stage.show();
    }

    private static void agregaraWishList(Juego j) {
        if ((wishlist.isEmpty()) || (!wishlist.contains(j))) {
            wishlist.addLast(j);
        }
    }
    
    @FXML
    private void cambiarWishlist() throws IOException {
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("wishlist.fxml"));
        Parent root = fxmLoader.load();
        btnwishList.getScene().setRoot(root);
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
