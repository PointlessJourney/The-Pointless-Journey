import java.awt.image.BufferedImage;

public class NGSpawner extends OverChar{

	public boolean spawn = true;
	boolean alive = true;
public static int amount = 0;
	int delay = 0;
	int ranX;
	int ranY;
	public NGSpawner(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		// TODO Auto-generated constructor stub
		health = 100;
		collisionDamage = 0;
		amount++;
		imageX = map.getWidth()*size/1280.0*MainMenu.width*150;
		imageY = map.getHeight()*size/1280.0*MainMenu.width*150;
	}

	@Override
	public void tick() {
		if(GGTop.mapState != GGTop.STATE.Cave)
		{
			Handler.removeObject(this);
		}
		if (alive)
		{
			if (spawn)
			{
				if(delay == 0)
					//
				{	
					delay = (int)(Math.random() * 1200.0);
					System.out.println("delay" + delay);
					//96x96
					//for (int w = 0; w > 10; w++)
					//{
					ranX = (int) (Math.random() * MainMenu.width -96)*1000;
					ranY = (int) (Math.random() * MainMenu.height -96)*1000;

					if (RandomSpawner.rage <=9)
					{
						Handler.addObject(new RandomSpawner(ranX,ranY,ID.Enemy,LoadImage("NGtop clone clone.gif") ,2.0));
						System.out.println("Spawned 0");
					}
					else if (RandomSpawner.rage >=12)
					{
						Handler.addObject(new RandomSpawner(ranX,ranY,ID.Enemy,LoadImage("NGtopRage.png") ,2.0));
						System.out.println("Spawned 10");
					}
					//Handler.addObject(new RandomSpawner(ranX,ranY,ID.Enemy,LoadImage("RandomMinion.png") ,2.0));
					//System.out.println("Spawned");

				}
				else
				{
					delay--;
				}
				//}
			}		
			if(health== health/2){
				map = OverChar.LoadImage("SP clone (1).png");			
			}

			if(health==health/4){
				map = OverChar.LoadImage("SP clone (2).png");			
			}

			if(health<= 0){
				spawn = false;
				collisionDamage = 0;
				amount--;
				alive = false;
				map = OverChar.LoadImage("SP clone (3).png");			
			}

		}
	}


}
