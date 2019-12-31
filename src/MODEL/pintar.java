
package MODEL;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;


public class pintar {
    
    
    public static void refrescaPantalla(TextArea ta, List<String> resultados){
        
        ta.setText("");
        
        for (int i = 0; i < resultados.size(); i++) {
            ta.appendText(resultados.get(i) + "\n");
        }
    }
    
    
    public static void pintarMensaje(TextArea ta, String s){
        ta.setText(s);
    }
    
    public static void refrescaPantallaView(TableView<estudiante> e, estudiante[] array, ObservableList<estudiante> ol, TableColumn[] tc){
        
        e.getColumns().clear();
        
        for (int i = 0; i < array.length; i++) {
            ol.add(array[i]);
        }
        
        e.getColumns().clear();
        e.setItems(ol);
        e.getColumns().addAll(tc[0], tc[1], tc[2], tc[3], tc[4], tc[5], tc[6], tc[7]);
          
    }
    
    
    
}
