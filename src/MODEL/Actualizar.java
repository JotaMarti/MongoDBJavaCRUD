package MODEL;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class Actualizar {

    public static void actualizarUno(String k, String v, String kToUpd, String vToUpd, MongoCollection col) {
        
        Double nota;

        if (kToUpd.equals("calle")) {
            try {
                if (col.updateOne(eq(k, v), set("direccion.calle", vToUpd)).getModifiedCount() >= 1) {
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
        } else if (kToUpd.equals("ciudad")) {
            try {
                if (col.updateOne(eq(k, v), set("direccion.ciudad", vToUpd)).getModifiedCount() >= 1) {
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
        } else if (kToUpd.equals("notaMedia")) {
            nota = Double.parseDouble(vToUpd);
            try {
                if (col.updateOne(eq(k, v), set(kToUpd, nota)).getModifiedCount() >= 1) {
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
                if (col.updateOne(eq(k, v), set(kToUpd, vToUpd)).getModifiedCount() >= 1) {
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
