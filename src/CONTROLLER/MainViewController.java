package CONTROLLER;

import MODEL.TableUtils;
import MODEL.Estudiante;
import MODEL.Find;
import MODEL.Textos;
import MODEL.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController implements Initializable {

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
    private TableView<Estudiante> tableView;
    @FXML
    private TableColumn<Estudiante, String> columnDni;
    @FXML
    private TableColumn<Estudiante, String> columnNombre;
    @FXML
    private TableColumn<Estudiante, String> columnEmail;
    @FXML
    private TableColumn<Estudiante, String> columnEspecialidad;
    @FXML
    private TableColumn<Estudiante, String> columnYear;
    @FXML
    private TableColumn<Estudiante, String> columnCiudad;
    @FXML
    private TableColumn<Estudiante, String> columnCalle;
    @FXML
    private TableColumn<Estudiante, String> columnNota;
    public ObservableList<Estudiante> lista = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> mainCb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializamos el TableView y el Choicebox principal
        columnDni.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("dni"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("email"));
        columnEspecialidad.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("especialidad"));
        columnYear.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("year"));
        columnCiudad.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("ciudad"));
        columnCalle.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("calle"));
        columnNota.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nota"));
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // Añadimos un listener para poder copiar valores del tableview
        TableUtils.installCopyPasteHandler(tableView);
        // Añadimos las opciones al choicebox
        mainCb.getItems().add("nombre");
        mainCb.getItems().add("dni");
        mainCb.getItems().add("email");
        mainCb.getItems().add("año");
        mainCb.getItems().add("especialidad");
        mainCb.getItems().add("notaMedia");
        mainCb.getItems().add("calle");
        mainCb.getItems().add("ciudad");

    }

    @FXML
    private void clickBuscar(ActionEvent event) {
        key = (String) mainCb.getValue();
        value = textValue.getText();
        TableColumn[] arrayTablas = {columnDni, columnNombre, columnEmail, columnEspecialidad, columnYear, columnCiudad, columnCalle, columnNota};
        tableView.getItems().clear();
        Find.findOneTabla(tableView, lista, arrayTablas, key, value);

    }

    @FXML
    private void clickBuscarTodos(ActionEvent event) {
        //Limpiamos la tabla
        tableView.getItems().clear();
        //Creamos un array con las columnas para no tener que pasarlas una a una
        TableColumn[] arrayTablas = {columnDni, columnNombre, columnEmail, columnEspecialidad, columnYear, columnCiudad, columnCalle, columnNota};
        //Llamamos al metodo finall y le pasamos la tableview, la observable list y el array de las tablas
        Find.findAllTable(tableView, lista, arrayTablas, mainTextField);

    }

    @FXML
    private void clickInsertar(ActionEvent event) {

        Ventanas ventanaInsertar = new Ventanas(Textos.VENTANAINSERTAR, Textos.VENTANATITULODEFECTO);

    }

    @FXML
    private void clickActualizar(ActionEvent event) {

        Ventanas ventanaActualizar = new Ventanas(Textos.VENTANAACTUALIZAR, Textos.VENTANATITULODEFECTO);

    }

    @FXML
    private void clickBorrar(ActionEvent event) {

        Ventanas ventanaBorrar = new Ventanas(Textos.VENTANABORRAR, Textos.VENTANATITULODEFECTO);

    }
}
