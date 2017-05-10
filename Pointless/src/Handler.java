import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<OverChar> object = new LinkedList<OverChar>();
	
	public void tick()
	{
		for(int z = object.size()-1; z > -1; z--)
		{
			OverChar temp = object.get(z);	
			temp.tick();
		}
	}
	public void render(Graphics g)
	{
		g.setColor(new Color(0x05040b));
		g.fillRect(-100,-100,MainMenu.width*2,MainMenu.width*2);
		for(int z = object.size()-1; z > -1; z--)
		{
			object.get(z).render(g);
		}
	}
	public void addObject(OverChar object)
	{
		this.object.add(object);
	}
	public void removeObject(OverChar object)
	{
		this.object.remove(object);
	}
}