import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SillasJardin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillasJardin extends Actor
{
    private int width = 150;
    private int height =160;

    public SillasJardin() {
        GreenfootImage image = new GreenfootImage("sillasjardin.png");
        image.scale(width, height);
        setImage(image);
    }

    public void act()
    {
        // Add your action code here.
    }
}
