
package personalpasswordapp;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author andreribau
 */
public class PersonalPasswordApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registration app = new Registration();
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setSize(250, 150);
        app.setVisible(true);
    }
    
}
