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

    public static void findOneTabla(TableView<Estudiante> e, ObservableList<Estudiante> ol, TableColumn[] tc, String k, String v) {
        Estudiante[] array;
        Conectar myMongo = new Conectar();
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
        
        

        Extract eResultados = new Extract(resultados);
        array = eResultados.getArray();

        Pintar.refrescaPantallaView(e, array, ol, tc);
    }

    public static void findAll(TextArea ta) {

        Conectar myMongo = new Conectar();

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

        Pintar.refrescaPantalla(ta, resultados);
    }

    public static void findAllTable(TableView<Estudiante> tableView, ObservableList<Estudiante> ObservableList, TableColumn[] tableColumn, TextArea textArea) {
        Estudiante[] array;
        Conectar myMongo = new Conectar();

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

        Extract eResultados = new Extract(resultados);
        array = eResultados.getArray();

        Pintar.refrescaPantallaView(tableView, array, ObservableList, tableColumn);
        Pintar.refrescaPantalla(textArea, resultados);

    }
}
