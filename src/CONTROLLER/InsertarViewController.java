package CONTROLLER;

import MODEL.Alertas;
import MODEL.Check;
import MODEL.Conectar;
import MODEL.Insertar;
import MODEL.Textos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class InsertarViewController implements Initializable {


    @FXML
    private TextField textNombre;
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
    @FXML
    private ChoiceBox<String> cb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Añado las opciones al choice box
        cb.getItems().add("informatica");
        cb.getItems().add("comercio");
        cb.getItems().add("enfermeria");
        cb.getItems().add("hosteleria");
    }

    @FXML
    private void clickInsertar(ActionEvent event) {

        nombre = textNombre.getText();
        especialidad = (String) cb.getValue();
        email = textEmail.getText();
        ciudad = textCiudad.getText();
        año = textAno.getText();
        notaMedia = textNotaMedia.getText();
        calle = textCalle.getText();
        dni = textDni.getText();
        dni = dni.toLowerCase();
        
        //Diversas comprobaciones por si hay algun dato erroneo, si esta todo ok realiza la insercion
        if (nombre.isEmpty() || especialidad.isEmpty() || email.isEmpty() || ciudad.isEmpty() || año.isEmpty() || dni.isEmpty()) {
            Alertas.alertaError(Textos.REVISACAMPOS);
        } else if (!Check.checkEmail(email)) {
            Alertas.alertaError(Textos.REVISAEMAIL);
        } else if(!Check.checkDni(dni)){
             Alertas.alertaError(Textos.ERRORDNI);
        } else {
            
            Conectar myMongo2 = new Conectar();

            Insertar.insertaUno(nombre, especialidad, email, ciudad, año, notaMedia, calle, dni, myMongo2.getCollection());
        }

    }

}
