package MODEL;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;
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

    public static List<String> findAll(TextArea ta) {

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
        return resultados;
    }
}
