package MODEL;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class Actualizar {

    public static void actualizarUno(String key, String value, String keyToUpdate, String valueToUpdate, MongoCollection collection) {

        if (keyToUpdate.equals("calle")) {
            try {
                if (collection.updateOne(eq(key, value), set("direccion.calle", valueToUpdate)).getModifiedCount() >= 1) {
                    Alertas.alertaInfo(Textos.TODOOK);
                } else {
                    Alertas.alertaError(Textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            }
        } else if (keyToUpdate.equals("ciudad")) {
            try {
                if (collection.updateOne(eq(key, value), set("direccion.ciudad", valueToUpdate)).getModifiedCount() >= 1) {
                    Alertas.alertaInfo(Textos.TODOOK);
                } else {
                    Alertas.alertaError(Textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            }
        } else if (keyToUpdate.equals("notaMedia")) {
            try {
                if (collection.updateOne(eq(key, value), set(keyToUpdate, Double.parseDouble(valueToUpdate))).getModifiedCount() >= 1) {
                    Alertas.alertaInfo(Textos.TODOOK);
                } else {
                    Alertas.alertaError(Textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            }
        } else {
            try {
                if (collection.updateOne(eq(key, value), set(keyToUpdate, valueToUpdate)).getModifiedCount() >= 1) {
                    Alertas.alertaInfo(Textos.TODOOK);
                } else {
                    Alertas.alertaError(Textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                Alertas.alertaError(Textos.ERROR);
                System.out.println(e);
            }
        }

    }
}
