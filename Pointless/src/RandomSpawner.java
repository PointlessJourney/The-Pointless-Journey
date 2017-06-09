import java.awt.image.BufferedImage;

public class RandomSpawner extends OverChar{
	private double[] range=new double[2];
	private double speed;
	private int stage = 0;
	private int randomNum = 0;
	public static boolean mode = false;
	public static boolean mode1 = true;
	public static boolean mode2 = false;

	private boolean seeking = false;
	public static double rage = 0;
	public RandomSpawner(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		speed = 12000;
		health = 1;
		collisionDamage = 10;
		if (rage >=6)
		{
			speed = (speed + (Math.random() * 1000));
			//System.out.print("Speed is up" + speed);
		}
		if (rage >=12)
		{
			speed = (speed + ((OverChar.playerHealth) * 100));

			//System.out.print("Health is up" + health);
		}
		if (mode == true)
		{
			collisionDamage = 7;
		}
		if (mode1 == true)
		{
			collisionDamage = 5;
			speed = 8000;
		}
		if (mode2 == true)
		{
			health = 8;
		}
		else
		{
			speed = 12000;
			health = 1;
			collisionDamage = 15;
			if (rage >=6)
			{
				speed = (speed + (Math.random() * 1000));
				//System.out.print("Speed is up" + speed);
			}
			if (rage >=12)
			{
				speed = (speed + ((OverChar.playerHealth) * 100));

				//System.out.print("Health is up" + health);
			}
		}

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
			rage = rage + 1;

		}
	}		
}	

