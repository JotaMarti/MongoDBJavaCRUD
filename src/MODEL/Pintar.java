package MODEL;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class Pintar {

    public static void refrescaPantalla(TextArea textArea, List<String> resultados) {
        textArea.setText("");

        for (int i = 0; i < resultados.size(); i++) {
            textArea.appendText(resultados.get(i) + "\n");
        }
    }

    public static void pintarMensaje(TextArea ta, String s) {
        ta.setText(s);
    }

    public static void refrescaPantallaView(TableView<Estudiante> tableView, ObservableList<Estudiante> estudiantes) {
        tableView.setItems(estudiantes);

    }
}
