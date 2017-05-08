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
	int size = 25;
	int maxX = 520;
	int maxNegX =  -4276;
	int maxY = 156;
	int maxNegY = -4422;
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
		x += velX;							// moves the character around
		y += velY;

		if (x >= maxX) x = maxX;			// boundary detection 
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
			at.scale(size,size);			// scales it (multiplied by the size)
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, at, null);		// draws it

		}

		else if (id == ID.Player) // creates the player
		{
			int centerX = 576;
			int centerY = 296;
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;		// mouse tracking
			int mouseX = MouseInfo.getPointerInfo().getLocation().x;
			int shift = 20;

			double angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI/2;

			AffineTransform tat = AffineTransform.getTranslateInstance((1280/2)-shift, (720/2)-shift);
			BufferedImage map = LoadImage("GGtop.png");
			tat.scale(2, 2);
			tat.rotate(angle, map.getWidth()/2, map.getHeight()/2);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, tat, null);	

		}


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
