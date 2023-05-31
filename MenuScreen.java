import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends Menu
{

    /**
     * Constructor for objects of class MenuScreen.
     * 
     */
    public MenuScreen()
    {    
        super();
        addObject(new Requiem(), 200, 200);
        addObject(new StartButton(), 200, 500);
        addObject(new HowToPlayButton(), 500, 500);
        addObject(new ScoreboardButton(),  800, 500);
    }
}
