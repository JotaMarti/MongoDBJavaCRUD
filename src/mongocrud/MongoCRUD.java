
package mongocrud;


import MODEL.Textos;
import MODEL.Ventanas;
import javafx.application.Application;
import javafx.stage.Stage;

public class MongoCRUD extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Ventanas ventanaMain = new Ventanas(Textos.VENTANAMAIN, Textos.VENTANATITULODEFECTO);

    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
