import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

class Model {
    private Sprite sprite;
    private ArrayList<Sprite> sprites;
    private Plane plane;
    private static int points = 0;

    Model() throws IOException {
        initialize();
    }

    public void addToScreen(int x, int y) {

    }

    public void update(Graphics g) {
        for (int i = 0; i < sprites.size(); ++i) {
            sprites.get(i).updateImage(g);
        }
    }

    public void updateScene(int width, int height, int direction) {
        plane.drive(direction);
        for (int i = 0; i < sprites.size(); ++i) {
            if (sprites.get(i) instanceof Star) {
                ((Star) sprites.get(i)).drive();

                if (sprites.get(i).overlaps(plane)) {
                    sprites.remove(i);
                    points++;
                }
            }
        }
    }

    public ArrayList<Sprite> getSpriteArray() {
        return sprites;
    }

    public void initialize() {
        sprites = new ArrayList<>();
        sprite = new Moon();
        sprites.add(sprite);
        plane = new Plane();
        sprites.add(plane);
        for (int i = 0; i < 20; ++i) {
            sprite = new Star();
            sprites.add(sprite);
        }
        points = 0;
    }

    public int getPoints() {
        return points;
    }

}
