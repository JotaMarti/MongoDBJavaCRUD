package MODEL;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Insertar {

    public static void insertaUno(String nombre, String especialidad, String email, String ciudad, String year, String nota, String calle, String dni, MongoCollection collection) {
        nombre = nombre.toLowerCase();
        especialidad = especialidad.toLowerCase();
        email = email.toLowerCase();
        ciudad = ciudad.toLowerCase();
        calle = calle.toLowerCase();
        dni = dni.toLowerCase();
        try {
            if (calle.isEmpty() & nota.isEmpty()) {
                Document document = new Document("nombre", nombre)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(year))
                        .append("especialidad", especialidad)
                        .append("direccion", new Document("ciudad", ciudad))
                        .append("email", email);

                collection.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);

            } else if (nota.isEmpty()) {
                Document document = new Document("nombre", nombre)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(year))
                        .append("especialidad", especialidad)
                        .append("direccion", new Document("ciudad", ciudad)
                                .append("calle", calle))
                        .append("email", email);

                collection.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);
            } else if (calle.isEmpty()) {
                Document document = new Document("nombre", nombre)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(year))
                        .append("especialidad", especialidad)
                        .append("direccion", new Document("ciudad", ciudad))
                        .append("email", email)
                        .append("notaMedia", Double.parseDouble(nota));

                collection.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);
            } else {
                Document document = new Document("nombre", nombre)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(year))
                        .append("especialidad", especialidad)
                        .append("direccion", new Document("ciudad", ciudad)
                                .append("calle", calle))
                        .append("email", email)
                        .append("notaMedia", Double.parseDouble(nota));

                collection.insertOne(document);
                Alertas.alertaInfo(Textos.ALUMNOINSERTADOK);
            }
        } catch (com.mongodb.MongoWriteException e) {
            Alertas.alertaError(Textos.REVISAYEARDNI);
        } catch (java.lang.NumberFormatException e) {
            Alertas.alertaError(Textos.REVISAYEARNOTA);
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
