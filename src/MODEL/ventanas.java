package MODEL;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mongocrud.MongoCRUD;

public class ventanas {

    private String fxmlName;
    private String tituloVentana;

    public ventanas(String n, String v) {

        fxmlName = n;
        tituloVentana = v;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MongoCRUD.class.getResource("/VIEW/" + n + ".fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();

            // Cargo el scene
            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            // Seteo la scene y la muestro
            stage.setScene(scene);
            stage.show();
            stage.setTitle(v);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/images/mongo.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
