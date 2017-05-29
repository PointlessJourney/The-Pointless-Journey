import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BossTwo extends OverChar{
	private boolean phase1 = true;
	private int shotDelay = 200;
	private int shield=10;
	public BossTwo(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		health = -1;
		collisionDamage = 100;
	}

	@Override
	public void tick() {
		shotDelay--;
		if(phase1&&shotDelay<=0){
			double angle = Math.atan2(playerY-y, playerX-x);
			//for(int i = 0;i<10;i++)Handler.addEBullet(new EBullet(x,y,ID.Bullet,LoadImage("")));
		}
		
	}
	
	

}
