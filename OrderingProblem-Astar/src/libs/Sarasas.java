package libs;

import java.util.ArrayList;

/**
 *
 * @author Justinas
 */
public class Sarasas<Busena> extends ArrayList<Busena> { 
    
    public boolean busenaDoesNotExists( Busena b ) {
        
        boolean returningValue = true;
        
        for (Busena busena : this) {
            if( busena.equals(b) ) {
                returningValue = false;
                break;
            }
        }
        
        return returningValue;
    }
    
}
