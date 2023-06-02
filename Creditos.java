import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends Menu
{

    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos(int finalScore)
    {    
        ScoreBoard scoreBoard = new ScoreBoard(1,1,finalScore);
        scoreBoard.leaderboard(finalScore);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    public void act(){
        printCredits();
    }
    public void printCredits() {
    }
}
