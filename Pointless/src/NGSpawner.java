import java.awt.image.BufferedImage;

public class NGSpawner extends OverChar{

	boolean spawn = true;
	int delay = 1;
	public NGSpawner(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		health = 500;
		collisionDamage = 25;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
	}

	@Override
	public void tick() {
		if (spawn)
		{
			delay--;
			if (delay == 0)
			{
				Handler.addObject(new RandomSpawner(x,y,ID.Enemy,LoadImage("NGtop.png"),3.5));
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
			map = OverChar.LoadImage("SP clone (3).png");			
		}
		
	}

}
