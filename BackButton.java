import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name)  
 * @version (a version number or a date)
 */
public class BackButton extends Button
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act(this.getClass().getName());
    }   
    public void onButtonClicked(){
        Greenfoot.setWorld(new MenuScreen());
    }
}
