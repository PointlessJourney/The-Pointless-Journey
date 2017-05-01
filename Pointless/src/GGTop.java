import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class GGTop extends OverChar {
	static int count = 0;
	boolean first = true;
	public GGTop(int x, int y, ID player) {
		super(x, y, player);
		
	}

	public void tick() {
		
		x += velX;
		y += velY;
		int z = 0;
	}
	
	public void render(Graphics g) {	// enter character picture and information here
		// TODO Auto-generated method stub
		if(id == ID.Player)
		{
			if (first)
			{
				x = 576;
				y = -2578;
				first = false;
			}
			
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 4000, 3000); // draw your rectangle

		}
		else if (id == ID.Player2)
		{
			int centerX = 652;
			int centerY = 372;
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;
			int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		

			double angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI/2;


			((Graphics2D)g).rotate(angle, centerX, centerY);
			Graphics2D g2d = (Graphics2D)g;
			AffineTransform transform = g2d.getTransform();
			g.setColor(Color.RED);
			g.fillRect(640, 360, 25, 25); // draw your rectangle
			g2d.rotate(angle, centerX, centerY);
			g2d.setTransform(transform);
			

		}
		
			
	}

}