
package mongocrud;


import MODEL.textos;
import MODEL.ventanas;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MongoCRUD extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ventanas ventanaInsertar = new ventanas(textos.VENTANAMAIN, textos.VENTANATITULODEFECTO);

    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
