import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class Menu extends World
{

    /**
     * Constructor for objects of class Universe.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        if (this.getClass().getName().equalsIgnoreCase("MenuScreen"))
        {
        }
        else
        {
            addObject(new BackButton(), 200, 500);
        }
    }
}
