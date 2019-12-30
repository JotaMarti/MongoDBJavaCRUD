
package MODEL;

import java.util.List;
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
    
    public static void refrescaPantallaView(TextArea ta, List<String> resultados){
        
        
        
        
        ta.setText("");
        
        for (int i = 0; i < resultados.size(); i++) {
            ta.appendText(resultados.get(i) + "\n");
        }
    }
    
    
    
}
