import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BossTwo extends OverChar{
	private boolean phase1 = true;
	private int shotDelay = 200;
	private final int HEALTH = 600;
	public int shield=5;
	public BossTwo(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		health = -1;
		collisionDamage = 100;
	}

	@Override
	public void tick() {
		if (GGTop.mapState != GGTop.STATE.Realm){
			Handler.removeObject(this);
		}
		else{
			shotDelay--;
			if(phase1&&shotDelay<=0){
				shotDelay = 150 + (int)(Math.random()*100);
				double angle = Math.atan2(playerY-y, playerX-x);
				int seeking = (int)(Math.random()*2);
				for(int i = 0;i<50-seeking;i++)Handler.addEBullet(new EBullet(x,y,ID.Bullet,LoadImage("GGtop.png"),0.7/1360.0*MainMenu.width,angle+(Math.random()*Math.PI)-Math.PI/2,(1000+(Math.random()*7000))/1360.0*MainMenu.width,1,10000000));
				for(int i = 0;i<seeking;i++)Handler.addEBullet(new Boss2Tracking(x,y,ID.Bullet,LoadImage("sao_lost_song_logo_2_by_gunsli.png"),1/1360.0*MainMenu.width,angle+(Math.random()*Math.PI/2)-Math.PI/4,(4000+(Math.random()*5500))/1360.0*MainMenu.width,1,10000000,this));
			}else if(!phase1&&shotDelay<=0){
				shotDelay = 250 + (int)(Math.random()*200);
				double angle = Math.atan2(playerY-y, playerX-x);
				double lottery = Math.random()*2;
				if(lottery<0.9+health/HEALTH*0.1){
					for(int i = 0;i<150;i++)Handler.addEBullet(new EBullet(x,y,ID.Bullet,LoadImage("Boss1-2.png"),0.3/1360.0*MainMenu.width,(Math.random()*Math.PI*2),(1000+(Math.random()*7000))/1360.0*MainMenu.width,2,10000000));
				}else if(lottery<1){
					for(int i = 0;i<6;i++){
						Handler.addObject(new ShieldBullet(x,y,ID.Bullet,LoadImage("Boss1-2.png"),2/1360.0*MainMenu.width,((i+1)*Math.PI/3),5000/1360.0*MainMenu.width,10000000,1,400000,20));
						Handler.addObject(new ShieldBullet(x,y,ID.Bullet,LoadImage("Boss1-2.png"),2/1360.0*MainMenu.width,((i+1)*Math.PI/3),5000/1360.0*MainMenu.width,10000000,-1,250000,40));
					}
				}else if(lottery<Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))*1000/1500000+1){
					Handler.addObject(new Sploder(x,y,ID.Bullet,LoadImage("Sp clone (3).png"),0.5/1360.0*MainMenu.width,angle,(400+ Math.random()*1600)/1360.0*MainMenu.width,30,10000000,1000));
				}else{
					for(int i = 0;i<50;i++){
						Handler.addEBullet(new OrbitBullet(x,y,ID.Bullet,LoadImage("BGtop.png"),0.7/1360.0*MainMenu.width,(Math.random()*Math.PI*2),(1000+(Math.random()*7000))/1360.0*MainMenu.width,2,10000000,1));
						Handler.addEBullet(new OrbitBullet(x,y,ID.Bullet,LoadImage("BGtop.png"),0.7/1360.0*MainMenu.width,(Math.random()*Math.PI*2),(1000+(Math.random()*7000))/1360.0*MainMenu.width,2,10000000,-1));
					}
				}
			}
			if(phase1&&shield<=0){
				phase1=false;
				health = HEALTH;//	
			}
		}
	}



}
//