import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EBullet extends OverChar{

	double angle;
	double speed;
	double range;
	double ox;
	double oy;
	
	public EBullet(int x, int y, ID id, BufferedImage map, double size, double angle, double speed, int damage, double range) {
		super(x, y, id, map, size);
		this.angle=angle;
		this.speed=speed;
		collisionDamage=damage;
		this.range = range;
		ox = x;
		oy = y;
	}

	@Override
	public void tick() {
		x += (int)(speed *Math.cos(angle));
		y += (int)(speed *Math.sin(angle));
		if(Math.sqrt(((ox-x)/1000)*((ox-x)/1000)+((oy-y)/1000)*((oy-y)/1000))>=range)Handler.removeEBullet(this);
	}
	
	@Override
	public void render(Graphics g,double angle){
		super.render(g, this.angle);
	}

}
