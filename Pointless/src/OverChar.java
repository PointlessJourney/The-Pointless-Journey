import java.awt.Graphics;

public abstract class OverChar
{
	public OverChar(int x, int y, ID id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
    protected int x, y, velX, velY;  
    protected ID id;
	public abstract void tick();
	public abstract void render(Graphics g);
    
    
    public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	public void setID(ID id)	{
		this.id = id;
	}
	public ID getID()
	{
		return id;
	}
	public void setVelX(int velX)
	{
		this.velX = velX;
	}
	public int getVelX()
	{
		return velX;
	}
	public void setVelY(int velY)
	{
		this.velY = velY;
	}
	public int getVelY()
	{
		return velY;
	}

}