import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage; 
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
    int count=0;
    int spawnSpeed=50;
    int cantZ=8;
    int maxZombiesInWorld=32;
    int zombiesSpawned=0;//0
    int zombiesBossSpawned=0;
    int randomSpawn=Greenfoot.getRandomNumber(cantZ);
    public Player mainPlayer=new Player();
    Counter counter=new Counter();
    HealthBar healthbar=new HealthBar();
    GreenfootImage jardin=new GreenfootImage("37004198-camino-a-pie-a-través-del-jardín-en-vista-aérea.jpg");
    GreenfootImage carretera=new GreenfootImage("vista-asfáltica-de-la-carretera-desde-arriba-178645525.jpg");
    WeaponButton weaponbutton=new WeaponButton(counter);
    public MyWorld()
    {    
        super(1100, 600, 1); 
        mainPlayer=new Player(weaponbutton);
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
        if(count%spawnSpeed==0 && zombiesSpawned<33){
            randomSpawn=Greenfoot.getRandomNumber(cantZ);
            switch(randomSpawn){
             case 0: addObject(new Zombie(mainPlayer,counter),0,0);zombiesSpawned++;break;
             case 1: addObject(new Zombie(mainPlayer,counter),0,800);zombiesSpawned++;break;   
             case 2: addObject(new Zombie(mainPlayer,counter),600,0);zombiesSpawned++;break;
             case 3: addObject(new Zombie(mainPlayer,counter),600,800);zombiesSpawned++;break;
             case 4: addObject(new Zombie(mainPlayer,counter),getWidth(),getHeight());zombiesSpawned++;break;
             case 5: addObject(new Zombie(mainPlayer,counter),600,getHeight()/2);zombiesSpawned++;break;
             case 6: addObject(new Zombie(mainPlayer,counter),getWidth()/2,800);zombiesSpawned++;break;
             case 7: addObject(new Zombie(mainPlayer,counter),10,10);zombiesSpawned++;break;
            }
        }
        if(count%spawnSpeed==0 && zombiesSpawned>32 && zombiesSpawned<50){
            setBackground(jardin);
            randomSpawn=Greenfoot.getRandomNumber(cantZ);
            switch(randomSpawn){
             case 0: addObject(new Zombie(mainPlayer,counter),0,0);zombiesSpawned++;break;
             case 1: addObject(new Zombie(mainPlayer,counter),0,800);zombiesSpawned++;break;   
             case 2: addObject(new Zombie(mainPlayer,counter),600,0);zombiesSpawned++;break;
             case 3: addObject(new Zombie(mainPlayer,counter),600,800);zombiesSpawned++;break;
            }
            if(zombiesSpawned==49){
                addObject(new ZombieBoss(mainPlayer,counter),600,800);
                zombiesSpawned++;
                addObject(new WeaponButton(counter),100,500);
            }
            
        }
        if(count%spawnSpeed==0 && zombiesSpawned>=49 && zombiesSpawned<60){
            setBackground(carretera);
            randomSpawn=Greenfoot.getRandomNumber(cantZ);
            switch(randomSpawn){
             case 0: addObject(new Zombie(mainPlayer,counter),0,0);zombiesSpawned++;break;
             case 1: addObject(new Zombie(mainPlayer,counter),0,800);zombiesSpawned++;break;   
             case 2: addObject(new Zombie(mainPlayer,counter),600,0);zombiesSpawned++;break;
             case 3: addObject(new Zombie(mainPlayer,counter),600,800);zombiesSpawned++;break;
            }
            if(zombiesSpawned==55){
                addObject(new ZombieBoss(mainPlayer,counter),650,800);
                addObject(new ZombieBoss(mainPlayer,counter),700,800);
                zombiesSpawned+=2;
                addObject(new WeaponButton(counter),300,500);
            }
            if(zombiesSpawned==59){
                addObject(new ZombieBoss(mainPlayer,counter),750,800);
                addObject(new ZombieBoss(mainPlayer,counter),700,800);
                addObject(new ZombieBoss(mainPlayer,counter),500,800);
                zombiesSpawned+=3;
            }
        }
        
    }
    
}
