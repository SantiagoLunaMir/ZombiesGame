import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreboardScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreboardScreen extends Menu
{
    public ScoreboardScreen(int finalScore)
    {
        addObject(new ScoreBoard(600, 400,finalScore), 500, 250);
    }
    
}
