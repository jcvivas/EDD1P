package com.grupo02.videogamestore;

import com.grupo02.Readers.Reader;
import com.grupo02.TDAs.LinkedList;
import com.grupo02.TDAs.NodeList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.grupo02.videogamestore.modelo.Usuario;

public class InicialController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static LinkedList<Usuario> cuentas = new LinkedList();

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnIngresar;
    
    @FXML
    private Button btnRegistrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Usuario usr1 = new Usuario("luisJ","123",'U');
//        Usuario usr2 = new Usuario("robtrivi","edd1",'A');
//        Usuario usr3 = new Usuario("mendesG","444",'U');
//        cuentas.addLast(usr1);
//        cuentas.addLast(usr2);
//        cuentas.addLast(usr3);
//        Reader.guardarDatosUsuarios(cuentas, "users.bin");
        cuentas = Reader.cargarUsuarios("users.bin");
        for (Usuario c:cuentas){
            System.out.println(c);
        }
    }
    
    public static Usuario cuenta;

    private Usuario cuentaCorrecta(String usuario, String contraseña) {
        Usuario usrIngresado = new Usuario(usuario,contraseña,'A');
        NodeList<Usuario> encontrado = cuentas.getNode(usrIngresado);
        if (encontrado==null) {
            return null;
        }
        return encontrado.getContent();
    }

    @FXML
    private void ingresaralaApp() throws IOException {
        String usuario = txtUsuario.getText();
        String contraseña = txtpassword.getText();
        cuenta = cuentaCorrecta(usuario,contraseña);
        if (cuenta instanceof Usuario) {
            Stage s = (Stage) btnIngresar.getScene().getWindow();
            s.close();
            FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("tienda.fxml"));
            Parent root = fxmLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Usuario y/o contraseña incorecto(s)");
            alerta.show();
            txtUsuario.clear();
            txtpassword.clear();
        }
    }

    @FXML
    private void iraRegistrar() throws IOException {
        Stage s = (Stage) btnRegistrar.getScene().getWindow();
        s.close();
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("registrar.fxml"));
        Parent root = fxmLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public static LinkedList<Usuario> getCuentas() {
        return cuentas;
    }

}
