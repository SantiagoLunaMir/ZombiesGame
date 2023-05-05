import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count=0;//que tan seguido agregar
    int spawnSpeed=50;//rapido si es mas bajo el valor
    int cantZ=8;//cantidad de zombies
    int countZombies=0;//contador
    int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    public Player mainPlayer=new Player();
    Counter counter=new Counter();
    HealthBar healthbar=new HealthBar();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        /*getBackground().setColor(Color.BLACK);
        getBackground().fill();*/
        addObject(mainPlayer,getWidth()/2,getHeight()/2);
        addObject(counter,130,100);
        addObject(healthbar,mainPlayer.getX()-5,mainPlayer.getY()-50);
    }
    public Player getPlayer(){
        return mainPlayer;
    }
    public void act(){
        count++;
        spawnZombies();
    }
    public void spawnZombies(){
        if(count%spawnSpeed==0){
            randomSpawn=Greenfoot.getRandomNumber(cantZ);
            switch(randomSpawn){
             case 0: addObject(new Zombie(mainPlayer,counter),0,0);break;
             case 1: addObject(new Zombie(mainPlayer,counter),0,800);break;   
             case 2: addObject(new Zombie(mainPlayer,counter),600,0);break;
             case 3: addObject(new Zombie(mainPlayer,counter),600,800);break;
             case 4: addObject(new Zombie(mainPlayer,counter),getWidth(),getHeight());break;
             case 5: addObject(new Zombie(mainPlayer,counter),600,getHeight()/2);break;
             case 6: addObject(new Zombie(mainPlayer,counter),getWidth()/2,800);break;
             case 7: addObject(new Zombie(mainPlayer,counter),10,10);break;
            }
        }
    }
    
}
