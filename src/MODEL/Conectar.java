package MODEL;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Conectar {

    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection colleccion;
    String uri = "mongodb+srv://UsuarioInstituto:PassInsti.19@cluster0-wxmzm.mongodb.net/test?retryWrites=true&w=majority";
    String database = "instituto";
    String collection = "estudiantes";

    public Conectar() {

        try {
            mongoClient = MongoClients.create(uri);
            mongoDatabase = mongoClient.getDatabase(database);
            setCollection(collection);
        } catch (java.lang.IllegalArgumentException e) {
            Alertas.alertaError(Textos.ERRORSERVIDOR);
        } catch (com.mongodb.MongoSecurityException e) {
            Alertas.alertaError(Textos.ERRORAUTH);
        } catch (com.mongodb.MongoCommandException e) {
            Alertas.alertaError(Textos.ERRORAUTH);
        } catch (com.mongodb.MongoSocketOpenException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean setCollection(String c) {
        colleccion = mongoDatabase.getCollection(c);
        if (colleccion.countDocuments() == 0) {
            return false;
        }
        return true;
    }

    public MongoCollection getCollection() {
        return colleccion;
    }

    public void listaColecciones() {
        MongoIterable<String> it = mongoDatabase.listCollectionNames();
        for (String s : it) {
            System.out.println(s);
        }
    }

}
