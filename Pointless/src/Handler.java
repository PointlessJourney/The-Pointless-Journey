import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<OverChar> object = new LinkedList<OverChar>();
	
	public void tick()
	{
		for(int z = 0; z < object.size(); z++)
		{
			OverChar temp = object.get(z);	
			temp.tick();
		}
	}
	public void render(Graphics g)
	{
		for(int z = 0; z < object.size(); z++)
		{
			OverChar temp = object.get(z);
			temp.render(g);
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