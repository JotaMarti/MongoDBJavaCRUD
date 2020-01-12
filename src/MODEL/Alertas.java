package MODEL;

import javafx.scene.control.Alert;

public class Alertas {

    public static void alertaError(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(s);
        alert.showAndWait();
    }

    public static void alertaInfo(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(s);
        alert.showAndWait();
    }
}
