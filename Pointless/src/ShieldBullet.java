import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ShieldBullet extends EBullet{
	
	private double orbit;
	private int direction;
	public ShieldBullet(int x, int y, ID id, BufferedImage map, double size, double angle, double speed, double range, int direction, double orbit, int health) {
		super(x, y, id, map, size, angle, speed, 0, range);
		this.orbit = orbit;
		this.direction=direction;
		this.health=health;
		super.tick();
	}
	
	@Override
	public void tick(){
		if(Math.sqrt(((ox-x)/1000)*((ox-x)/1000)+((oy-y)/1000)*((oy-y)/1000))*1000<orbit)angle = Math.atan2(oy-y, ox-x)+Math.PI;
		super.tick();
		if(health<=0){
			Handler.removeObject(this);
			return;
		}
		angle = Math.atan2(oy-y, ox-x)+direction*Math.PI/4;
		super.tick();
	}
	@Override
	public void render(Graphics g,double angle){
		//this.angle=this.angle-Math.PI/4;
		if(direction==-1){
			this.angle += Math.PI/4;
		}else this.angle+= 3*Math.PI/4;
		super.render(g, this.angle);
	}
}
