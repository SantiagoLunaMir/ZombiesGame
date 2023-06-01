import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Button
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act(this.getClass().getName());
    }   
    
    public void onButtonClicked(){
        //menuScreen.stopMusic();
        Greenfoot.setWorld(new Level1());
        //Greenfoot.deleteWorld(MenuScreen());
        //private static Counter counter=new Counter();
        //counter.getScore(counter.setScore(0));//redundancia
    }
}
