package MODEL;

import javafx.scene.control.Alert;

public class Alertas {

    public static void alertaError(String mensajeError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensajeError);
        alert.showAndWait();
    }

    public static void alertaInfo(String mensajeInfo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(mensajeInfo);
        alert.showAndWait();
    }
}
