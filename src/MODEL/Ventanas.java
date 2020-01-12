package MODEL;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mongocrud.MongoCRUD;

public class Ventanas {

    private String fxmlName;
    private String tituloVentana;

    public Ventanas(String n, String v) {

        fxmlName = n;
        tituloVentana = v;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MongoCRUD.class.getResource("/VIEW/" + fxmlName + ".fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();

            // Cargo el scene
            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            // Seteo la scene y la muestro
            stage.setScene(scene);
            stage.show();
            stage.setTitle(tituloVentana);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/images/mongo.png"));
            if(fxmlName.equals(Textos.VENTANAMAIN)){
                stage.setOnCloseRequest(e -> Platform.exit());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
