import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed=3;
    int time=0;
    public Player(){
        
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fire();
        //uLose();
        hitByZombie();
    }
        public void turnAround(){
            if(Greenfoot.getMouseInfo()!=null){//si tenemos el mouse dentro
        turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
        }
        }
        public void moveAround(){
           if(Greenfoot.isKeyDown("w")){//si tenemos el mouse dentro
        setLocation(getX(),getY()-speed);
        }
        if(Greenfoot.isKeyDown("s")){//si tenemos el mouse dentro
        setLocation(getX(),getY()+speed);
        }
        if(Greenfoot.isKeyDown("a")){//si tenemos el mouse dentro
        setLocation(getX()-speed,getY());
        }
        if(Greenfoot.isKeyDown("d")){//si tenemos el mouse dentro
        setLocation(getX()+speed,getY());
        } 
        }
        public void fire(){
            if(Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null)){//sustituir por espacio
                Projectile projectile=new Projectile();
                getWorld().addObject(projectile,getX(),getY());//+70 +20
                projectile.setRotation(getRotation());
            }
        }
        /*public void uLose(){
            if(isTouching(Zombie.class)){
                getWorld().showText("Perdiste karnal, duraste: "+(time/60)+" segundos",getWorld().getWidth()/2,getWorld().getHeight()/2);
                Greenfoot.stop();
            }
        }*/
        public boolean hitByZombie(){
            Actor zombie=getOneObjectAtOffset(0,0,Zombie.class);
            if(zombie!=null){
                return true;
            }
            else
            return false;
        }
        // Add your action code here.
    
}
