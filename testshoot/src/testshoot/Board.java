package testshoot;

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

public class Board extends JPanel implements Runnable {

   public static Bullet bullet;

   private Thread loop; // the loop
   private Hero hero;
   private ArrayList bullets;
   private int  sx, sy, reload, numToShoot, spread, bWidth,
         bHeight;
   private boolean moveForward, canForward, canBackward, moveBackward, left,
         right, fire, special;
   double angle, check, tmpAngle, total;
   // constructor
   public Board() {
      init();
      addMouseListener(new Mouse());
      setFocusable(true);
      setBackground(new Color(0, 0, 0));
      setDoubleBuffered(true);
      setFocusable(true);
   }

   // initialisation
   private void init() {
      hero = new Hero(640, 360, 0, 25, 25);
      tmpAngle = 0;
      special = fire = left = right = moveForward = moveBackward = false;
      canForward = canBackward = true;
      sx = sy = 2;

      bullet = new Bullet(0, 0, 0);
      bullets = hero.getBullets();
      reload = 30;
      numToShoot = 1;
      spread = 0;
      loop = new Thread(this);
      loop.start();
   }
   public void paint(Graphics g) {
      super.paint(g);

      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      AffineTransform old = g2d.getTransform();
      int centerX = 652;
		int centerY = 372;
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;	
		 angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI/2;
		 total = -Math.toDegrees(Math.atan2( ((mouseX- centerX)), ( (mouseY-centerY))))+100;
		((Graphics2D)g).rotate(angle, centerX, centerY);
		AffineTransform transform = g2d.getTransform();
		g.setColor(Color.RED);
		g2d.setTransform(transform);

      // draw the image
      g2d.setColor(Color.RED);

      g2d.fillRect((int) hero.getX(), (int) hero.getY(),
            hero.getW(), hero.getH());
      g2d.setTransform(old);

      // drawing the bullets
      ArrayList bullets = hero.getBullets();
      for (int i = 0; i < bullets.size(); i++) {
         Bullet tmpB = (Bullet) bullets.get(i);
                        //playing with bullet colors
         if (i % 2 == 0) {
            g2d.setColor(Color.RED);
         } else {
            g2d.setColor(Color.WHITE);
         } 
         g2d.fillRect( (int) tmpB.getX()-15 , (int) tmpB.getY(), 5,
               5);
      }

   }

   public void play() {

      // moving bullets
      ArrayList tmpBs = hero.getBullets();
      for (int i = 0; i < tmpBs.size(); i++) {
         Bullet tmpB = (Bullet) tmpBs.get(i);
         tmpB.moveForward();
      if (tmpB.getX() > 1200 || tmpB.getX() < 0
               || tmpB.getY() > 720 || tmpB.getY() < 0) {
            tmpBs.remove(i);
         }

      }

      // check if shooting
      if (fire) {
         hero.fire(reload, numToShoot, spread);
      }
    

      // changing the hero angle
     tmpAngle=total;
      // setting the hero angle
      hero.setA(tmpAngle);  

   }

   // mouse control
   public class Mouse extends MouseAdapter {

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

   // the wors game loop ever
   @Override
   public void run() {

      while (true) {
         repaint();
         play();
         try {
            Thread.sleep(5);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      }

   }

}