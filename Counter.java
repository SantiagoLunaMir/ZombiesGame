import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int score=0;
    int money=0;
    public Counter(){
        setImage(new GreenfootImage("Score: "+score+"\n Cash: "+money,40,Color.BLACK,new Color(0,0,0,0)));
        
    }
    public void act()
    {
        setImage(new GreenfootImage("Score: "+score+"\n Cash: "+money,40,Color.BLACK,new Color(0,0,0,0)));
        // Add your action code here.
    }
    public static int getScore(){
        return score;
    }
    public int resetScore(int score){
        score=0;
        return score;
    }
}
