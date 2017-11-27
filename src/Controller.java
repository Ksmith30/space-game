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
    SpriteMover spriteMover;
    Thread th;
    private ArrayList<Thread> threads;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        threads = new ArrayList<>();
    }

    public void update(Graphics g) {
        model.update(g);
    }


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_R:
                spriteMover = new SpriteMover(model, view);
                th = new Thread(spriteMover);
                threads.add(th);
                th.start();
                view.setPause(false);
                break;
            case KeyEvent.VK_RIGHT:
                model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_LEFT);
                break;
            case KeyEvent.VK_UP:
                model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_UP);
                break;
            case KeyEvent.VK_DOWN:
                model.updateScene(view.getWidth(), view.getHeight(), KeyEvent.VK_DOWN);
                break;
            case KeyEvent.VK_P:
                for (int i = 0; i < threads.size() ; ++i) {
                    threads.get(i).interrupt();
                }
                view.setPause(true);
                break;
            case KeyEvent.VK_SPACE:
                view.setPause(false);
                view.setStart(false);
                model.initialize(view.getWidth(), view.getHeight());
                spriteMover = new SpriteMover(model, view);
                th = new Thread(spriteMover);
                threads.add(th);
                th.start();
                break;
        }

        points = model.getPoints();
        if (points >= 20) {
            view.assertWin();
        }
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

