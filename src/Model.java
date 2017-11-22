import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Model
{
    private Sprite sprite;
    private ArrayList<Sprite> sprites;

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

    public ArrayList<Sprite> getSpriteArray() {
        return sprites;
    }

    public void initialize() {
        sprites = new ArrayList<>();
        sprite = new Moon();
        sprites.add(sprite);
        sprite = new Plane();
        sprites.add(sprite);
        for (int i = 0; i < 50; ++i) {
            sprite = new Star();
            sprites.add(sprite);
        }
    }

}
