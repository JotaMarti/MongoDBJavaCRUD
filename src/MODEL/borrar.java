
package MODEL;


import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;



public class borrar {
    
    
    
    public static void borrarUno(String k, String v, MongoCollection col){
        
        if(col.deleteOne(eq(k, v)).getDeletedCount()>=1){
            alertas.alertaInfo(textos.getAlumnoBorradoOk());
        } else {
            alertas.alertaError(textos.getAlumnoBorradoNok());
        }
        
        
    }
}
