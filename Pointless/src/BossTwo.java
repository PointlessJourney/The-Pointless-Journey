import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BossTwo extends OverChar{
	private boolean phase1 = true;
	private int shotDelay = 200;
	public int shield=10;
	public BossTwo(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		health = -1;
		collisionDamage = 100;
	}

	@Override
	public void tick() {
		shotDelay--;
		if(phase1&&shotDelay<=0){
			shotDelay = 300 + (int)(Math.random()*300);
			double angle = Math.atan2(playerY-y, playerX-x);
			int seeking = (int)(Math.random()*4)+1;
			for(int i = 0;i<40-seeking;i++)Handler.addEBullet(new EBullet(x,y,ID.Bullet,LoadImage("Boss1-1.png"),0.5,angle+(Math.random()*Math.PI)-Math.PI/2,1000+(Math.random()*7000),3));
			for(int i = 0;i<seeking;i++)Handler.addEBullet(new Boss2Tracking(x,y,ID.Bullet,LoadImage("Boss1-2.png"),0.5,angle+(Math.random()*Math.PI/2)-Math.PI/4,3500+(Math.random()*5500),3, this));
		}
		
	}
	
	

}
