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
    int animateImage=1;//-16
    int count;//-16
    int animateSpeed=5;
    int health=100;
    Player player;
    Counter counter;
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
        hitByProjectile();
        // Add your action code here.
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
        move(1);
        turnTowards(player.getX(),player.getY());
    }
    public void hitByProjectile(){
        Actor projectile= getOneIntersectingObject(Projectile.class);
        if(projectile!=null){
            health--;
            getWorld().removeObject(projectile);
        }
        if(health==0){
            counter.score++;
            counter.money+=40;
            getWorld().removeObject(this);
            //agregar mancha de sangre
        }
    }
}
