import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.util.ArrayList;

class Controller implements KeyListener
{
    Model model;
    View view;
    private ArrayList<Sprite> sprites;
    private int points;

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
            model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_DOWN);
        }

        points = model.getPoints();
        view.setNumberOfPoints(points);
        view.setBackground(Color.BLACK);
        view.repaint();
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

