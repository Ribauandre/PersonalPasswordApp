
package personalpasswordapp;

import java.io.IOException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author andreribau
 */
public class PersonalPasswordApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Validation.checkPop();
        Registration app = new Registration();

        if(Validation.isPop = false)
            
            app.setDefaultCloseOperation(EXIT_ON_CLOSE);
            app.setSize(250, 150);
            app.setVisible(true);
    }
    
    
}
