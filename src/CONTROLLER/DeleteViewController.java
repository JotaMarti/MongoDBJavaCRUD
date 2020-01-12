
package CONTROLLER;

import MODEL.Alertas;
import MODEL.Borrar;
import MODEL.Check;
import MODEL.Conectar;
import MODEL.Textos;
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
        textDniBorrar.setFocusTraversable(false);
    }

    @FXML
    private void clickBorrar(ActionEvent event) {
        
        dni = textDniBorrar.getText();
        
        if (Check.checkDni(dni)) {
            
            Conectar myMongo = new Conectar();

            Borrar.borrarUno(Textos.PRIMARYKEY, dni, myMongo.getCollection());
            
        } else {
            
            Alertas.alertaError(Textos.ERRORDNI);
        }

        
    }

}
