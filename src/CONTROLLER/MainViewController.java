package CONTROLLER;


import MODEL.conectar;
import MODEL.find;
import MODEL.pintar;
import MODEL.textos;
import MODEL.ventanas;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


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
            pintar.pintarMensaje(mainTextField, textos.NOENCONTRADO);
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
        
        ventanas ventanaInsertar = new ventanas(textos.VENTANAINSERTAR, textos.VENTANATITULODEFECTO);
        
    }

    @FXML
    private void clickActualizar(ActionEvent event) {
        
        ventanas ventanaInsertar = new ventanas(textos.VENTANAACTUALIZAR, textos.VENTANATITULODEFECTO);

    }

    @FXML
    private void clickBorrar(ActionEvent event) {
        
        ventanas ventanaInsertar = new ventanas(textos.VENTANABORRAR, textos.VENTANATITULODEFECTO);
        
    }
}
