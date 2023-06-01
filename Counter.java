import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    //static factory

    private static int score=0;
    public int getScore(){
        return score;
    }
    public static int getScoreStatic(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
    }
    public Counter(){
        setImage(new GreenfootImage("Score: "+score,40,Color.BLACK,new Color(0,0,0,0)));
        
    }
    public void act()
    {
        //setImage(new GreenfootImage("Score: "+score+"\n Cash: "+money,40,Color.BLACK,new Color(0,0,0,0)));
        GreenfootImage image = new GreenfootImage("Score: " + score, 40, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
    }
    public int resetScore(int score){
        score=0;
        return score;
    }
}
