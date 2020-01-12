
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
        //Quita el foco del textarea por defecto para que se pueda leer la leyenda
        textDniBorrar.setFocusTraversable(false);
    }

    @FXML
    private void clickBorrar(ActionEvent event) {
        //Recibo el dni del estudiante a borrar
        dni = textDniBorrar.getText();
        //Si el dni cumple el regex procedo a intentar borrar el alumno
        if (Check.checkDni(dni)) {
            
            Conectar myMongo = new Conectar();

            Borrar.borrarUno(Textos.PRIMARYKEY, dni, myMongo.getCollection());
            
        } else {
            
            Alertas.alertaError(Textos.ERRORDNI);
        }
        
    }

}
