package CONTROLLER;

import MODEL.Alertas;
import MODEL.TableUtils;
import MODEL.Estudiante;
import MODEL.Find;
import MODEL.Textos;
import MODEL.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
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
    private String operadorComparacion;
    @FXML
    private TableView<Estudiante> tableView;
    @FXML
    private TableColumn columnDni;
    @FXML
    private TableColumn columnNombre;
    @FXML
    private TableColumn columnEmail;
    @FXML
    private TableColumn columnEspecialidad;
    @FXML
    private TableColumn columnYear;
    @FXML
    private TableColumn columnCiudad;
    @FXML
    private TableColumn columnCalle;
    @FXML
    private TableColumn columnNota;
    public ObservableList<Estudiante> estudiantes;
    @FXML
    private ChoiceBox<String> mainCb;
    @FXML
    private ChoiceBox<String> comparacionCb;
    String resultado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeTableView();
        initializeChoicebox();
        estudiantes = FXCollections.observableArrayList();
        resultado = "";

    }

    @FXML
    private void clickBuscar(ActionEvent event) {
        operadorComparacion = (String) comparacionCb.getValue();
        key = (String) mainCb.getValue();
        value = textValue.getText();
        //Find.findOneTabla(tableView, estudiantes, key, value, operadorComparacion, mainTextField);
        buscaUnoNuevoHilo();

    }

    @FXML
    private void clickBuscarTodos(ActionEvent event) {
        buscaTodosNuevoHilo();

    }

    @FXML
    private void clickInsertar(ActionEvent event) {

        Ventanas ventanaInsertar = new Ventanas(Textos.VENTANAINSERTAR, Textos.VENTANATITULODEFECTO);
        buscaTodosNuevoHilo();
    }

    @FXML
    private void clickActualizar(ActionEvent event) {

        Ventanas ventanaActualizar = new Ventanas(Textos.VENTANAACTUALIZAR, Textos.VENTANATITULODEFECTO);
        buscaTodosNuevoHilo();
    }

    @FXML
    private void clickBorrar(ActionEvent event) {

        Ventanas ventanaBorrar = new Ventanas(Textos.VENTANABORRAR, Textos.VENTANATITULODEFECTO);
        buscaTodosNuevoHilo();
    }

    public void initializeTableView() {
        columnDni.setCellValueFactory(new PropertyValueFactory("dni"));
        columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnEmail.setCellValueFactory(new PropertyValueFactory("email"));
        columnEspecialidad.setCellValueFactory(new PropertyValueFactory("especialidad"));
        columnYear.setCellValueFactory(new PropertyValueFactory("year"));
        columnCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        columnCalle.setCellValueFactory(new PropertyValueFactory("calle"));
        columnNota.setCellValueFactory(new PropertyValueFactory("nota"));
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(tableView);
    }

    public void initializeChoicebox() {
        mainCb.getItems().add("nombre");
        mainCb.getItems().add("dni");
        mainCb.getItems().add("email");
        mainCb.getItems().add("año");
        mainCb.getItems().add("especialidad");
        mainCb.getItems().add("notaMedia");
        mainCb.getItems().add("calle");
        mainCb.getItems().add("ciudad");
        comparacionCb.getItems().add("Igual");
        comparacionCb.getItems().add("Mayor que");
        comparacionCb.getItems().add("Mayor o igual que");
        comparacionCb.getItems().add("Menor que");
        comparacionCb.getItems().add("Menor o igual que");
        comparacionCb.getItems().add("Distinto");
        comparacionCb.setDisable(true);
        mainCb.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> actualizaChoiceBox(newValue));
    }

    private void actualizaChoiceBox(String value) {
        if (value.equals("notaMedia") | value.equals("año")) {
            comparacionCb.setDisable(false);
            comparacionCb.getSelectionModel().selectFirst();
        } else {
            comparacionCb.setDisable(true);
            comparacionCb.getSelectionModel().selectFirst();
        }

    }

    public void buscaTodosNuevoHilo() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Find.findAllTable(tableView, estudiantes, mainTextField);
            }
        };
        thread.start();

    }

    public void erroresBusuedaUno() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (resultado.equals(Textos.MAINERRORNOENCONTRADO)) {
                    Alertas.alertaError(Textos.MAINERRORNOENCONTRADO);
                } else if (resultado.equals(Textos.REVISAYEARNOTA)) {
                    Alertas.alertaError(Textos.REVISAYEARNOTA);
                }
            }
        });
    }

    public void buscaUnoNuevoHilo() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                resultado = Find.findOneTabla(tableView, estudiantes, key, value, operadorComparacion, mainTextField);
                erroresBusuedaUno();
            }
        };
        thread.start();

    }
}
