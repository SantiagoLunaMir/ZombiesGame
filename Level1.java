import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage; 
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private final int SPAWN_SPEED=50;
    
    private int count=0;
    private int cantZ=8;
    private int maxZombiesInWorld=32;
    private int zombiesSpawned=0;//0
    private int zombiesBossSpawned=0;
    private int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    private Player mainPlayer/*=new Player()*/;
    private Counter counter=new Counter();
    private HealthBar healthbar=new HealthBar();
    GreenfootImage jardin=new GreenfootImage("37004198-camino-a-pie-a-través-del-jardín-en-vista-aérea.jpg");
    public Level1()
    {    
        super(1000, 600, 1);
        mainPlayer=new Player();
        addObject(mainPlayer,getWidth()/2,getHeight()/2);
        addObject(counter,130,100);
        addObject(healthbar,mainPlayer.getX()-5,mainPlayer.getY()-50);
    }
    public Player getPlayer(){
        return mainPlayer;
    }
    public void act(){
        mainPlayer = getPlayer();
        count++;
        spawnZombies();
        
    }
    public void spawnZombies(){
        if(count%SPAWN_SPEED==0 && zombiesSpawned<=33){
            randomSpawn=Greenfoot.getRandomNumber(cantZ);
            switch(randomSpawn){
             case 0: 
                 addObject(new Zombie(mainPlayer,counter),0,0);
                 zombiesSpawned++;
                 break;
             case 1: 
                 addObject(new Zombie(mainPlayer,counter),0,800);
                 zombiesSpawned++;
                 break;   
             case 2: 
                 addObject(new Zombie(mainPlayer,counter),600,0);
                 zombiesSpawned++;
                 break;
             case 3: 
                 addObject(new Zombie(mainPlayer,counter),600,800);
                 zombiesSpawned++;
                 break;
             case 4: 
                 addObject(new Zombie(mainPlayer,counter),getWidth(),getHeight());
                 zombiesSpawned++;
                 break;
             case 5: 
                 addObject(new Zombie(mainPlayer,counter),600,getHeight()/2);
                 zombiesSpawned++;
                 break;
             case 6: 
                 addObject(new Zombie(mainPlayer,counter),getWidth()/2,800);
                 zombiesSpawned++;
                 break;
             case 7: 
                 addObject(new Zombie(mainPlayer,counter),10,10);
                 zombiesSpawned++;
                 break;
            }
            if(zombiesSpawned>=32){
                addObject(new ZombieBoss(mainPlayer,counter),600,800);
                zombiesSpawned++;
            }
            if(zombiesSpawned==33){
                Level2 level2 = new Level2(mainPlayer);
                level2.setAttributes(mainPlayer, counter, healthbar,zombiesSpawned);
                Greenfoot.setWorld(level2);
            }
        }
    }
}
