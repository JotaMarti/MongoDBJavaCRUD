package MODEL;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Insertar {

    public static void insertaUno(String nom, String esp, String email, String ciudad, String a, String nota, String calle, String dni, MongoCollection col) {
        try {
            if (calle.isEmpty() & nota.isEmpty()) {
                Document document = new Document("nombre", nom)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(a))
                        .append("especialidad", esp)
                        .append("direccion", new Document("ciudad", ciudad))
                        .append("email", email);

                col.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);

            } else if (nota.isEmpty()) {
                Document document = new Document("nombre", nom)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(a))
                        .append("especialidad", esp)
                        .append("direccion", new Document("ciudad", ciudad)
                                .append("calle", calle))
                        .append("email", email);

                col.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);
            } else if (calle.isEmpty()) {
                Document document = new Document("nombre", nom)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(a))
                        .append("especialidad", esp)
                        .append("direccion", new Document("ciudad", ciudad))
                        .append("email", email)
                        .append("notaMedia", Double.parseDouble(nota));

                col.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);
            } else {
                Document document = new Document("nombre", nom)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(a))
                        .append("especialidad", esp)
                        .append("direccion", new Document("ciudad", ciudad)
                                .append("calle", calle))
                        .append("email", email)
                        .append("notaMedia", Double.parseDouble(nota));

                col.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);
            }
        } catch (com.mongodb.MongoWriteException e) {
            Alertas.alertaError(Textos.REVISAYEARDNI);
        } catch (java.lang.NumberFormatException e) {
           Alertas.alertaError(Textos.REVISAYEARNOTA);
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
