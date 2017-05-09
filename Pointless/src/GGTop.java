import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class GGTop extends OverChar {
	static int count = 0;
	boolean first = true;
	boolean second = true;
	int maxX = 520;
	int maxNegX =  -4276;
	int maxY = 156;
	int maxNegY = -4422;
	int size = 25;
	BufferedImage map = LoadImage("basemap.png");

	public GGTop(int x, int y, ID player) {
		super(x, y, player);

	}

	public void tick() {
		if(x!=0&&y!=0){
			x+=Math.sqrt(2)*(velX);
			y+=Math.sqrt(2)*(velY);
		}else{
			x += velX;
			y += velY;
		}
		if (x >= maxX) x = maxX;
		if (x <= maxNegX) x = maxNegX;
		if (y >= maxY) y = maxY;
		if (y <= maxNegY) y = maxNegY;

		if (x == -4276 && y <= -3950 && y >=-4010)//map change
		{
			size = 7;
			map = LoadImage("ruckss2.png");
			maxX = -30;
			maxNegX =  -7556;
			maxY =-14;
			maxNegY = -4304;
			x = 0;
			y = 0;
			Handler.addObject(new BasicSpawner(50,50,ID.Enemy));//creating spawners
			
			
		}
		playerX=x;//updating the static references to player location. these should never be changed anywhere else
		playerY=y;



	}

	public void render(Graphics g) {	// enter character picture and information here

		if(id == ID.Map)		//creates the map
		{
			if (first)
			{
				x = (int)(-112.0/1280.0*MainMenu.width)+MainMenu.offsetx;
				y = (int)(-1120.0/1280.0*MainMenu.width)+MainMenu.offsety;
				System.out.println("start");
				first = false;
			}
			

			AffineTransform at = AffineTransform.getTranslateInstance(x, y);
			at.scale(size/1280.0*MainMenu.width,size/1280.0*MainMenu.width);
			//at.scale(25, 25);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, at, null);	

		}

		else if (id == ID.Player) // creates the player
		{
			
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;
			int mouseX = MouseInfo.getPointerInfo().getLocation().x;
			//int shift = 20;

			

			BufferedImage map = LoadImage("GGtop.png");
			AffineTransform tat = AffineTransform.getTranslateInstance((MainMenu.width/2-map.getWidth()), MainMenu.height/2-map.getHeight());
			tat.scale(2.0/1280.0*MainMenu.width, 2.0/1280.0*MainMenu.width);
			double angle = Math.atan2(MainMenu.height/2.0 - mouseY, MainMenu.width/2.0 - mouseX) - Math.PI/2;
			tat.rotate(angle, map.getWidth()/2, map.getHeight()/2);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, tat, null);	

		}


	}
	


}