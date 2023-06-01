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
    private static int score=0;//staticn't
    private static int money=0;//staticn't
    public int getScore(){
        return score;
    }
    public static int getMoneyStatic(){
        return money;
    }
    public static int getScoreStatic(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public int getMoney(){
        return money;
    }
    public Counter(){
        setImage(new GreenfootImage("Score: "+score+"\n Cash: "+money,40,Color.BLACK,new Color(0,0,0,0)));
        
    }
    public void act()
    {
        //setImage(new GreenfootImage("Score: "+score+"\n Cash: "+money,40,Color.BLACK,new Color(0,0,0,0)));
        GreenfootImage image = new GreenfootImage("Score: " + score + "\n Cash: " + money, 40, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
    }
    public int resetScore(int score){
        score=0;
        return score;
    }
}
