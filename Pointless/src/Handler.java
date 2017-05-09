import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	static LinkedList<OverChar> object = new LinkedList<OverChar>();
	
	public static void tick()
	{
		for(int z = 0; z < object.size(); z++)
		{

			object.get(z).tick();
		}
	}
	public static void render(Graphics g)
	{
		for(int z = 0; z < object.size(); z++)
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