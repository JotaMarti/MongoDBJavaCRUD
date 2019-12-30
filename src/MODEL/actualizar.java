package MODEL;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class actualizar {

    public static void actualizarUno(String k, String v, String kToUpd, String vToUpd, MongoCollection col) {

        try {
            if (col.updateOne(eq(k, v), set(kToUpd, vToUpd)).getModifiedCount() >= 1) {
                alertas.alertaInfo(textos.TODOOK);
            } else {
                alertas.alertaError(textos.ERROR);
            }
        } catch (com.mongodb.MongoWriteException e) {
            alertas.alertaError(textos.ERROR);
        } catch (Exception e){
            alertas.alertaError(textos.ERROR);
            System.out.println(e);
        }

    }
}
