
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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
		maxX = (int)(-555000/1360.0*MainMenu.width);
		maxNegX =  (int)(3554000.0/1360*MainMenu.width);
		maxY = (int)(-1110000.0/1360*MainMenu.width);
		maxNegY = (int)(2954000.0/1360*MainMenu.width);
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



			for(int i = 2;i<Handler.object.size();i++){
				OverChar check = Handler.object.get(i);
				if(check.id==ID.Enemy&&check.Overlap(playerX, playerY)){
					playerHealth -= check.collisionDamage;
				}
			}
			if(playerHealth<=0){
				//System.out.println("You died");//put actual death code here<<<<<<<<<<<<<<<<<<<<<<<<<<DEATH
				System.exit(0);
			}
			return;
		}
		if (id == ID.Map)
		{
			if (playerX <= maxX) playerX = maxX;
			if (playerX >= maxNegX) playerX = maxNegX;
			if (playerY <= maxY) playerY = maxY;
			if (playerY >= maxNegY) playerY = maxNegY;
			if (mapState == STATE.Base)
			{
				if (playerX >= 3544000.0/1360.0*MainMenu.width && playerY >= 2375000.0/1360.0*MainMenu.width && playerY<= 2500000.0/1360.0*MainMenu.width)	// entering the battle field area

				{
					//*****************************************************************************

					mapState = STATE.Field;
					//if (second)
					//{
					x = (int)(30000.0/1360*MainMenu.width);
					y = (int)(-860000.0/1360*MainMenu.width);
					map = LoadImage("ruckss2.png");
					//second = false;
					//first = true;
					size = 7/1600.0*MainMenu.width;
					maxX = (int)(56090/1360.0*MainMenu.width);
					maxNegX =  (int)(6944789/1360.0*MainMenu.width);
					maxY =(int)(-827293/1360.0*MainMenu.width);
					maxNegY = (int)(3002948/1360.0*MainMenu.width);
					OverChar.playerX=0;
					OverChar.playerY=0;
					double scale = 1440.0/MainMenu.width;
					int shiftX = (int)(1000/scale);
					int shiftY = (int)(1000/scale);


					if (first = true)
					{
						Handler.addObject(new Spawner((int)((shiftX + 400000)/scale), (int)((shiftY + -939000)/scale), ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));
						Handler.addObject(new Spawner((int)((shiftX + 463000)/scale), (int)((shiftY + 276000)/scale), ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));
						Handler.addObject(new Spawner((int)((shiftX + 328000)/scale), (int)((shiftY + 2535000)/scale), ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));
						Handler.addObject(new Spawner((int)((shiftX + 3322000)/scale), (int)((shiftY + -958000)/scale), ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));
						Handler.addObject(new Spawner((int)((shiftX + 7111000)/scale), (int)((shiftY + -1003000)/scale), ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));
						Handler.addObject(new Spawner((int)((shiftX + 6357000)/scale),(int) ((shiftY + 2736000)/scale), ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));
						Handler.addObject(new Spawner((int)((shiftX + 5453000)/scale), (int)((shiftY + 542000)/scale), ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));

						first = false;
					}

					//}



					//****************************************************************************


				}


			}
			else if (mapState == STATE.Field)
			{		
				//System.out.println("delay" + delay);

				/*if(delay==0)
			{	
				delay = (int)(Math.random() * 1200.0);
				//96x96
				//for (int w = 0; w > 10; w++)
				//{
				ranX = (int) (Math.random() * MainMenu.width -96)*1000;
				ranY = (int) (Math.random() * MainMenu.height -96)*1000;
				Handler.addObject(new RandomSpawner(ranX,ranY,ID.RandomEnemy,LoadImage("bad guy clone.gif") ,96.0));
				System.out.println("Spawned" + ranX + ranY);
				//}
			}
			else
			{
				delay--;
			}*/



				if (playerX <= 8164000/1600.0*MainMenu.width && playerX >= 8300000/1600.0*MainMenu.width && playerY >= 2654000/1600.0*MainMenu.width && playerY <= 2324000/1600.0*MainMenu.width)	// returning to the main area
				{
					//****************************************************************************

					mapState = STATE.Base;

					//if (first)
					//{
					x = (int)(30000.0/1360*MainMenu.width);
					y = (int)(-871000.0/1360*MainMenu.width);
					map = LoadImage("basemap.png");
					System.out.println("start");
					//first = false;
					//second = true;
					size = 25/1600.0*MainMenu.width;
					maxX = (int)(-555000/1360.0*MainMenu.width);
					maxNegX =  (int)(3554000.0/1360*MainMenu.width);
					maxY = (int)(-1110000.0/1360*MainMenu.width);
					maxNegY = (int)(2954000.0/1360*MainMenu.width);
					OverChar.playerX=0;
					OverChar.playerY=0;

					//}
				}
			}
		}
	}


	//System.out.println(velX + "   " + velY);

	public void render(Graphics g, double angle) {	// enter character picture and information here

		if(id == ID.Map)		//creates the map
		{

			//*************************************************************

			AffineTransform at = AffineTransform.getTranslateInstance((x-playerX)/1000, (y-playerY)/1000);	// moves the picture around

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
			angle = Math.atan2(MainMenu.height/2.0 - mouseY+MainMenu.offsety, MainMenu.width/2.0 - mouseX+MainMenu.offsetx) - Math.PI/2;
			tat.rotate(angle, map.getWidth()/2, map.getHeight()/2);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(map, tat, null);

		}


	}

}

