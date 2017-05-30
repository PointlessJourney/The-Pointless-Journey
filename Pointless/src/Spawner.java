import java.awt.image.BufferedImage;

public class Spawner extends OverChar{

	boolean spawn = true;
	public Spawner(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		health = 54;
		collisionDamage = 0;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if (spawn)
		{
		
			
		}		
		if(health== 36){
			map = OverChar.LoadImage("SP clone (1).png");			
		}
		
		if(health==18){
			map = OverChar.LoadImage("SP clone (2).png");			
		}
		
		if(health<=0){
			map = OverChar.LoadImage("SP clone (3).png");			
		}
		
	
		
	}

}

