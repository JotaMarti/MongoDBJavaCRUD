package MODEL;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import org.bson.Document;

public class Find {

    public static String findOneTabla(TableView<Estudiante> TableView, ObservableList<Estudiante> ObservableList, String key, String value, String comparacion, TextArea textArea) {
        // Inicializo variables que voy a necesitar mas tarde
        Conectar myMongo = new Conectar();
        MongoCollection collection = myMongo.getCollection();
        int valueInt;
        Double valueDouble;
        Document myDoc = null;
        List<String> resultadosBrutos = new ArrayList<>();
        boolean datosCorrectos = true;
        String resultadoBusqueda = "";

        // null check
        if (comparacion == null) {
            comparacion = "";
        }
        if (key == null) {
            key = "";
        }
        value = value.toLowerCase();

        /*
        Para busquedas simples uso col.find(eq(key, value)).forEach(printBlock); pero esto no me sirve para la calle y la ciudad que estan dentro de direccion,
        ni tampoco para busquedas donde intervengan int o floats. Despues agregue unos switch para habilitar operadores de comparación en año y en notaMedia.
         */
        try {
            if (key.equals("calle")) {
                myDoc = (Document) collection.find(eq("direccion.calle", value)).first();
            } else if (key.equals("ciudad")) {
                myDoc = (Document) collection.find(eq("direccion.ciudad", value)).first();
            } else if (key.equals("año")) {
                valueInt = Integer.parseInt(value);
                switch (comparacion) {
                    case "Igual":
                        myDoc = (Document) collection.find(eq(key, valueInt)).first();
                        break;
                    case "Mayor que":
                        myDoc = (Document) collection.find(gt(key, valueInt)).first();
                        break;
                    case "Mayor o igual que":
                        myDoc = (Document) collection.find(gte(key, valueInt)).first();
                        break;
                    case "Menor que":
                        myDoc = (Document) collection.find(lt(key, valueInt)).first();
                        break;
                    case "Menor o igual que":
                        myDoc = (Document) collection.find(lte(key, valueInt)).first();
                        break;
                    case "Distinto":
                        myDoc = (Document) collection.find(ne(key, valueInt)).first();
                        break;
                    default:
                        myDoc = (Document) collection.find(eq(key, valueInt)).first();
                        break;
                }
            } else if (key.equals("notaMedia")) {
                valueDouble = Double.parseDouble(value);
                switch (comparacion) {
                    case "Igual":
                        myDoc = (Document) collection.find(eq(key, valueDouble)).first();
                        break;
                    case "Mayor que":
                        myDoc = (Document) collection.find(gt(key, valueDouble)).first();
                        break;
                    case "Mayor o igual que":
                        myDoc = (Document) collection.find(gte(key, valueDouble)).first();
                        break;
                    case "Menor que":
                        myDoc = (Document) collection.find(lt(key, valueDouble)).first();
                        break;
                    case "Menor o igual que":
                        myDoc = (Document) collection.find(lte(key, valueDouble)).first();
                        break;
                    case "Distinto":
                        myDoc = (Document) collection.find(ne(key, valueDouble)).first();
                        break;
                    default:
                        myDoc = (Document) collection.find(eq(key, valueDouble)).first();
                        break;
                }
            } else {
                myDoc = (Document) collection.find(eq(key, value)).first();
            }
        } catch (NumberFormatException e) {
            datosCorrectos = false;
        }

        if (myDoc == null & datosCorrectos == true) {
            resultadoBusqueda = Textos.MAINERRORNOENCONTRADO;
            return resultadoBusqueda;//Alertas.alertaError(Textos.MAINERRORNOENCONTRADO);
        } else if (datosCorrectos == false) {
            resultadoBusqueda = Textos.REVISAYEARNOTA;
            return resultadoBusqueda;
            //Alertas.alertaError(Textos.REVISAYEARNOTA);
        } else {
            resultadosBrutos.add(myDoc.toJson());
            Extract eResultados = new Extract(resultadosBrutos);

            Pintar.refrescaPantallaView(TableView, eResultados.getObservableList());
            Pintar.refrescaPantalla(textArea, resultadosBrutos);
            resultadoBusqueda = Textos.TODOOK;
            return resultadoBusqueda;
        }
    }

    public static void findAllTable(TableView<Estudiante> tableView, ObservableList<Estudiante> ObservableList, TextArea textArea) {

        Conectar myMongo = new Conectar();
        MongoCollection collection = myMongo.getCollection();

        // Simplemente creamos un cursor que recorre toda la coleccion
        List<String> resultados = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                resultados.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        Extract extractedResultados = new Extract(resultados);

        Pintar.refrescaPantallaView(tableView, extractedResultados.getObservableList());
        Pintar.refrescaPantalla(textArea, resultados);

    }

}
