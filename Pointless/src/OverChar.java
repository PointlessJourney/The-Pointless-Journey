import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class OverChar
{
	public OverChar(int x, int y, ID id, BufferedImage map,double size)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.map = map;
		this.size = size;
		imageX = map.getWidth()/1280.0*MainMenu.width*500;
		imageY = map.getHeight()/1280.0*MainMenu.width*500;
		//l
	}
    protected int x, y;
    protected static int velX, velY; 
    protected static double playerSpeed=10000.0;
    protected ID id;
	public static int playerX=0;//static references to player location allowing all OverChar objects to access this information for rendering and other purposes
	public static int playerY=0;
	public double size;
	public BufferedImage map;
	public int health;
	public static int playerDamage = 2;
	public abstract void tick();
	public void render(Graphics g) {
		AffineTransform at = AffineTransform.getTranslateInstance((x - playerX)/1000+MainMenu.width/2-map.getWidth()/2.0*size/1280.0*MainMenu.width+MainMenu.offsetx, (y-playerY)/1000+ MainMenu.height/2-map.getHeight()/2.0*size/1280.0*MainMenu.width+MainMenu.offsety);
		at.scale(size/1280.0*MainMenu.width,size/1280.0*MainMenu.width);
		Graphics2D g2d = (Graphics2D) g;
		try{
			g2d.drawImage(map, at, null);	
		}catch(Exception e){}
		
		
	}

	public double imageX;
	public double imageY;
	public boolean Overlap(int x, int y){
		System.out.println(health);
		if(this.x+imageX>x&&x>this.x-imageX&&this.y+imageY>y&&y>this.y-imageY){
			health = health-playerDamage;
			return true;
		}
		return false;
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
	static BufferedImage LoadImage(String FileName)
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