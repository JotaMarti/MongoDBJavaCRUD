package CONTROLLER;

import MODEL.borrar;
import MODEL.conectar;
import MODEL.find;
import MODEL.pintar;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mongocrud.MongoCRUD;

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
    private String key;
    private String value;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickBuscar(ActionEvent event) {
        //Recogo la key y value para usarla en la busqueda
        key = textKey.getText();
        value = textValue.getText();
        //Borro el Text area
        mainTextField.setText("");
        //Me conecto a la coleccion estudiantes
        conectar myMongo = new conectar();
        //Creao una lista con los resultados de la busqueda
        List<String> resultados = find.findOne(myMongo.getCollection(), key, value);
        //Si la lista que obtenemos de la busqueda esta vacia imprimimos NO ENCONTRADO, de lo contrario la imprimimos
        if (resultados.isEmpty()) {
            pintar.pintarMensaje(mainTextField, "NO ENCONTRADO");
        } else {
            pintar.refrescaPantalla(mainTextField, resultados);
        }
    }

    @FXML
    private void clickBuscarTodos(ActionEvent event) {
        //Simplemente llamamos al metodo finAll de la clase find y le pasamos el textarea donde debe pintar
        find.findAll(mainTextField);

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
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MongoCRUD.class.getResource("/VIEW/UpdateView.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();

            // Cargo el scene
            Scene scene = new Scene(ventana);
            Stage updStage = new Stage();
            // Seteo la scene y la muestro
            updStage.setScene(scene);
            updStage.show();
            updStage.setTitle("MongoDB CRUD by JotaMarti");
            updStage.setResizable(false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void clickBorrar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MongoCRUD.class.getResource("/VIEW/DeleteView.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();

            // Cargo el scene
            Scene scene = new Scene(ventana);
            Stage borrarStage = new Stage();
            // Seteo la scene y la muestro
            borrarStage.setScene(scene);
            borrarStage.show();
            borrarStage.setTitle("MongoDB CRUD by JotaMarti");
            borrarStage.setResizable(false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
