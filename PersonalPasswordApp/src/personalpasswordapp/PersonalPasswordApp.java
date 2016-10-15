
package personalpasswordapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        Login app2 = new Login();

        if(Validation.isPop = false)
        {
            app.setSize(250, 150);
            app.setVisible(true);
            app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        else
        {
            app2.setSize(250,150);
            app2.setVisible(true);
            app2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    
    
}
