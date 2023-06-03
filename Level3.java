import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage; 
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private final int SPAWN_SPEED=50;
    private int count=0;
    private int cantZ=8;
    private int money=0;
    private int finalScore=0;
    private int zombiesSpawned=0;//0
    private int zombiesBossSpawned=0;
    private int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    private Player mainPlayer=new Player();
    private Counter counter=new Counter();
    private HealthBar healthBar=new HealthBar();
    private Coche1 coche11=new Coche1();
    private Coche2 coche21=new Coche2();
    private GreenfootImage jardin=new GreenfootImage("37004198-camino-a-pie-a-través-del-jardín-en-vista-aérea.jpg");
    public void setAttributes(Player mainPlayer, Counter counter, HealthBar healthBar,int zombiesSpawned) {
        this.mainPlayer = mainPlayer;
        this.counter = counter;
        this.healthBar = healthBar;
        this.zombiesSpawned=zombiesSpawned;
    }
    public Level3(Player player)
    {    
        super(1000, 600, 1);
        mainPlayer=player;
        addObject(mainPlayer,getWidth()/3,getHeight()/3);
        addObject(counter,130,100);
        addObject(healthBar,mainPlayer.getX()-5,mainPlayer.getY()-50);
        coche11.setRotation(45);
        coche21.setRotation(70);
        addObject(coche11,600,300);//150
        addObject(coche21,100,200);
        setPaintOrder(Player.class,HealthBar.class,Projectile.class,ZombieBoss.class, Coche1.class,Coche2.class, Zombie.class, Projectile.class);
    }
    public Player getPlayer(){
        return mainPlayer;
    }
    public Counter getCounter(){
        return counter;
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
    if(count%SPAWN_SPEED==0 && (counter.getScore()<=120&&zombiesSpawned<=121)){
            randomSpawn=Greenfoot.getRandomNumber(cantZ);
            switch(randomSpawn){//getHeight(), altura, getWidth(), ancho
             case 0: 
                 addObject(new Zombie(mainPlayer,counter),0,0);
                 zombiesSpawned++;
                 break;
             case 1: 
                 addObject(new ZombieBoss(mainPlayer,counter),0,getWidth());
                 addObject(new Zombie(mainPlayer,counter),0,getWidth());
                 zombiesSpawned+=2;
                 break;   
             case 2: 
                 addObject(new Zombie(mainPlayer,counter),getHeight(),0);
                 zombiesSpawned++;
                 break;
             case 3: 
                 addObject(new ZombieBoss(mainPlayer,counter),getHeight(),getWidth());
                 addObject(new Zombie(mainPlayer,counter),getHeight(),getWidth());
                 zombiesSpawned+=2;
                 break;
             case 4: 
                 addObject(new Zombie(mainPlayer,counter),getWidth()/2,getHeight());
                 zombiesSpawned++;
                 break;
             case 5: 
                 addObject(new ZombieBoss(mainPlayer,counter),getWidth(),getHeight()/2);
                 addObject(new Zombie(mainPlayer,counter),getWidth(),getHeight()/2);
                 zombiesSpawned+=2;
                 break;
            }
        }
            if(counter.getScore()>=114){
                finalScore=counter.getScore()/mainPlayer.getTime();
                Creditos creditos = new Creditos(finalScore);
                //creditos.setAttributes(mainPlayer, counter, healthBar,zombiesSpawned);
                Greenfoot.setWorld(creditos);
            }
        }
    }
