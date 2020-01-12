package MODEL;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class actualizar {

    public static void actualizarUno(String k, String v, String kToUpd, String vToUpd, MongoCollection col) {
        
        Double nota;

        if (kToUpd.equals("calle")) {
            try {
                if (col.updateOne(eq(k, v), set("direccion.calle", vToUpd)).getModifiedCount() >= 1) {
                    alertas.alertaInfo(textos.TODOOK);
                } else {
                    alertas.alertaError(textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            }
        } else if (kToUpd.equals("ciudad")) {
            try {
                if (col.updateOne(eq(k, v), set("direccion.ciudad", vToUpd)).getModifiedCount() >= 1) {
                    alertas.alertaInfo(textos.TODOOK);
                } else {
                    alertas.alertaError(textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            }
        } else if (kToUpd.equals("notaMedia")) {
            nota = Double.parseDouble(vToUpd);
            try {
                if (col.updateOne(eq(k, v), set(kToUpd, nota)).getModifiedCount() >= 1) {
                    alertas.alertaInfo(textos.TODOOK);
                } else {
                    alertas.alertaError(textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            }
        } else {
            try {
                if (col.updateOne(eq(k, v), set(kToUpd, vToUpd)).getModifiedCount() >= 1) {
                    alertas.alertaInfo(textos.TODOOK);
                } else {
                    alertas.alertaError(textos.ERROR);
                }
            } catch (com.mongodb.MongoWriteException e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            } catch (Exception e) {
                alertas.alertaError(textos.ERROR);
                System.out.println(e);
            }
        }

    }
}
