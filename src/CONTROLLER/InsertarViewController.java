/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.conectar;
import MODEL.insertar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JotaMarti
 */
public class InsertarViewController implements Initializable {

    @FXML
    private TextField textNombre;
    @FXML
    private TextField textEspecialidad;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textCiudad;
    @FXML
    private TextField textAno;
    @FXML
    private TextField textNotaMedia;
    @FXML
    private TextField textCalle;
    @FXML
    private Button btnInsertat;
    String nombre;
    String especialidad;
    String email;
    String ciudad;
    String año;
    String notaMedia;
    String calle;
    String dni;
    @FXML
    private TextField textDni;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickInsertar(ActionEvent event) {

        nombre = textNombre.getText();
        especialidad = textEspecialidad.getText();
        email = textEmail.getText();
        ciudad = textCiudad.getText();
        año = textAno.getText();
        notaMedia = textNotaMedia.getText();
        calle = textCalle.getText();
        dni = textDni.getText();

        if (nombre.isEmpty() || especialidad.isEmpty() || email.isEmpty() || ciudad.isEmpty() || año.isEmpty() || dni.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Por favor, rellena los campos obligatorios correctamente.\n");
            alert.showAndWait();
        } else {
            conectar myMongo2 = new conectar("instituto");

            myMongo2.setCollection("estudiantes");

            insertar.insertaUno(nombre, especialidad, email, ciudad, año, notaMedia, calle, dni, myMongo2.getCollection());
        }

    }

}
