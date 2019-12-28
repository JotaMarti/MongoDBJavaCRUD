/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.conectar;
import MODEL.find;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mongocrud.MongoCRUD;

/**
 * FXML Controller class
 *
 * @author JotaMarti
 */
public class MainViewController implements Initializable {

    @FXML
    private TextField textKey;
    @FXML
    private TextField textValue;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnBuscarTodos;
    @FXML
    private Button btnInsertar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TextArea mainTextField;
    String key;
    String value;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickBuscar(ActionEvent event) {
        //Recogo la key y value para usarla en la busqueda
        // TO DO: Validar esto.
        key = textKey.getText();
        value = textValue.getText();
        
        mainTextField.setText("");
        conectar myMongo = new conectar("instituto");

        myMongo.setCollection("estudiantes");
        
        List<String> resultados = find.findOne(myMongo.getCollection(), key, value);

        for (int i = 0; i < resultados.size(); i++) {
            mainTextField.appendText(resultados.get(i) + "\n");
        }
        
        if(resultados.isEmpty()){
            mainTextField.setText("NO ENCONTRADO");
        }
    }

    @FXML
    private void clickBuscarTodos(ActionEvent event) {
        mainTextField.setText("");
        conectar myMongo = new conectar("instituto");

        myMongo.setCollection("estudiantes");

        for (int i = 0; i < find.findAll(myMongo.getCollection()).size(); i++) {
            mainTextField.appendText(find.findAll(myMongo.getCollection()).get(i) + "\n");
        }
    }

    @FXML
    private void clickInsertar(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MongoCRUD.class.getResource("/VIEW/InsertarView.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();
 
            // Cargo el scene
            Scene scene = new Scene(ventana);
            Stage insertstage = new Stage();
            // Seteo la scene y la muestro
            insertstage.setScene(scene);
            insertstage.show();
            insertstage.setTitle("MongoDB CRUD by JotaMarti");
            insertstage.setResizable(false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void clickActualizar(ActionEvent event) {
    }

    @FXML
    private void clickBorrar(ActionEvent event) {
    }

}
