import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;



public class ScoreBoard extends Actor
{
    // The vertical gap between user images in the scoreboard:
    private final int GAP = 10;
    // The height of the "All Players"/"Near Me" text at the top:
    private final int HEADER_TEXT_HEIGHT = 25;
    // The main text color:
    private final Color MAIN_COLOR = new Color(0x60, 0x60, 0x60); // dark grey
    // The score color:
    private final Color SCORE_COLOR = new Color(0xB0, 0x40, 0x40); // orange-y
    // The background colors:
    private final Color BACKGROUND_COLOR = new Color(0xFF, 0xFF, 0xFF, 0xB0);
    private final Color BACKGROUND_HIGHLIGHT_COLOR = new Color(180, 230, 255, 0xB0);

    /**
     * Constructor for objects of class ScoreBoard.
     * <p>
     * You can specify the width and height that the score board should be, but
     * a minimum width of 600 will be enforced.
     */
    public ScoreBoard(int width, int height,int finalScore)
    {     
        setImage(new GreenfootImage(Math.max(600, width), height));
        leaderboard(finalScore); 
        drawScores();
    }
    
    private void drawString(String text, int x, int y, Color color, int height)
    {
        getImage().drawImage(new GreenfootImage(text, height, color, new Color (0,0,0,0)), x, y);
    }
    
    private void drawScores()
    {
        // 50 pixels is the max height of the user image
        final int pixelsPerUser = 50 + 2*GAP;
        // Calculate how many users we have room for:
        final int numUsers = ((getImage().getHeight() - (HEADER_TEXT_HEIGHT + 10)) / pixelsPerUser);
        final int topSpace = getImage().getHeight() - (numUsers * pixelsPerUser) - GAP;
        
        getImage().setColor(BACKGROUND_COLOR);
        getImage().fill();

        drawString("TOP PLAYERS", 250, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);
        //drawString("Near You", 100 + getImage().getWidth() / 2, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);        
        
        drawUserPanel(GAP, topSpace, (getImage().getWidth()) - GAP, topSpace + numUsers * pixelsPerUser, UserInfo.getTop(numUsers));
        //drawUserPanel(GAP + getImage().getWidth() / 2, topSpace, getImage().getWidth() - GAP, topSpace + numUsers * pixelsPerUser, UserInfo.getNearby(numUsers));
    }
    
    private void drawUserPanel(int left, int top, int right, int bottom, List users)
    {
        getImage().setColor(MAIN_COLOR);
        getImage().drawRect(left, top, right - left, bottom - top);
        
        if (users == null)
            return;
        
        UserInfo me = UserInfo.getMyInfo();
        int y = top + GAP;
        for (Object obj : users)
        {
            UserInfo playerData = (UserInfo)obj;            
            Color c;
            
            if (me != null && playerData.getUserName().equals(me.getUserName()))
            {
                // Highlight our row in a sky blue colour:
                c = BACKGROUND_HIGHLIGHT_COLOR;
            }
            else
            {
                c = BACKGROUND_COLOR;
            }
            getImage().setColor(c);
            getImage().fillRect(left + 5, y - GAP + 1, right - left - 10, 50 + 2*GAP - 1);

            int x = left + 10;
            drawString("#" + Integer.toString(playerData.getRank()), x, y+18, MAIN_COLOR, 14);
            x += 50;
            drawString(Integer.toString(playerData.getScore()), x, y+18, SCORE_COLOR, 14);
            x += 80;
            getImage().drawImage(playerData.getUserImage(), x, y);
            x += 55;
            drawString(playerData.getUserName(), x, y + 18, MAIN_COLOR, 14);
            y += 50 + 2*GAP;
        }
    }
    public void leaderboard(int finalScore)
    {
        if (UserInfo.isStorageAvailable()) 
        {  
            UserInfo myInfo = UserInfo.getMyInfo();  
            if (finalScore > myInfo.getScore())
            {  
                myInfo.setScore(finalScore);  
                myInfo.store();   
            }  
 
        }
    }
}
