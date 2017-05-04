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

	public GGTop(int x, int y, ID player) {
		super(x, y, player);
		
	}

	public void tick() {
		
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g) {	// enter character picture and information here
		if(id == ID.Player)
		{
			if (first)
			{
				x = 576;
				y = 296;
				first = false;
			}
			
			AffineTransform at = AffineTransform.getTranslateInstance(x, y);
			BufferedImage map = LoadImage("basemap.png");
			int size = 25;
			at.scale(size,size);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, at, null);			

		}
		
		else if (id == ID.Player2)
		{
			int centerX = 576;
			int centerY = 296;
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;
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