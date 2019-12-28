/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class conectar {

    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection colleccion;

    public conectar(String bd) {
        try {
            mongoClient = MongoClients.create("mongodb+srv://UsuarioInstituto:PassInsti.19@cluster0-wxmzm.mongodb.net/test?retryWrites=true&w=majority");
            mongoDatabase = mongoClient.getDatabase(bd);
            System.out.println("Conexión correcta");
        } catch (java.lang.IllegalArgumentException e) {
            System.out.println("Datos del servidor erroneos");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public boolean setCollection(String c){
        colleccion = mongoDatabase.getCollection(c);
        if(colleccion.countDocuments()==0){
            return false;
        }
        return true;
    }
    
    public MongoCollection getCollection(){
        return colleccion;
    }
    
    public void listaColecciones(){
        MongoIterable<String> it = mongoDatabase.listCollectionNames();
        for(String s: it){
            System.out.println(s);
        }
    }

}
