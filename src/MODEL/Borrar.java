
package MODEL;


import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;



public class Borrar {
    
    
    
    public static void borrarUno(String k, String v, MongoCollection col){
        
        if(col.deleteOne(eq(k, v)).getDeletedCount()>=1){
            Alertas.alertaInfo(Textos.ALUMNOBORRADOOK);
        } else {
            Alertas.alertaError(Textos.ALUMNOBORRADONOK);
        }
        
        
    }
}
