import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends MyWorld
{
    int count=0;//que tan seguido agregar
    int spawnSpeed=50;//rapido si es mas bajo el valor
    int cantZ=8;//cantidad de zombies
    int countZombies=0;//contador
    int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    public Player mainPlayer=new Player();
    Counter counter=new Counter();
    HealthBar healthbar=new HealthBar();
    /**
     * Constructor for objects of class Tutorial.
     * 
     */
    public Tutorial()
    {
        addObject(mainPlayer,getWidth()/2,getHeight()/2);
        addObject(counter,130,100);
        addObject(healthbar,mainPlayer.getX()-5,mainPlayer.getY()-50);
    }
}
