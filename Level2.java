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
    private int money=0;
    private int zombiesSpawned=0;//0
    private int zombiesBossSpawned=0;
    private int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    private Player mainPlayer=new Player();
    private Counter counter=new Counter();
    private HealthBar healthBar=new HealthBar();
    private GreenfootImage jardin=new GreenfootImage("37004198-camino-a-pie-a-través-del-jardín-en-vista-aérea.jpg");
    private SillasJardin sillasjardin1=new SillasJardin();
    private SillasJardin sillasjardin2=new SillasJardin();
    private SillasJardin sillasjardin3=new SillasJardin();
    public void setAttributes(Player mainPlayer, Counter counter, HealthBar healthBar,int zombiesSpawned) {
        this.mainPlayer = mainPlayer;
        this.counter = counter;
        this.healthBar = healthBar;
        this.zombiesSpawned=zombiesSpawned;
    }
    public Level2(Player player)
    {    
        super(1000, 600, 1);
        mainPlayer=player;
        addObject(mainPlayer,getWidth()/3,getHeight()/3);
        addObject(counter,130,100);
        addObject(healthBar,mainPlayer.getX()-5,mainPlayer.getY()-50);
        sillasjardin1.setRotation(45);
        sillasjardin2.setRotation(70);
        sillasjardin3.setRotation(120);
        addObject(sillasjardin1,600,300);//150
        addObject(sillasjardin2,100,200);
        addObject(sillasjardin3,250,500);
        setPaintOrder(Player.class,HealthBar.class,Projectile.class,ZombieBoss.class, SillasJardin.class, Zombie.class, Projectile.class);
    }
    public Player getPlayer(){
        return mainPlayer;
    }
    public void act(){
        count++;
        spawnZombies();
        //cash(counter);
        
    }
    public void cash(Counter counter){
        money=counter.getScore()*5;
    }
    public void spawnZombies(){
        if(count%SPAWN_SPEED==0 && (counter.getScore()<=80&&zombiesSpawned<=81)){
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
            case 6: 
            addObject(new ZombieBoss(mainPlayer,counter),getWidth(),getHeight()/2);
            zombiesSpawned++;
                 break;
            }
        }
            if(counter.getScore()>=79){
                Level3 level3 = new Level3(mainPlayer);
                level3.setAttributes(mainPlayer, counter, healthBar,zombiesSpawned);
                Greenfoot.setWorld(level3);
            }
        }
    }
