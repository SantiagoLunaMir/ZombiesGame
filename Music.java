import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor
{
    private GreenfootSound music;
    
    public Music(){
        music = new GreenfootSound("Menu.mp3");
    }
    
    public void act()
    {
        if(!music.isPlaying()){
        music.play();
        }// Add your action code here.
    }
    public void stopPlaying(){
        music.stop();
    }
}
