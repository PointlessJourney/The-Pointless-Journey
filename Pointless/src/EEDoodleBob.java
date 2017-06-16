import java.awt.image.BufferedImage;

public class EEDoodleBob extends OverChar{
	private double[] range=new double[2];
	private double speed;
	private int stage = 0;
	private int randomNum = 0;
	public static boolean mode = false;
	public static boolean mode1 = true;
	public static boolean mode2 = false;

	private boolean seeking = false;
	public static double rage = 0;
	public EEDoodleBob(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		speed = 8000;
		health = 25;
		collisionDamage = 0;
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
			

		}
	}		
}	

