import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	protected static LinkedList<OverChar> object = new LinkedList<OverChar>();
	
	public static void tick()
	{
		for(int z = object.size()-1; z > -1; z--)
		{
			OverChar temp = object.get(z);	
			temp.tick();
		}
		Board.play();
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
}
