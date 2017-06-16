import java.awt.Color;
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
		imageX = map.getWidth()*size/1280.0*MainMenu.width*500;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*500;
		//l
	}
    protected int x, y;//location of a given instance
    protected static int velX, velY; //player move amounts? correct if wrong
    protected static double playerSpeed;
    protected ID id;//to differentiate different characters
	public static int playerX=0;//static references to player location allowing all OverChar objects to access this information for rendering and other purposes
	public static int playerY=0;
	public double size;//scaling
	public BufferedImage map;//imagerendered
	public BufferedImage HUD;
	public int health=0, collisionDamage=0;//health and damage used by energy, 0 by default
	public static int playerDamage = 2;//player stats, all static
	public static int playerHealth = 100;
	public static int maxPlayerHealth = 100;
	public abstract void tick();
	public static boolean godMode=false;
	/*public void render(Graphics g) {
		AffineTransform at = AffineTransform.getTranslateInstance((x - playerX)/1000+MainMenu.width/2-map.getWidth()/2.0*size/1280.0*MainMenu.width+MainMenu.offsetx, (y-playerY)/1000+ MainMenu.height/2-map.getHeight()/2.0*size/1280.0*MainMenu.width+MainMenu.offsety);
		at.scale(size/1280.0*MainMenu.width,size/1280.0*MainMenu.width);
		Graphics2D g2d = (Graphics2D) g;
		try{
			//g2d.drawImage(map, at, null);	
			g2d.setColor(Color.cyan);
			g2d.fillRect(780, 700, 10, 100);
		}catch(Exception e){}
		
		
	}	*/
	
	public void render(Graphics g, double angle) {
		AffineTransform at = AffineTransform.getTranslateInstance((x - playerX)/1000+MainMenu.width/2-map.getWidth()/2.0*size/1280.0*MainMenu.width+MainMenu.offsetx, (y-playerY)/1000+ MainMenu.height/2-map.getHeight()/2.0*size/1280.0*MainMenu.width+MainMenu.offsety);
		at.rotate(angle, map.getWidth()/2*size/1280.0*MainMenu.width, map.getHeight()/2*size/1280.0*MainMenu.width);
		at.scale(size/1280.0*MainMenu.width,size/1280.0*MainMenu.width);
		Graphics2D g2d = (Graphics2D) g;
		try{
			g2d.drawImage(map, at, null);
		
			
		}catch(Exception e){}
		
		
	}

	public double imageX;
	public double imageY;
	public boolean Overlap(int x, int y){
		//System.out.println(health);
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
System.out.println("failed image load");
		}
		return img;
	}
	

}