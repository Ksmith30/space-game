import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
    private String jpgName;
    private int locationX;
    private int locationY;
    private Image image;
    private int width;
    private int height;

    public Sprite(String jpgName, int width, int height) {
        setImage(jpgName);
        this.width = width;
        this.height = height;
        locationX = 0;
        locationY = 0;
    }

    public int getX() {	return locationX; }
    public int getY() {	return locationY; }
    public void setX(int x) { locationX = x; }
    public void setY(int y) { locationY = y; }

    public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
    }
    public Image getImage() { return image; }

    public void updateImage(Graphics g) {
        // Move the sprite
        g.drawImage(getImage(), getX(), getY(), width, height, null);
    }

    public void updateState(int width, int height) {

    }

    public boolean overlaps(Sprite s) {
        return (locationX < s.getX() + 20) && (locationX + 20 > s.getX()) && (locationY < s.getY() + 20)
                && (locationY + 20 > s.getY());
    }

}