import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreboardButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreboardButton extends Button
{
    /**
     * Act - do whatever the ScoreboardButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act(this.getClass().getName());
    }
    
    public void onButtonClicked(){
        Greenfoot.setWorld(new ScoreboardScreen(0));
    }
}
