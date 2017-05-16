
public class Bullet {

	   private double x, y, a; // x,y and angle
	   private int w, h; //width and height 
	   // constructor
	   public Bullet(double x, double y, double a) {

	      this.x = x;
	      this.y = y;
	      this.a = a;
	     
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


	   // setting the values
	   public void setA(double aa) {

	      this.a = aa;
	   }

	   public void setX(double x) {
	      this.x = x;
	   }

	   public void setY(double y) {
	      this.y = y;
	   }

	   // move toward the angle
	   // //forward
	   public void moveForward() {
	      x += Math.cos(a)*5;
	      y += Math.sin(a)*5;
	   }

	}