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
	
	public enum STATE {			// states of map areas (base, field, sidescroller map, etc)
		Field,
		Base
	};

	public STATE mapState = STATE.Base;

	public GGTop(int x, int y, ID player) {
		super(x, y, player);

	}

	public void tick() {

		if(x!=0&&y!=0){
			x+=Math.sqrt(2)*(velX);// moves the character around
			y+=Math.sqrt(2)*(velY);
		}else{
			x += velX;
			y += velY;
		}
		if (x >= maxX) x = maxX;
		if (x <= maxNegX) x = maxNegX;
		if (y >= maxY) y = maxY;
		if (y <= maxNegY) y = maxNegY;

		if (mapState == STATE.Base)
		{
			if (x == -4276 && y == -3980 )	// entering the battle field area
			{
				mapState = STATE.Field;
				
				if (second)
				{
					x = 0;
					y = 0;
					map = LoadImage("ruckss2.png");
					second = false;
					first = true;
				}
			}

		}
		else if (mapState == STATE.Field)
		{
			if (x <= -8164 && x >= -8300 && y >= -2654 && y <= -2324)	// returning to the main area
			{
				mapState = STATE.Base;
				
				if (first)
				{
					x = -112;
					y = -1120;
					map = LoadImage("basemap.png");
					System.out.println("start");
					first = false;
					second = true;
				}
			}


		}
		playerX=x;//updating the static references to player location. these should never be changed anywhere else
		playerY=y;




	}

	public void render(Graphics g) {	// enter character picture and information here

		if(id == ID.Map)		//creates the map
		{
			if(mapState == STATE.Base)
			{
				size = 25;
				maxX = 520;
				maxNegX =  -4276;
				maxY = 156;
				maxNegY = -4422;
				x = (int)(-112.0/1280.0*MainMenu.width)+MainMenu.offsetx;
				y = (int)(-1120.0/1280.0*MainMenu.width)+MainMenu.offsety;
				first = false;
			}

			if(mapState == STATE.Field)
			{
				size = 7;
				maxX = -34;
				maxNegX =  -8300;
				maxY =-14;
				maxNegY = -4664;
				
			}

			AffineTransform at = AffineTransform.getTranslateInstance(x, y);	// moves the picture around
			at.scale(size/1280.0*MainMenu.width,size/1280.0*MainMenu.width);
			//at.scale(25, 25);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, at, null);		// draws it

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
