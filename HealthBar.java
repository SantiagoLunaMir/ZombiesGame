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
    private int health=100;
    private int finalScore=0;
    public int getHealth(){
        return health;
    }
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
        /*Level1 level1=(Level1)world;//para obtener jugador
        setLocation(level1.getPlayer().getX()-5,level1.getPlayer().getY()-50);
        loseHealth();*/
        if (world instanceof Level1) {
        Level1 level1 = (Level1) world;
        Player mainPlayer = level1.getPlayer();
        setLocation(mainPlayer.getX() - 5, mainPlayer.getY() - 50);

        loseHealth(level1);
        }
        if (world instanceof Level2) {
        Level2 level2 = (Level2) world;
        Player mainPlayer = level2.getPlayer();
        setLocation(mainPlayer.getX() - 5, mainPlayer.getY() - 50);

        loseHealth(level2);
        }
        if (world instanceof Level3) {
        Level3 level3 = (Level3) world;
        Player mainPlayer = level3.getPlayer();
        setLocation(mainPlayer.getX() - 5, mainPlayer.getY() - 50);

        loseHealth(level3);
        }
        // Add your action code here.
    }
    public void loseHealth(Level3 level3){
        World world=getWorld();
        
        //Level1 level1=(Level1)world;
        if(level3.getPlayer().hitByZombie()){
            health--;
        }
        if(health<=0){
            finalScore=level3.getCounter().getScore()+1/level3.getPlayer().getTime();
            Greenfoot.setWorld(new GameOver(finalScore));
            Greenfoot.playSound("defeat.mp3");
        }
    }
    public void loseHealth(Level2 level2){
        World world=getWorld();
        
        //Level1 level1=(Level1)world;
        if(level2.getPlayer().hitByZombie()){
            health--;
        }
        if(health<=0){
            finalScore=level2.getCounter().getScore()+1/level2.getPlayer().getTime();
            Greenfoot.setWorld(new GameOver(finalScore));
            Greenfoot.playSound("defeat.mp3");
        }
    }
    public void loseHealth(Level1 level1){
        World world=getWorld();
        
        //Level1 level1=(Level1)world;
        if(level1.getPlayer().hitByZombie()){
            health--;
        }
        if(health<=0){
            finalScore=level1.getCounter().getScore()+1/level1.getPlayer().getTime();
            Greenfoot.setWorld(new GameOver(finalScore));
            Greenfoot.playSound("defeat.mp3");
        }
    }
}
