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
    private Music music;
    public MenuScreen()
    {    
        super();
        //prepare();
        addObject(new Requiem(), 200, 200);
        addObject(new StartButton(), 200, 500);
        addObject(new HowToPlayButton(), 500, 500);
        addObject(new ScoreboardButton(),  800, 500);
        music = new Music();
        prepare();
    }
    
    public void prepare(){
        addObject(music,0,0);
    }
    
    public Music getMusic(){
        return music;
    }
}
