package CONTROLLER;

import MODEL.TableUtils;
import MODEL.alertas;
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
import javafx.scene.control.SelectionMode;
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
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(tableView);
    }

    @FXML
    private void clickBuscar(ActionEvent event) {
        key = textKey.getText();
        value = textValue.getText();
        TableColumn[] arrayTablas = {columnDni, columnNombre, columnEmail, columnEspecialidad, columnYear, columnCiudad, columnCalle, columnNota};
        tableView.getItems().clear();
        find.findOneTabla(tableView, lista, arrayTablas, key, value);

    }

    @FXML
    private void clickBuscarTodos(ActionEvent event) {
        //Limpiamos la tabla
        tableView.getItems().clear();
        //Creamos un array con las columnas para no tener que pasarlas una a una
        TableColumn[] arrayTablas = {columnDni, columnNombre, columnEmail, columnEspecialidad, columnYear, columnCiudad, columnCalle, columnNota};
        //Llamamos al metodo finall y le pasamos la tableview, la observable list y el array de las tablas
        find.findAllTable(tableView, lista, arrayTablas, mainTextField);

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
