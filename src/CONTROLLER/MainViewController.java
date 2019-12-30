package CONTROLLER;


import MODEL.conectar;
import MODEL.estudiante;
import MODEL.extract;
import MODEL.find;
import MODEL.pintar;
import MODEL.textos;
import MODEL.ventanas;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


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
    @FXML
    private TableView<estudiante> tableView;
    @FXML
    private TableColumn<estudiante, String> columnDni;
    @FXML
    private TableColumn<estudiante, String> columnNombre;
    @FXML
    private TableColumn<estudiante, String> columnEmail;
    @FXML
    private TableColumn<estudiante, String> columnEspecialidad;
    @FXML
    private TableColumn<estudiante, String> columnYear;
    @FXML
    private TableColumn<estudiante, String> columnCiudad;
    @FXML
    private TableColumn<estudiante, String> columnCalle;
    @FXML
    private TableColumn<estudiante, String> columnNota;
    public ObservableList<estudiante> lista = FXCollections.observableArrayList(); 
    private estudiante[] array;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnDni.setCellValueFactory(new PropertyValueFactory<estudiante, String>("dni"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<estudiante, String>("nombre"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<estudiante, String>("email"));
        columnEspecialidad.setCellValueFactory(new PropertyValueFactory<estudiante, String>("especialidad"));
        columnYear.setCellValueFactory(new PropertyValueFactory<estudiante, String>("year"));
        columnCiudad.setCellValueFactory(new PropertyValueFactory<estudiante, String>("ciudad"));
        columnCalle.setCellValueFactory(new PropertyValueFactory<estudiante, String>("calle"));
        columnNota.setCellValueFactory(new PropertyValueFactory<estudiante, String>("nota"));
        
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
        tableView.getColumns().clear();
        extract e = new extract(find.findAll(mainTextField));
        
        array = e.getArray();
        
        for (int i = 0; i < array.length; i++) {
            lista.add(array[i]);
        }
        
        tableView.getColumns().clear();
        tableView.setItems(lista);
        tableView.getColumns().addAll(columnDni, columnNombre, columnEmail, columnEspecialidad, columnYear, columnCiudad, columnCalle, columnNota);
        

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
