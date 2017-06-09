import java.awt.image.BufferedImage;

public class BossEE extends OverChar{
	final int HEALTH=600;
	public static int currentHp;
	private double speed;
	private int delay = 500;
	private double temp = 1360.0/MainMenu.width;
	private int direction;
	private int mod;
	private double mod2;
	//static int size = 3;
	int num;

	public BossEE(int x, int y, ID id, BufferedImage map, double size, int num, boolean direction,int mod) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		//System.out.println(x + " "+ y);
		if(direction){
			this.direction= 1;
		}else this.direction=-1;
		this.num=num;
		this.mod=mod;
		this.mod2=mod2;
		health = 10;
		collisionDamage=1;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
		mod2 =(Math.random()*0.4)+0.8;
	}

	@Override
	public void tick() {
		speed = mod+(3500.0/temp-(2000.0/temp*health/HEALTH)+(4.5/temp*(Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))))/1360.0*MainMenu.width);
		x += (int)(speed *Math.cos(Math.atan2(playerY-y, playerX-x)+Math.PI/4*direction*mod2));
		y += (int)(speed *Math.sin(Math.atan2(playerY-y, playerX-x)+Math.PI/4*direction*mod2));

		delay--;

		if(health<=0)
		{
			num = num*num;			
			size = size/2;
			Handler.removeObject(this);
			boolean direction = true;
			for (int x =0; x<num;x++)
			{
				direction = !direction;
			Handler.addObject(new BossEE(this.x,y,ID.Enemy,LoadImage("Booooo.png"),size,num,direction,(int)(Math.random()*3000)));
			}
			
		}
	}



}