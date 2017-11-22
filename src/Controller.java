
import javax.security.auth.kerberos.KerberosTicket;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.util.ArrayList;

class Controller implements KeyListener
{
    Model model;
    View view;
    private ArrayList<Sprite> sprites;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
    }

    public void update(Graphics g) {
        model.update(g);
    }


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        // Start Key
        if (e.getKeyCode() == KeyEvent.VK_S) {
            model.initialize();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        }
    }
    public void keyReleased(KeyEvent e) {  }


    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}

