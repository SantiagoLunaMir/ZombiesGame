import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieBoss extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int animateImage=1;//-16
    private int count;//-16
    private int animateSpeed=5;
    private int health=100;
    private Player player;
    private Counter counter;
    
    public ZombieBoss(Player mainPlayer,Counter counter){
        this.counter=counter;
        player=mainPlayer;
        setImage("IDLE (10).png");
        //getImage().scale(30,30);//escalar la imagen

    }
    public void act()
    {
        count++;
        animate();
        moveAround();
        //followPlayer();
        hitByProjectile();
        // Add your action code here.
    }
    public void followPlayer(Player player) {
    if (player != null) {
        turnTowards(player.getX(), player.getY());
        move(1);
    }
}
    public void animate(){
        if(count%animateSpeed==0){
            if(animateImage>20){
                animateImage=1;
            }
            setImage("IDLE ("+ animateImage +").png");
            animateImage++;
            //getImage().scale(30,30);//escalar la imagen
        }
    }
    public void moveAround(){
        Actor cama=getOneIntersectingObject(Cama.class);
        Actor sillasJardin=getOneIntersectingObject(SillasJardin.class);
        Actor coche1=getOneIntersectingObject(Coche1.class);
        Actor coche2=getOneIntersectingObject(Coche2.class);
        World level=getWorld();
        //if(coche1==null && level instanceof Level3){
            move(1);
            turnTowards(player.getX(),player.getY());
        /*}else if(coche1!=null && level instanceof Level3){
            move(0);
            turnTowards(player.getX(),player.getY());
        }else if(coche2==null&& level instanceof Level3){
            move(1);
            turnTowards(player.getX(),player.getY());
        }else if(coche2!=null && level instanceof Level3){
            move(0);
            turnTowards(player.getX(),player.getY());
        }*/
    }
    public void hitByProjectile(){
        Actor projectile= getOneIntersectingObject(Projectile.class);
        if(projectile!=null){
            health--;
            getWorld().removeObject(projectile);
        }
        if(health==0){
            Greenfoot.playSound("ZombieDeath.mp3");
            counter.setScore(counter.getScore()+1);
            getWorld().removeObject(this);
            //agregar mancha de sangre
        }
    }
}
