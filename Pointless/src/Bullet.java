import java.awt.Graphics;

public class Bullet {

	private double x;
	private double y;
	
	public Bullet (double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void tick (){
		y-=10;
		
	}
	public void draw(Graphics g)
	{
		//g.drawImage();
	}
	
}
