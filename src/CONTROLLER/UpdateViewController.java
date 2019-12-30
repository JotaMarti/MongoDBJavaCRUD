/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.actualizar;
import MODEL.conectar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JotaMarti
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBtnAct(ActionEvent event) {
        
        dni = textDni.getText();
        key = textKeyToUpd.getText();
        newValue = textNewValue.getText();
                
        conectar myMongo = new conectar();
        
        actualizar.actualizarUno("dni", dni, key, newValue, myMongo.getCollection());
        
        //find.findAll(mainTextField);
    }
    
}
