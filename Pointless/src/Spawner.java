import java.awt.image.BufferedImage;

public class Spawner extends OverChar{

	boolean spawn = true;
	int delay = 1;
	boolean alive = true;
	public static int amount = 0;
	public Spawner(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub

		health = 54;
		amount++;
		collisionDamage = 1;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(GGTop.mapState != GGTop.STATE.Field)
		{
			Handler.removeObject(this);
		}
		if (alive)
		{
			if (spawn)
			{
				delay--;
				if (delay == 0)
				{
					Handler.addObject(new Boss1Minion(x,y,ID.Enemy,LoadImage("BGTop clone.png"),3.5,1.0));
					delay = 400;
				}
			}		
			if(health== 36){
				map = OverChar.LoadImage("SP clone (1).png");			
			}

			if(health==18){
				map = OverChar.LoadImage("SP clone (2).png");			
			}

			if(health<=0){
				spawn = false;
				amount--;
				alive = false;
				map = OverChar.LoadImage("SP clone (3).png");
			}


		}
	}

}

