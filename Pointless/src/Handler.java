import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	static LinkedList<OverChar> object = new LinkedList<OverChar>();
	
	public static void tick()
	{
		for(int z = object.size()-1; z > -1; z--)
		{
			OverChar temp = object.get(z);	
			temp.tick();
		}
	}
	public static void render(Graphics g)
	{
		g.setColor(new Color(0x05040b));
		g.fillRect(-100,-100,MainMenu.width*2,MainMenu.width*2);
		for(int z = object.size()-1; z > -1; z--)
		{
			object.get(z).render(g);
		}
	}
	public static void addObject(OverChar object)
	{
		Handler.object.add(object);
	}
	public static void removeObject(OverChar object)
	{
		Handler.object.remove(object);
	}
}