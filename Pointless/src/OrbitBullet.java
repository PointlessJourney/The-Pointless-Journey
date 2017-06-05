import java.awt.image.BufferedImage;

public class OrbitBullet extends EBullet{
	
	private int direction;
	public OrbitBullet(int x, int y, ID id, BufferedImage map, double size, double angle, double speed, int damage, double range, int direction) {
		super(x, y, id, map, size, angle, speed, damage, range);
		this.direction=direction;
	}
	
	@Override
	public void tick(){
		super.tick();
		angle = Math.atan2(oy-y, ox-x)+direction*2*Math.PI/3;
	}
}
