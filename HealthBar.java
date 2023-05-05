import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health=50;
    //double specificHealth=(double)health;
    public HealthBar(){
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0,0,52,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
    }
    public void act()
    {
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0,0,52,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world=getWorld();
        MyWorld myWorld=(MyWorld)world;//para obtener jugador
        setLocation(myWorld.getPlayer().getX()-5,myWorld.getPlayer().getY()-50);
        loseHealth();
        // Add your action code here.
    }
    public void loseHealth(){
        World world=getWorld();
        MyWorld myWorld=(MyWorld)world;
        if(myWorld.getPlayer().hitByZombie()){
            health--;
        }
        if(health<=0){
            getWorld().showText("Mision Fallida.\n con tiempo de: "+(myWorld.getPlayer().time/60)+" segundos.\n",getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
