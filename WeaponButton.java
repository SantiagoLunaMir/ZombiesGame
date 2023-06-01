import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponButton extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Counter counter;
    private int weaponUpgrade=1;
    public Counter getWeaponCounter(){
        return counter;
    }
    public int getWeaponUpgrade(){
        return weaponUpgrade;
    }
    public WeaponButton(Counter counter){
        this.counter=counter;
        setImage(new GreenfootImage("Weapon\n Upgrade!",25,Color.BLACK,new Color (0,0,0,0)));//cambiar por un bloque especial
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this) && counter.getMoney()>149){//preciona el objeto
            counter.setMoney(counter.getMoney()-150);
            weaponUpgrade++;
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }public boolean touchBoxesW(){
            Actor player= getOneIntersectingObject(Player.class);
            if(player!=null){
               //getWorld().removeObject(weaponButton);
               return true;
            }
            else
            return false;
    }
}
