package MODEL;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONObject;

public class Extract {

    private String nombre;
    private String dni;
    private String year;
    private String especialidad;
    private String email;
    private String ciudad;
    private String nota;
    private String calle;
    private JSONObject direccion;
    private Estudiante[] estudiantesArray;
    private ObservableList<Estudiante> estudiantesObservableList;

    public Extract(List<String> resultados) {

        estudiantesArray = new Estudiante[resultados.size()];

        for (int i = 0; i < resultados.size(); i++) {

            nombre = null;
            dni = null;
            year = null;
            especialidad = null;
            email = null;
            ciudad = null;
            nota = null;
            calle = null;
            direccion = null;

            JSONObject jsonObj = new JSONObject(resultados.get(i));
            nombre = jsonObj.getString("nombre");
            dni = jsonObj.getString("dni");
            year = Integer.toString(jsonObj.getInt("año"));
            especialidad = jsonObj.getString("especialidad");
            email = jsonObj.getString("email");
            direccion = jsonObj.getJSONObject("direccion");
            if (jsonObj.has("notaMedia")) {
                nota = Double.toString(jsonObj.getDouble("notaMedia"));
            } else {
                nota = "N/A";
            }
            ciudad = direccion.getString("ciudad");
            if (direccion.has("calle")) {
                calle = direccion.getString("calle");
            } else {
                calle = "N/A";
            }

            estudiantesArray[i] = new Estudiante(nombre, dni, year, especialidad, email, ciudad, nota, calle);

        }
        buildOvservableList();

    }

    public Estudiante[] getArray() {
        return estudiantesArray;
    }

    public ObservableList<Estudiante> getObservableList() {

        return estudiantesObservableList;
    }

    public void buildOvservableList() {
        estudiantesObservableList = FXCollections.observableArrayList();

        for (int i = 0; i < estudiantesArray.length; i++) {
            estudiantesObservableList.add(estudiantesArray[i]);
        }
    }

}
