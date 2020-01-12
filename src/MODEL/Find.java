package MODEL;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import org.bson.Document;

public class Find {

    public static List<String> findOne(MongoCollection col, String k, String v) {
        List<String> resultados = new ArrayList<>();
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                resultados.add(document.toJson());
            }
        };

        col.find(eq(k, v)).forEach(printBlock);

        return resultados;
    }

    public static void findOneTabla(TableView<Estudiante> TableView, ObservableList<Estudiante> ObservableList, TableColumn[] TableColumn, String key, String value, String comparacion, TextArea textArea) {
        // Inicializo variables que voy a necesitar mas tarde
        Estudiante[] estudianteArray;
        Conectar myMongo = new Conectar();
        int valueInt;
        Double valueDouble;
        MongoCollection col = myMongo.getCollection();

        List<String> resultadosBrutos = new ArrayList<>();
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                resultadosBrutos.add(document.toJson());
            }
        };
        // null check
        if (comparacion == null) {
            comparacion = "";
        }

        /*
        Para busquedas simples uso col.find(eq(key, value)).forEach(printBlock); pero esto no me sirve para la calle y la ciudad que estan dentro de direccion,
        ni tampoco para busquedas donde intervengan int o floats. Despues agregue unos switch para habilitar operadores de comparación en año y en notaMedia.
         */
        if (key.equals("calle")) {
            col.find(eq("direccion.calle", value)).forEach(printBlock);
        } else if (key.equals("ciudad")) {
            col.find(eq("direccion.ciudad", value)).forEach(printBlock);
        } else if (key.equals("año")) {
            valueInt = Integer.parseInt(value);
            switch (comparacion) {
                case "Igual":
                    col.find(eq(key, valueInt)).forEach(printBlock);
                    break;
                case "Mayor que":
                    col.find(gt(key, valueInt)).forEach(printBlock);
                    break;
                case "Mayor o igual que":
                    col.find(gte(key, valueInt)).forEach(printBlock);
                    break;
                case "Menor que":
                    col.find(lt(key, valueInt)).forEach(printBlock);
                    break;
                case "Menor o igual que":
                    col.find(lte(key, valueInt)).forEach(printBlock);
                    break;
                case "Distinto":
                    col.find(ne(key, valueInt)).forEach(printBlock);
                    break;
                default:
                    col.find(eq(key, valueInt)).forEach(printBlock);
                    break;
            }

        } else if (key.equals("notaMedia")) {
            valueDouble = Double.parseDouble(value);
            switch (comparacion) {
                case "Igual":
                    col.find(eq(key, valueDouble)).forEach(printBlock);
                    break;
                case "Mayor que":
                    col.find(gt(key, valueDouble)).forEach(printBlock);
                    break;
                case "Mayor o igual que":
                    col.find(gte(key, valueDouble)).forEach(printBlock);
                    break;
                case "Menor que":
                    col.find(lt(key, valueDouble)).forEach(printBlock);
                    break;
                case "Menor o igual que":
                    col.find(lte(key, valueDouble)).forEach(printBlock);
                    break;
                case "Distinto":
                    col.find(ne(key, valueDouble)).forEach(printBlock);
                    break;
                default:
                    col.find(eq(key, valueDouble)).forEach(printBlock);
                    break;
            }

        } else {
            col.find(eq(key, value)).forEach(printBlock);
        }

        Extract resultados = new Extract(resultadosBrutos);
        estudianteArray = resultados.getArray();

        Pintar.refrescaPantallaView(TableView, estudianteArray, ObservableList, TableColumn);
        Pintar.refrescaPantalla(textArea, resultadosBrutos);
    }

    public static void findAll(TextArea ta) {

        Conectar myMongo = new Conectar();

        MongoCollection col = myMongo.getCollection();
        // Simplemente creamos un cursor que recorre toda la coleccion
        List<String> resultados = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        try {
            while (cursor.hasNext()) {
                resultados.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        Pintar.refrescaPantalla(ta, resultados);
    }

    public static void findAllTable(TableView<Estudiante> tableView, ObservableList<Estudiante> ObservableList, TableColumn[] tableColumn, TextArea textArea) {
        Estudiante[] array;
        Conectar myMongo = new Conectar();

        MongoCollection col = myMongo.getCollection();
        // Simplemente creamos un cursor que recorre toda la coleccion
        List<String> resultados = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        try {
            while (cursor.hasNext()) {
                resultados.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        Extract eResultados = new Extract(resultados);
        array = eResultados.getArray();

        Pintar.refrescaPantallaView(tableView, array, ObservableList, tableColumn);
        Pintar.refrescaPantalla(textArea, resultados);

    }

}
