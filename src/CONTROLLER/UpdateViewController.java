package CONTROLLER;

import MODEL.Actualizar;
import MODEL.Alertas;
import MODEL.Check;
import MODEL.Conectar;
import MODEL.Textos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UpdateViewController implements Initializable {

    @FXML
    private TextField textDni;
    @FXML
    private TextField textNewValue;
    @FXML
    private Button btnAct;
    String dni;
    String key;
    String newValue;
    @FXML
    private ChoiceBox<String> updCb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeChoiceBox();
    }

    @FXML
    private void clickBtnAct(ActionEvent event) {

        dni = textDni.getText();
        key = (String) updCb.getValue();
        newValue = textNewValue.getText();

        try {
            if (Check.checkDni(dni)) {

                Conectar myMongo = new Conectar();

                Actualizar.actualizarUno(Textos.PRIMARYKEY, dni, key, newValue, myMongo.getCollection());

            } else {

                Alertas.alertaError(Textos.ERRORDNI);

            }
        } catch (java.lang.NullPointerException e) {
            Alertas.alertaError(Textos.REVISACAMPOS);
        }

    }

    public void initializeChoiceBox() {
        updCb.getItems().add("nombre");
        updCb.getItems().add("especialidad");
        updCb.getItems().add("notaMedia");
        updCb.getItems().add("calle");
        updCb.getItems().add("ciudad");
        updCb.getItems().add("email");
        updCb.getSelectionModel().selectFirst();
    }

}
