package com.grupo02.videogamestore;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;

public class RegistrarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox cbxTipoUsuario;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPsw;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxTipoUsuario.getItems().addAll("Usuario Común", "Administrador");
    }

    @FXML
    private void volveraInicial() throws IOException {
        Stage s = (Stage) btnVolver.getScene().getWindow();
        s.close();
        FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("Inicial.fxml"));
        Parent root = fxmLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void guardarUser() throws IOException {
        if ((txtUser.getText() == null) || (txtPsw.getText() == null) || (cbxTipoUsuario.getValue() == null)) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Campo(s) Incompletos");
            alerta.show();
            txtUser.clear();
            txtPsw.clear();
        } else {
            Usuario u = new Usuario(txtUser.getText(), txtPsw.getText(), String.valueOf(cbxTipoUsuario.getValue()).toUpperCase().charAt(0));
            if (siExiste(u)) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Usuario ya existente");
                alerta.show();
                txtUser.clear();
                txtPsw.clear();
            } else {
                try ( BufferedWriter bw = new BufferedWriter(new FileWriter(App.filePath + "usuarios.txt", true))) {
                    bw.write(u.toString() + "\n");
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("error 2");
                }
                Stage s = (Stage) btnGuardar.getScene().getWindow();
                s.close();
                FXMLLoader fxmLoader = new FXMLLoader(getClass().getResource("Inicial.fxml"));
                Parent root = fxmLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    private boolean siExiste(Usuario u) {
        for (Usuario cuenta : InicialController.getCuentas()) {
            System.out.println(cuenta.toString());
            if (cuenta.getUsuario().equals(u.getUsuario())) {
                return true;
            }
        }
        return false;
    }
}
