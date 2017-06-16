import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import com.pointless.journey.window.Game;
import com.pointless.journey.window.Window;

public class Handler {

	protected static LinkedList<OverChar> object = new LinkedList<OverChar>();
	protected static ArrayList<EBullet> eBullet = new ArrayList<EBullet>();

	public static void tick()
	{
		if(!Window.paused){
			for(int z = object.size()-1; z > -1; z--)

			{
				OverChar temp = object.get(z);	
				temp.tick();
			}
			for(int z = 0; z<eBullet.size();z++)eBullet.get(z).tick();
			Board.play();
			//Handler.addObject(new BossOne(OverChar.playerX,OverChar.playerY-500000,ID.Enemy,OverChar.LoadImage("Boss1-1.png"),4));
			//Handler.addObject(new Boss1Minion(OverChar.playerX,OverChar.playerY-500000,ID.Enemy,OverChar.LoadImage("Sp clone.png"),0.2,0.0));
		}
	}
	public static void render(Graphics g)
	{
		g.setColor(new Color(0x05040b));
		g.fillRect(-100,-100,MainMenu.width*2,MainMenu.width*2);
		object.get(1).render(g, 0);
		for(int z = object.size()-1; z > 1; z--)
		{
			object.get(z).render(g,0);
		}
		for(int z = 0;z<eBullet.size();z++)eBullet.get(z).render(g, 0);
		object.get(0).render(g,0);
		Board.paint(g);
	}
	public static synchronized void addObject(OverChar object)
	{
		Handler.object.add(object);
	}

	public static synchronized void removeObject(OverChar object)
	{
		Handler.object.remove(object);
	}
	public static synchronized void addEBullet(EBullet object)
	{
		eBullet.add(object);
	}
	public static synchronized void removeEBullet(EBullet object)
	{
		eBullet.remove(object);
	}
}
