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
    public Creditos()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
    }
    public void act(){
        printCredits();
    }
    public void printCredits(){
        getBackground().drawImage(new GreenfootImage("UN JUEGO REALIZADO POR:\n Castillo Corpus Francisco Alejandro\n    y\nLuna Mireles Luis Santiago", 64, null, null), 40, 40);
    }
}
