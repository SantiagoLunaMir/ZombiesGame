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
    private int zombiesSpawned=0;/////0
    private int zombiesBossSpawned=0;
    private int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    private Player mainPlayer=new Player();
    private Counter counter=new Counter();
    private HealthBar healthbar=new HealthBar();
    private Cama cama=new Cama();
    private Cama cama1=new Cama();
    private Cama cama2=new Cama();
    private Cama cama3=new Cama();
    public Level1()
    {    
        super(1000, 600, 1);
        //mainPlayer=new Player();
        counter.setScore(0);/////0
        addObject(mainPlayer,getWidth()/2,getHeight()/2);
        addObject(counter,130,100);
        addObject(healthbar,mainPlayer.getX()-5,mainPlayer.getY()-50);
        cama.setRotation(45);
        cama2.setRotation(70);
        cama3.setRotation(120);
        addObject(cama,700,500);//150
        addObject(cama1,50,200);
        addObject(cama2,750,550);
        addObject(cama3,350,250);
        setPaintOrder(Player.class,HealthBar.class,Projectile.class, Cama.class, Zombie.class, Projectile.class);
        //Counter.setScore(0);
    }
    public Counter getCounter(){
        return counter;
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
        if(count%SPAWN_SPEED==0 && (counter.getScore()<=60&&zombiesSpawned<=61)){
            randomSpawn=Greenfoot.getRandomNumber(cantZ);
            switch(randomSpawn){//getHeight(), altura, getWidth(), ancho
             case 0: 
                 addObject(new Zombie(mainPlayer,counter),0,0);
                 zombiesSpawned++;
                 break;
             case 1: 
                 addObject(new Zombie(mainPlayer,counter),0,getWidth());
                 zombiesSpawned++;
                 break;   
             case 2: 
                 addObject(new Zombie(mainPlayer,counter),getHeight(),0);
                 zombiesSpawned++;
                 break;
             case 3: 
                 addObject(new Zombie(mainPlayer,counter),getHeight(),getWidth());
                 zombiesSpawned++;
                 break;
             case 4: 
                 addObject(new Zombie(mainPlayer,counter),getWidth()/2,getHeight());
                 zombiesSpawned++;
                 break;
             case 5: 
                 addObject(new Zombie(mainPlayer,counter),getWidth(),getHeight()/2);
                 zombiesSpawned++;
                 break;
            }
            if(counter.getScore()>=59||zombiesSpawned>=59){
                Level2 level2 = new Level2(mainPlayer);
                level2.setAttributes(mainPlayer, counter, healthbar,zombiesSpawned);
                Greenfoot.setWorld(level2);
            }
        }
    }
}
