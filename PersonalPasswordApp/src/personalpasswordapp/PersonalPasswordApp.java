
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
        Registration app = new Registration();
        Login app2 = new Login();
        File f = new File("register.text");
        
        if(f.length()==0)
        {
            app.setSize(400, 150);
            app.setVisible(true);
            app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        else
        {
            app2.setSize(400,150);
            app2.setVisible(true);
            app2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    
    
}
