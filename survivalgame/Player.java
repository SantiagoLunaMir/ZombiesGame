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
    private int weaponUpgrade=0;
    public Player(){

    }

    public Player(WeaponButton weaponbutton){
        this.weaponbutton=weaponbutton;
    }

    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fire();
        hitByZombie();
        //touchBoxes();

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
        if((Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null)) && weaponbutton.weaponUpgrade==1){//sustituir por espacio
            Projectile projectile=new Projectile();
            getWorld().addObject(projectile,getX(),getY());//+70 +20
            projectile.setRotation(getRotation());
            projectile.move(25);
        }
        if((Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null))&& weaponbutton.weaponUpgrade==2){//sustituir por espacio
            Projectile projectile=new Projectile();
            getWorld().addObject(projectile,getX(),getY());//+70 +20
            projectile.setRotation(getRotation()-5);
            projectile.move(20);
            Projectile projectile2=new Projectile();
            getWorld().addObject(projectile2,getX(),getY());//+70 +20
            projectile2.setRotation(getRotation()+5);
            projectile2.move(5);
        }
        if((Greenfoot.isKeyDown("space") || Greenfoot.mousePressed(null)) && weaponbutton.weaponUpgrade==3){//sustituir por espacio
            Projectile projectile=new Projectile();
            getWorld().addObject(projectile,getX(),getY());//+70 +20
            projectile.setRotation(getRotation()-5);
            projectile.move(20);
            Projectile projectile2=new Projectile();
            getWorld().addObject(projectile2,getX(),getY());//+70 +20
            projectile2.setRotation(getRotation()+5);
            projectile2.move(5);
            Projectile projectile3=new Projectile();
            getWorld().addObject(projectile3,getX(),getY());//+70 +20
            projectile3.setRotation(getRotation());
            projectile3.move(5);
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

    public void touchBoxes(){
        Actor weaponButton= getOneIntersectingObject(WeaponButton.class);
        if(Greenfoot.mousePressed(weaponbutton)){
            getWorld().removeObject(weaponButton);
        }
    }
    // Add your action code here.

}
