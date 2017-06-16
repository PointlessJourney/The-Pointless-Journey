import java.awt.image.BufferedImage;

public class Sploder extends EBullet{
	private int delay;
	public Sploder(int x, int y, ID id, BufferedImage map, double size, double angle, double speed, int damage, double range, int delay) {
		super(x, y, id, map, size, angle, speed, damage, range);
		this.delay=delay;
		health = 50;
	}
	
	@Override
	public void tick(){
		angle = Math.atan2(playerY-y, playerX-x);
		delay--;
		super.tick();
		if(delay<=0){
			for(int i = 0;i<200;i++)Handler.addEBullet(new EBullet(x,y,ID.Bullet,LoadImage("Boss1-1.png"),0.3/1360.0*MainMenu.width,(Math.random()*Math.PI*2),(1000+(Math.random()*7000))/1360.0*MainMenu.width,1,10000000));
			Handler.removeEBullet(this);
		}
		if(health<=0){
			//for(int i = 0;i<50;i++)Handler.addEBullet(new EBullet(x,y,ID.Bullet,LoadImage("Boss1-1.png"),0.3/1360.0*MainMenu.width,(Math.random()*Math.PI*2),(1000+(Math.random()*7000))/1360.0*MainMenu.width,1,10000000));
			Handler.removeObject(this);
		}
	}

}
