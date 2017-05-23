import java.awt.image.BufferedImage;

public class BossOne extends OverChar{
	final int HEALTH=100;
	private double speed;
	private int delay = 2000;
	private double temp = 1360.0/MainMenu.width;
	public BossOne(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		System.out.println(x + " "+ y);
		health = 100;
		imageX = map.getWidth()/1280.0*MainMenu.width*150;
		imageY = map.getHeight()/1280.0*MainMenu.width*150;
	}

	@Override
	public void tick() {
		speed = 4500.0/temp;//-(2500.0/temp*health/HEALTH)+(1000.0/temp*(600-Math.sqrt((playerX-x)*(playerX-x)+(playerY-y)*(playerY-y)))/600.0);
		//x += (int)(speed *Math.cos(Math.atan2(playerY-y, playerX-x)));
		//y += (int)(speed *Math.sin(Math.atan2(playerY-y, playerX-x)));
		x += (int)(speed *Math.cos(Math.atan2(playerY-y, playerX-x)+Math.PI/4));
		y += (int)(speed *Math.sin(Math.atan2(playerY-y, playerX-x)+Math.PI/4));
		//System.out.println(x+" "+y+" "+speed);
		//System.out.println(Math.atan2(playerY-y, playerX-x)+Math.PI/2);
		//System.out.println(speed *Math.cos(Math.atan(playerY-y*1.0/playerX-x*1.0)));
		if(delay ==0){
			delay = (int)(Math.random()*3000.0)+(int)(3000.0*health/HEALTH);
			System.out.println(delay);
			for(int i = 10-(int)(6.0*health/HEALTH);i>0;i--)System.out.println(i);;
		}
		delay--;
	}
	
	

}
