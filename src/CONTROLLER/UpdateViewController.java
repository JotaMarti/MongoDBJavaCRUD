
package CONTROLLER;

import MODEL.actualizar;
import MODEL.alertas;
import MODEL.check;
import MODEL.conectar;
import MODEL.textos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class UpdateViewController implements Initializable {

    @FXML
    private TextField textDni;
    @FXML
    private TextField textKeyToUpd;
    @FXML
    private TextField textNewValue;
    @FXML
    private Button btnAct;
    String dni;
    String key;
    String newValue;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBtnAct(ActionEvent event) {
        
        dni = textDni.getText();
        key = textKeyToUpd.getText();
        newValue = textNewValue.getText();
        
        if (check.checkDni(dni)) {
            
            conectar myMongo = new conectar();

            actualizar.actualizarUno(textos.PRIMARYKEY, dni, key, newValue, myMongo.getCollection());
            
        } else {
            
            alertas.alertaError(textos.ERRORDNI);
            
        }
        
    }
    
}
