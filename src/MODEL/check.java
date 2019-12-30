
package MODEL;


public class check {
    
    private static String dniR = "[0-9]{8}[a-z]";
    
    public static boolean checkDni(String dni){
       
        return dni.matches(dniR);
        
    }
}
