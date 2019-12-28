package MODEL;

import com.mongodb.client.MongoCollection;
import javafx.scene.control.Alert;
import org.bson.Document;

public class insertar {

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

            } else if (nota.isEmpty()) {
                Document document = new Document("nombre", nom)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(a))
                        .append("especialidad", esp)
                        .append("direccion", new Document("ciudad", ciudad)
                                .append("calle", calle))
                        .append("email", email);

                col.insertOne(document);

            } else if (calle.isEmpty()) {
                Document document = new Document("nombre", nom)
                        .append("dni", dni)
                        .append("año", Integer.parseInt(a))
                        .append("especialidad", esp)
                        .append("direccion", new Document("ciudad", ciudad))
                        .append("email", email)
                        .append("notaMedia", Double.parseDouble(nota));

                col.insertOne(document);
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
            }
        } catch (com.mongodb.MongoWriteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ya existe un alumno con este DNI!!\n");
            alert.showAndWait();
            System.out.println(e);
        } catch (java.lang.NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Por favor, inserta un numero en el campo año y/o nota media\n");
            alert.showAndWait();
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }

    }

}
