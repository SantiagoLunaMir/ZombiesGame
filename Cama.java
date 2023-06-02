import greenfoot.*;

public class Cama extends Actor {
    private int width = 80;
    private int height = 90;

    public Cama() {
        GreenfootImage image = new GreenfootImage("cama.png");
        image.scale(width, height);
        setImage(image);
    }

    public void act() {
    }
}
