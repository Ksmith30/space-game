public class Moon extends Sprite {

    private static int MOON_WIDTH = 50;
    private static int MOON_HEIGHT = 50;

    public Moon() {
        super("full-moon.png", MOON_WIDTH, MOON_HEIGHT);
        setX(30);
        setY(30);
    }
}
