import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(){
        /*
        setImage(new GreenfootImage(10,2));
        getImage().setColor(Color.GRAY);
        getImage().fillRect(0,0,10,2);*/
    }
    public void act()
    {
        move(10);
        // Add your action code here.
    }
}
