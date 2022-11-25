package com.grupo02.videogamestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import modelo.Usuario;

public class InicialController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static ArrayList<Usuario> cuentas;

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
        cuentas = cargarCuentas();
    }

    private ArrayList<Usuario> cargarCuentas() {
        ArrayList<Usuario> cuentas = new ArrayList();
        try ( BufferedReader br = new BufferedReader(new FileReader(App.filePath + "usuarios.txt"))) {
            String linea = br.readLine();
            while (linea != null) {
                String[] cuenta = linea.strip().split(";");
                Usuario u = new Usuario(String.valueOf(cuenta[0].strip()), String.valueOf(cuenta[1].strip()), cuenta[2].charAt(0));
                cuentas.add(u);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("error 1");
        }
        return cuentas;
    }

    private boolean cuentaCorrecta(String usuario, String contraseña) {
        for (Usuario cuenta : cuentas) {
            if ((cuenta.getUsuario().equals(usuario)) && (cuenta.getContraseña().equals(contraseña))) {
                App.setUser(cuenta);
                return true;
            }
        }
        return false;
    }

    @FXML
    private void ingresaralaApp() throws IOException {
        String usuario = txtUsuario.getText();
        String contraseña = txtpassword.getText();
        if (cuentaCorrecta(usuario, contraseña)) {
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

    public static ArrayList<Usuario> getCuentas() {
        return cuentas;
    }

}
