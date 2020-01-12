
package mongocrud;


import MODEL.textos;
import MODEL.ventanas;
import javafx.application.Application;
import javafx.stage.Stage;

public class MongoCRUD extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ventanas ventanaMain = new ventanas(textos.VENTANAMAIN, textos.VENTANATITULODEFECTO);

    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
