package MODEL;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

public class Borrar {

    public static void borrarUno(String key, String value, MongoCollection collection) {
        //Si la consulta me devuelve que ha afectado a una o mas columnas lo doy por borrado, de lo contrario da una alerta de error
        if (collection.deleteOne(eq(key, value)).getDeletedCount() >= 1) {
            Alertas.alertaInfo(Textos.ALUMNOBORRADOOK);
        } else {
            Alertas.alertaError(Textos.ALUMNOBORRADONOK);
        }

    }
}
