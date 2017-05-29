import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EBullet extends OverChar{

	double angle;
	double speed;
	
	public EBullet(int x, int y, ID id, BufferedImage map, double size, double angle, double speed, int damage) {
		super(x, y, id, map, size);
		this.angle=angle;
		this.speed=speed;
		collisionDamage=damage;
	}

	@Override
	public void tick() {
		x += (int)(speed *Math.cos(angle));
		y += (int)(speed *Math.sin(angle));
	}
	
	@Override
	public void render(Graphics g,double angle){
		super.render(g, this.angle);
	}

}
