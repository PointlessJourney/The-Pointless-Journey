package testshoot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Hero {

   private double x, y, a; // x,y and angle
   private int w, h, tmpLoad; // width and height and reloading counter (for
                        // shooting)

   private ArrayList bullets; // this will hold  bullets 


   // constructor
   public Hero(double x, double y, double a, int w, int h) {

      this.x = x;
      this.y = y;
      this.a = a;
      this.w = w;
      this.h = h;

      bullets = new ArrayList();
      tmpLoad = 0;
      


   }
   
   // returning all the necessary value of this class

  

   public double getX() {
      return x;
   }

   public double getY() {
      return y;
   }

   public double getA() {
      return a;
   }

   public int getW() {
	   
      return w;
   }

   public int getH() {
      return h;
   }

   public ArrayList getBullets() {
      return bullets;
   }

   // setting the values
   public void setA(double tmpAngle) {

      a = Math.toRadians(tmpAngle);
   }

   public void setX(double x) {
      this.x = x;
   }

   public void setY(double y) {
      this.y = y;
   }


   /*
    * firing load = how much time you wait between 2 bullets number = how many
    * bullet you shot in a single shot spread = distance between 2 bullets
    */
   public void fire(int load, int number, int spread) {
      
      // if reloading time is done
      if (tmpLoad == 0) { 

         for (int i = 0; i < number; i++) {
            // setting the bullet
            Board.bullet.setX(x + w);
            Board.bullet.setY(y + h / 2);
            Board.bullet.setA(a + ((spread * (i - 1)) / 2));
            // adding the bullet to the array list
            bullets.add(new Bullet(Board.bullet.getX(),
                  Board.bullet.getY(), Board.bullet.getA()));
         }
         //reset the reload time 
         tmpLoad = load;
      } else {
         tmpLoad -= 1;
         
      }

   }
}
