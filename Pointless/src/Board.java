

//importing what we need 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;
 


public class Board{

	public static Bullet bullet;

	//private static Hero hero;
	private static ArrayList<Bullet> bullets=new ArrayList<Bullet>();;
	private static int  sx, sy, reload, numToShoot, spread, bWidth,
	bHeight;
	private static int tmpLoad=0;
	private static boolean moveForward, canForward, canBackward, moveBackward, left,
	right, special;
	public static boolean fire;
	static double angle, check, tmpAngle, total;
	// constructor


	// initialisation
	public static void init() {
		tmpAngle = 0;
		special = fire = left = right = moveForward = moveBackward = false;
		canForward = canBackward = true;
		sx = sy = 2;
		bullet = new Bullet(0, 0, 0);
		reload = 10;
		numToShoot = 1;
		spread = 0;
	}
	public static void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;


		// draw the image

		// drawing the bullets
		for (int i = 0; i < bullets.size(); i++) {
			Bullet tmpB = (Bullet) bullets.get(i);
			//playing with bullet colors
			if (i % 2 == 0) {
				g2d.setColor(Color.BLUE);
			} else {
				g2d.setColor(Color.MAGENTA);
			} 
			//g2d.fillRect( (int) ((tmpB.getX()-OverChar.playerX)/1000-(2.5/1360.0*MainMenu.width))+MainMenu.width/2-MainMenu.offsetx, (int) ((tmpB.getY()-OverChar.playerY)/1000-(2.5/1360.0*MainMenu.width))+MainMenu.height/2-MainMenu.offsety, (int)(5.0/1360.0*MainMenu.width),
			//		(int)(5.0/1360.0*MainMenu.width));
			int x =(int)((tmpB.getX()-OverChar.playerX)/1000)+MainMenu.width/2+MainMenu.offsetx;
			int y = (int) ((tmpB.getY()-OverChar.playerY)/1000)+MainMenu.height/2+MainMenu.offsety;
			g2d.drawLine(x, y, (int)(x+10*Math.cos(tmpB.getA()-Math.PI)), (int)(y+10*Math.sin(tmpB.getA()-Math.PI)));
			//g2d.drawLine(x, y, MainMenu.width/2+MainMenu.offsetx, MainMenu.height/2+MainMenu.offsety);
			//System.out.println((tmpB.getX()-OverChar.playerX)/1000-(2.5/1360.0*MainMenu.width)+MainMenu.width-MainMenu.offsetx);
		}

	}

	public static void play() {

		// moving bullets
		ArrayList<Bullet> tmpBs = bullets;
		for (int i = 0; i < tmpBs.size(); i++) {
			Bullet tmpB = (Bullet) tmpBs.get(i);
			tmpB.moveForward();
			if (tmpB.count==0) {
				//  System.out.println("gone"+(Math.sqrt((tmpB.getX()-OverChar.playerX)*(tmpB.getX()-OverChar.playerX)+(tmpB.getY()-OverChar.playerY)*(tmpB.getY()-OverChar.playerY))));//add range
				tmpBs.remove(i);
			}
			for(int j = 2;j<Handler.object.size();j++){
				try{
					if(Handler.object.get(j).Overlap((int)tmpB.getX(), (int)tmpB.getY()))tmpBs.remove(i);
				}catch(Exception e){System.out.println("bullet broke");}
			}
		}

		// check if shooting
		if (fire) {
			//System.out.println("HOW");
			// if reloading time is done
			if (tmpLoad == 0) { 

				for (int i = 0; i < numToShoot; i++) {
					// setting the bullet
					Board.bullet.setX(OverChar.playerX);
					Board.bullet.setY(OverChar.playerY);
					//int centerX = 652;
					//int centerY = 372;
					int mouseY = MouseInfo.getPointerInfo().getLocation().y;		// mouse tracking
					int mouseX = MouseInfo.getPointerInfo().getLocation().x;
					// double angle = -Math.toDegrees(Math.atan2( ((mouseX- centerX)), ( (mouseY-centerY))))+90;
					//angle = Math.toRadians(angle);
					double angle = Math.atan2(MainMenu.height/2.0 - mouseY+MainMenu.offsety, MainMenu.width/2.0 - mouseX+MainMenu.offsetx) - Math.PI;

					Board.bullet.setA(angle + ((spread * (i - 1)) / 2));
					// adding the bullet to the array list
					bullets.add(new Bullet(Board.bullet.getX(),
							Board.bullet.getY(), Board.bullet.getA()));
				}
				//reset the reload time 
				tmpLoad = reload;
			} else {
				tmpLoad -= 1;

			}
		}



	}

	// mouse control
	public static class Mouse extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				fire = true;
			}

		}

		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				fire = false;
			}

		}


	}
	public static ArrayList<Bullet> getBullets(){
		return bullets;
	}

	public static void removeBullet(int index){
		bullets.remove(index);
	}


}