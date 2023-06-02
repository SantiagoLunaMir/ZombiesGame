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
    private int speed=3;
    private int time=0;
    /*private WeaponButton weaponbutton;
    public WeaponButton getWeaponButton(){
        return weaponbutton;
    }*/
    public int getTime(){
        return time;
    }
    public int getSpeed(){
        return speed;
    }
    public Player(){
        
    }
    /*public Player(WeaponButton weaponbutton){
        this.weaponbutton=weaponbutton;
    }*/
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fire();
        hitByZombie();
        //touchBoxes();
        
    }
    public int getPlayerTime(){
        return time;
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
            if((Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null))){//sustituir por espacio
                Projectile projectile=new Projectile();
                getWorld().addObject(projectile,getX(),getY());//+70 +20
                projectile.setRotation(getRotation());
                projectile.move(25);
            }
            
        }
        
        public boolean hitByZombie(){
            Actor zombie=getOneObjectAtOffset(0,0,Zombie.class);
            Actor zombieBoss=getOneObjectAtOffset(0,0,ZombieBoss.class);
            if(zombie!=null || zombieBoss!=null){
                return true;
            }
            else
            return false;
        }
        /*public void touchBoxes(){
        Actor weaponButton= getOneIntersectingObject(WeaponButton.class);
        if(Greenfoot.mousePressed(weaponbutton)){
                getWorld().removeObject(weaponButton);
        }
        }*/
        // Add your action code here.
    
}       // Add your action code here}
