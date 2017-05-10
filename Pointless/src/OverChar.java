import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class OverChar
{
	public OverChar(int x, int y, ID id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
    protected int x, y;
    protected static int velX, velY; 
    protected static double playerSpeed=10.0;
    protected ID id;
	public static int playerX=0;//static references to player location allowing all OverChar objects to access this information for rendering and other purposes
	public static int playerY=0;
	private int size;
	private BufferedImage map;
	public abstract void tick();
	public void render(Graphics g) {
		AffineTransform at = AffineTransform.getTranslateInstance(x - playerX, y-playerY);
		at.scale(size/1280.0*MainMenu.width,size/1280.0*MainMenu.width);
		Graphics2D g2d = (Graphics2D) g;
		try{
			g2d.drawImage(map, at, null);	
		}catch(Exception e){}
		
		
	}
	
    
    
    public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	public void setID(ID id)	{
		this.id = id;
	}
	public ID getID()
	{
		return id;
	}
	public static void setVelX(int velX)
	{
		OverChar.velX = velX;
	}
	public static int getVelX()
	{
		return velX;
	}
	public static void setVelY(int velY)
	{
		OverChar.velY = velY;
	}
	public static int getVelY()
	{
		return velY;
	}
	public static void setPlayerSpeed(double playerSpeed){
		OverChar.playerSpeed=playerSpeed;
	}
	BufferedImage LoadImage(String FileName)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(new File(FileName));
		}
		catch (IOException e)
		{

		}
		return img;
	}
	
	

}