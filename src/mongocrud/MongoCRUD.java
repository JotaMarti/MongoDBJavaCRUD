
package mongocrud;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MongoCRUD extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MongoCRUD.class.getResource("/VIEW/MainView.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();

            // Cargo el scene
            Scene scene = new Scene(ventana);

            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("MongoDB CRUD by JotaMarti");
            primaryStage.setResizable(false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
