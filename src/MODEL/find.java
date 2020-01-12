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

public class find {

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

    public static void findOneTabla(TableView<estudiante> e, ObservableList<estudiante> ol, TableColumn[] tc, String k, String v) {
        estudiante[] array;
        conectar myMongo = new conectar();
        int valueInt;
        Double valueDouble;
        MongoCollection col = myMongo.getCollection();

        List<String> resultados = new ArrayList<>();
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                resultados.add(document.toJson());
            }
        };
        
        if(k.equals("calle")){
            col.find(eq("direccion.calle", v)).forEach(printBlock);
        } else if (k.equals("ciudad")){
            col.find(eq("direccion.ciudad", v)).forEach(printBlock);
        } else if(k.equals("año")) {
            valueInt = Integer.parseInt(v);
            col.find(eq(k, valueInt)).forEach(printBlock);
        } else if(k.equals("notaMedia")) {
            valueDouble = Double.parseDouble(v);
            col.find(eq(k, valueDouble)).forEach(printBlock);
        } else {
            col.find(eq(k, v)).forEach(printBlock);
        }
        
        

        extract eResultados = new extract(resultados);
        array = eResultados.getArray();

        pintar.refrescaPantallaView(e, array, ol, tc);
    }

    public static void findAll(TextArea ta) {

        conectar myMongo = new conectar();

        MongoCollection col = myMongo.getCollection();

        List<String> resultados = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        try {
            while (cursor.hasNext()) {
                resultados.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        pintar.refrescaPantalla(ta, resultados);
    }

    public static void findAllTable(TableView<estudiante> tableView, ObservableList<estudiante> ObservableList, TableColumn[] tableColumn, TextArea textArea) {
        estudiante[] array;
        conectar myMongo = new conectar();

        MongoCollection col = myMongo.getCollection();

        List<String> resultados = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        try {
            while (cursor.hasNext()) {
                resultados.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        extract eResultados = new extract(resultados);
        array = eResultados.getArray();

        pintar.refrescaPantallaView(tableView, array, ObservableList, tableColumn);
        pintar.refrescaPantalla(textArea, resultados);

    }
}
