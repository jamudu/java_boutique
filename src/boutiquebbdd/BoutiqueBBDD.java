//

package boutiquebbdd;

import dao.PrendaJDBC;
import vista.Menu;

/**
 *
 * @author usu21
 */
public class BoutiqueBBDD {
    
    public static PrendaJDBC prendaJDBC;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu mp= new Menu();
        mp.setLocationRelativeTo(mp);
        mp.setVisible(true);
    }
    
}
