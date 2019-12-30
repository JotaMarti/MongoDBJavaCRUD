/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.borrar;
import MODEL.conectar;
import MODEL.find;
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
public class DeleteViewController implements Initializable {

    @FXML
    private TextField textDniBorrar;
    @FXML
    private Button btnBorrar;
    String dni;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBorrar(ActionEvent event) {
        dni = textDniBorrar.getText();
        
        conectar myMongo = new conectar();

        borrar.borrarUno("dni", dni, myMongo.getCollection());

        //find.findAll(mainTextField);
    }
    
}
