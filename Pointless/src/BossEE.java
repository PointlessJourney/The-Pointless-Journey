import java.awt.image.BufferedImage;

public class BossEE extends OverChar{
	final int HEALTH=600;
	public static int currentHp;
	private double speed;
	private int delay = 500;
	private double temp = 1360.0/MainMenu.width;

	public BossEE(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		//System.out.println(x + " "+ y);
		health = 600;
		collisionDamage=1;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
	}

	@Override
	public void tick() {
		
		speed = (3500.0/temp-(2000.0/temp*health/HEALTH)+(4.5/temp*(Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))))/1360.0*MainMenu.width);
		x += (int)(speed *Math.cos(Math.atan2(playerY-y, playerX-x)+Math.PI/4));
		y += (int)(speed *Math.sin(Math.atan2(playerY-y, playerX-x)+Math.PI/4));
		
		if(delay ==0){
			delay = 350+(int)(1000.0*health/HEALTH);
			System.out.println("Health: "+health);
			for(int i = 10-(int)(6.0*health/HEALTH);i>0;i--)Handler.addObject(new Boss1Minion((int)(Math.random()*1000-500+x),(int)(Math.random()*200-100+y),ID.Enemy,LoadImage("BGtop.png"),3.5,health/HEALTH));
		}
		delay--;
		
		if(health<=0)
			{
			Handler.removeObject(this);
			
			}
	}
	
	

}
