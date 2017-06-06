import java.awt.image.BufferedImage;

public class ExtraAi extends OverChar{
	private double[] range=new double[2];
	private double speed;
	private int stage = 0;
public static int anger = 0;
	private boolean seeking = false;
	
	public ExtraAi(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		speed = 600;
		health = 25;
		collisionDamage = 2;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		double angle = Math.atan2(playerY-y, playerX-x);
		if(seeking||Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))*1000>range[stage]){

			x += (int)(speed *Math.cos(angle));
			y += (int)(speed *Math.sin(angle));		
		}else if(stage==0){
			stage=1;
		}
		else seeking = true;
		if(health<=0)
		{
			Handler.removeObject(this);
			anger = anger + 1;
			
		}
	}		
}	

