
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
	int maxX;
	int maxNegX;
	int maxY;
	int maxNegY;
	int delay=0;
	int ranX;//for random enemy x
	int ranY;//for random enemy y
	
	
	
	
//****************************************************************************

	public enum STATE {			// states of map areas (base, field, sidescroller map, etc)
		Field,
		Base
	};
	
//******************************************************************************
	
	
	public STATE mapState = STATE.Base;

	public GGTop(int x, int y, ID player) {
		super(x, y, player, LoadImage("basemap.png"),25/1600.0*MainMenu.width);
		maxX = (int)(-555/1360.0*MainMenu.width);
		maxNegX =  (int)(3554.0/1360*MainMenu.width);
		maxY = (int)(-1110.0/1360*MainMenu.width);
		maxNegY = (int)(2954.0/1360*MainMenu.width);
	}

	public void tick() {

		//System.out.println(mapState);

		if(id==ID.Player){
			if(velX!=0&&velY!=0){
				if(velX>0){
				OverChar.playerX+=Math.sqrt((velX*velX)/2);// moves the character around
				}else OverChar.playerX-=Math.sqrt((velX*velX)/2);
				if(velY>0){	
				OverChar.playerY+=Math.sqrt((velY*velY)/2);
				}else OverChar.playerY-=Math.sqrt((velY*velY)/2);
			}else{
				OverChar.playerX += velX;
				OverChar.playerY += velY;
			}
			if (playerX <= maxX) playerX = maxX;
			if (playerX >= maxNegX) playerX = maxNegX;
			if (playerY <= maxY) playerY = maxY;
			if (playerY >= maxNegY) playerY = maxNegY;
			return;
		}
		if (mapState == STATE.Base)
		{
			
			
			if (playerX >= 3544.0/1360.0*MainMenu.width && playerY >= 2375.0/1360.0*MainMenu.width && playerY<= 2500.0/1360.0*MainMenu.width)	// entering the battle field area

			{
//*****************************************************************************

				mapState = STATE.Field;
				
				//if (second)
				//{
				x = (int)(30.0/1360*MainMenu.width);
				y = (int)(-871.0/1360*MainMenu.width);
				map = LoadImage("ruckss2.png");
				//second = false;
				//first = true;
				size = 7/1600.0*MainMenu.width;
				maxX = (int)(-559/1360.0*MainMenu.width);
				maxNegX =  (int)(7635/1360.0*MainMenu.width);
				maxY =(int)(-1153/1360.0*MainMenu.width);
				maxNegY = (int)(3403/1360.0*MainMenu.width);
				OverChar.playerX=0;
				OverChar.playerY=0;
				
				//}

				

//****************************************************************************
				
				
			}
			

		}
		else if (mapState == STATE.Field)
		{
			for (int w = 0; w > 10; w++)
			{
			if(delay==0){
				delay = (int)(Math.random()*1200);
				//96x96
				ranX = (int) (Math.random() * MainMenu.width -96);
				ranY = (int) (Math.random() * MainMenu.height -96);
				//Spawner(ranX,ranY,Enemy, map, null);
				
				
			}
			if (delay >0)delay--;
			}
			
			
			if (x <= 8164/1600.0*MainMenu.width && x >= 8300/1600.0*MainMenu.width && y >= 2654/1600.0*MainMenu.width && y <= 2324/1600.0*MainMenu.width)	// returning to the main area
			{
//****************************************************************************

				mapState = STATE.Base;
				
				//if (first)
				//{
					x = (int)(30.0/1360*MainMenu.width);
					y = (int)(-871.0/1360*MainMenu.width);
					map = LoadImage("basemap.png");
					System.out.println("start");
					//first = false;
					//second = true;
					size = 25/1600.0*MainMenu.width;
					maxX = (int)(-555/1360.0*MainMenu.width);
					maxNegX =  (int)(3554.0/1360*MainMenu.width);
					maxY = (int)(-1110.0/1360*MainMenu.width);
					maxNegY = (int)(2954.0/1360*MainMenu.width);
					OverChar.playerX=0;
					OverChar.playerY=0;
					
				//}

				

			}

		}
    

		//System.out.println(velX + "   " + velY);


	}

	public void render(Graphics g) {	// enter character picture and information here

		if(id == ID.Map)		//creates the map
		{

//*************************************************************

				
			AffineTransform at = AffineTransform.getTranslateInstance(x-playerX, y-playerY);	// moves the picture around
			at.scale(size,size);
			
			//at.scale(25, 25);

			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, at, null);		// draws it

		}

		else if (id == ID.Player) // creates the player
		{
			int mouseY = MouseInfo.getPointerInfo().getLocation().y;		// mouse tracking
			int mouseX = MouseInfo.getPointerInfo().getLocation().x;


			BufferedImage map = LoadImage("GGtop.png");
			//AffineTransform tat = AffineTransform.getTranslateInstance(0,0);
			AffineTransform tat = AffineTransform.getTranslateInstance((MainMenu.width/2-map.getWidth()/1600.0*MainMenu.width+MainMenu.offsetx), MainMenu.height/2-map.getHeight()/1600.0*MainMenu.width+MainMenu.offsety);
			tat.scale(2.0/1600.0*MainMenu.width, 2.0/1600.0*MainMenu.width);
			double angle = Math.atan2(MainMenu.height/2.0 - mouseY+MainMenu.offsety, MainMenu.width/2.0 - mouseX+MainMenu.offsetx) - Math.PI/2;

			tat.rotate(angle, map.getWidth()/2, map.getHeight()/2);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, tat, null);


		}


	}

}

