import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Boss2Tracking extends EBullet{

	private BossTwo boss;
	private int delay = 100;
	public Boss2Tracking(int x, int y, ID id, BufferedImage map, double size, double angle, double speed, int damage, double range, BossTwo boss) {
		super(x, y, id, map, size, angle, speed, damage, range);
		this.boss = boss;
	}

	@Override
	public void tick() {
		double tempAngle = Math.atan2(playerY-y, playerX-x);
		if(angle>0){
			if(angle>Math.PI)angle-=Math.PI*2;
			if(tempAngle<angle&&angle-Math.PI<tempAngle){
				angle -= Math.PI/60;
			}else angle += Math.PI/60;
		}else{
			if(angle<-Math.PI)angle+=Math.PI*2;
			if(tempAngle>angle&&angle+Math.PI>tempAngle){
				angle += Math.PI/60;
			}else angle -= Math.PI/60;
		}
		ArrayList<Bullet> temp = Board.getBullets();
		for(int i = 0;i<temp.size();i++){
			Bullet tempB = temp.get(i);
			if(this.Overlap((int)tempB.getX(), (int)tempB.getY())){
				x += (int)(50000 *Math.cos(tempB.getA()))/1360.0*MainMenu.width;
				y += (int)(50000 *Math.sin(tempB.getA()))/1360.0*MainMenu.width;
				Board.removeBullet(i);
			}
		}
		x += (int)(speed *Math.cos(angle));
		y += (int)(speed *Math.sin(angle));
		if(delay<0&&boss.Overlap(x, y)){
			boss.shield--;
			System.out.println(boss.shield);
			Handler.removeEBullet(this);
		}
		delay--;
	}
}
