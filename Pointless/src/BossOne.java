import java.awt.image.BufferedImage;

public class BossOne extends OverChar{
	final int HEALTH = 300;
	private double speed;
	private int delay = 500;
	public static boolean dead1 = false;
	private double temp = 1360.0/MainMenu.width;
	private boolean phase1=true;
	public BossOne(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		//System.out.println(x + " "+ y);
		health = 300;
		collisionDamage=5;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
	}

	@Override
	public void tick() {
		if (GGTop.mapState != GGTop.STATE.Stone){
			Handler.removeObject(this);
		}
		else{
			speed = (3500.0/temp-(2000.0/temp*health/HEALTH)+(4.5/temp*(Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))))/1360.0*MainMenu.width);
			//System.out.println(2500.0/temp);
			//System.out.println(2500.0/temp*health/HEALTH);
			//System.out.println(0.05/temp*(Math.sqrt(((playerX-x)*(playerX-x))+((playerY-y)*(playerY-y)))));
			//System.out.println((playerX-x)*(playerX-x)+(playerY-y)*(playerY-y));

			//x += (int)(speed *Math.cos(Math.atan2(playerY-y, playerX-x)));
			//y += (int)(speed *Math.sin(Math.atan2(playerY-y, playerX-x)));
			x += (int)(speed *Math.cos(Math.atan2(playerY-y, playerX-x)+Math.PI/4));
			y += (int)(speed *Math.sin(Math.atan2(playerY-y, playerX-x)+Math.PI/4));
			//System.out.println(x+" "+y+" "+speed);
			//System.out.println(Math.atan2(playerY-y, playerX-x)+Math.PI/2);
			//System.out.println(speed *Math.cos(Math.atan(playerY-y*1.0/playerX-x*1.0)));
			if(delay ==0){
				delay = 350+(int)(1000.0*health/HEALTH);
				System.out.println("Health: "+health);
				for(int i = 10-(int)(6.0*health/HEALTH);i>0;i--)Handler.addObject(new Boss1Minion((int)(Math.random()*1000-500+x),(int)(Math.random()*200-100+y),ID.Enemy,LoadImage("BGtop clone.png"),3.5,health/HEALTH));
			}
			delay--;
			if(health==150&&phase1){
				map = OverChar.LoadImage("Boss1-2.png");
				for(int i = 15;i>0;i--)Handler.addObject(new Boss1Minion((int)(Math.random()*1000-500+x),(int)(Math.random()*200-100+y),ID.Enemy,LoadImage("BGTop clone.png"),3.5,health/HEALTH));
				phase1=false;
			}
			if(health<=0){
				dead1 = true;
				Handler.removeObject(this);
				
			}
		}
		if(health<=0){
			dead1 = true;
			Handler.removeObject(this);
			
			}
	}



}
