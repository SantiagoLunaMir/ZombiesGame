import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Menu
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int finalScore)
    {
        super();
        ScoreBoard scoreBoard = new ScoreBoard(1,1,finalScore);
        scoreBoard.leaderboard(finalScore);
    }
}
