package MODEL;

import java.util.List;
import org.json.JSONObject;

public class extract {

    private String nombre;
    private String dni;
    private String year;
    private String especialidad;
    private String email;
    private String ciudad;
    private String nota;
    private String calle;
    private JSONObject direccion;
    private estudiante[] array;

    public extract(List<String> resultados) {
        
        array = new estudiante[resultados.size()];

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
                nota = null;
            }
            ciudad = direccion.getString("ciudad");
            if (direccion.has("calle")) {
                calle = direccion.getString("calle");
            } else {
                calle = null;
            }
            
            array[i] = new estudiante(nombre, dni, year, especialidad, email, ciudad, nota, calle);

        }

    }
    
    public estudiante[] getArray(){
        return array;
    }

}
