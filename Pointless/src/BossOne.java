import java.awt.image.BufferedImage;

public class BossOne extends OverChar{
	final int HEALTH=400;
	private double speed;
	private int delay = 500;
	private double temp = 1360.0/MainMenu.width;
	public BossOne(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		//System.out.println(x + " "+ y);
		health = 400;
		collisionDamage=5;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
	}

	@Override
	public void tick() {
		speed = 3500.0/temp-(2500.0/temp*health/HEALTH)+(3.0/temp*(Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))));
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
			delay = (int)(Math.random()*1000.0)+(int)(1000.0*health/HEALTH);
			System.out.println("Health: "+health);
			for(int i = 10-(int)(6.0*health/HEALTH);i>0;i--)Handler.addObject(new Boss1Minion((int)(Math.random()*1000-500+x),(int)(Math.random()*200-100+y),ID.Enemy,LoadImage("BGtop.png"),3.5));
		}
		delay--;
		if(health<=0)Handler.removeObject(this);
	}
	
	

}
