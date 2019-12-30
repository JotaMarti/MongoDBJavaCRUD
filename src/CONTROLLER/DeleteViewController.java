
package CONTROLLER;

import MODEL.alertas;
import MODEL.borrar;
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


public class DeleteViewController implements Initializable {

    @FXML
    private TextField textDniBorrar;
    @FXML
    private Button btnBorrar;
    private String dni;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickBorrar(ActionEvent event) {
        
        dni = textDniBorrar.getText();
        
        if (check.checkDni(dni)) {
            
            conectar myMongo = new conectar();

            borrar.borrarUno(textos.PRIMARYKEY, dni, myMongo.getCollection());
            
        } else {
            
            alertas.alertaError(textos.ERRORDNI);
        }

        
    }

}
