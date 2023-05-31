import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage; 
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private final int SPAWN_SPEED=50;
    
    private int count=0;
    private int cantZ=8;
    private int maxZombiesInWorld=32;
    private int zombiesSpawned=0;
    private int zombiesBossSpawned=0;
    private int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    private Player mainPlayer=new Player();
    private Counter counter=new Counter();
    private HealthBar healthBar=new HealthBar();
    private WeaponButton weaponbutton=new WeaponButton(counter);
    public void setAttributes(Player mainPlayer, Counter counter, HealthBar healthBar) {
        this.mainPlayer = mainPlayer;
        this.counter.setMoney(counter.getMoney());
        this.counter = counter;
        this.healthBar = healthBar;
    }
    public Player getMainPlayer() {
        return mainPlayer;
    }

    public Counter getCounter() {
        return counter;
    }

    public HealthBar getHealthBar() {
        return healthBar;
    }
    public Level2()
    {    
        super(1000, 600, 1);
        mainPlayer=new Player(weaponbutton);
        addObject(mainPlayer,getWidth()/2,getHeight()/2);
        addObject(counter,130,100);
        addObject(healthBar,mainPlayer.getX()-5,mainPlayer.getY()-50);
    }
    public Player getPlayer(){
        return mainPlayer;
    }
    public void act(){
        count++;
        spawnZombies();
        
    }
    public void spawnZombies(){
        if(count%SPAWN_SPEED==0 && zombiesSpawned<30){
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
            if(zombiesSpawned>=25){
                addObject(new ZombieBoss(mainPlayer,counter),600,800);
                zombiesSpawned++;
                addObject(new WeaponButton(counter),100,500);
            }
            /*if(zombiesSpawned==50){
                Greenfoot.setWorld(new Level3());
            }*/
        }
        
    }
    
}
