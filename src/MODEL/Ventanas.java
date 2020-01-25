package MODEL;

import CONTROLLER.DeleteViewController;
import CONTROLLER.InsertarViewController;
import CONTROLLER.MainViewController;
import CONTROLLER.UpdateViewController;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mongocrud.MongoCRUD;

public class Ventanas {

    private String fxmlName;
    private String tituloVentana;

    public Ventanas(String fxmlName, String tituloVentana) {

        this.fxmlName = fxmlName;
        this.tituloVentana = tituloVentana;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MongoCRUD.class.getResource("/VIEW/" + fxmlName + ".fxml"));
            // Cargo la ventana
            Parent root = loader.load();

            // Cargo el scene
            if (this.fxmlName.equals(Textos.VENTANABORRAR)) {
                DeleteViewController controlador = loader.getController();
            } else if (this.fxmlName.equals(Textos.VENTANAINSERTAR)) {
                InsertarViewController controlador = loader.getController();
            } else if (this.fxmlName.equals(Textos.VENTANAACTUALIZAR)) {
                UpdateViewController controlador = loader.getController();
            } else {
                MainViewController controlador = loader.getController();
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            // Seteo la scene y la muestro
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            if (this.fxmlName.equals(Textos.VENTANAMAIN)) {
                stage.show();
            } else {
                stage.showAndWait();
            }
            stage.setTitle(this.tituloVentana);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/images/mongo.png"));
            if (this.fxmlName.equals(Textos.VENTANAMAIN)) {
                stage.setOnCloseRequest(e -> Platform.exit());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
