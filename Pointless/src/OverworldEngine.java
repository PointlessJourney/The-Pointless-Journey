/*
*
*												READ THIS
*
*						you will see a lot of this scattered around the code:
*						(int)(100.0/1360.0*MainMenu.width)
*						this is used for resizing purposes
*						here's a breakdown:
*						
*						(int)
*						this casts the entire equation as an int, it's not always necessary but is important since the
*						equation returns a double
*
*						100.0/1360.0
*						this returns a percentage, the first number is the one you change around to move stuff
*						the second number is Your screen width, which will print out every time you start the program
*					
*						MainMenu.width
*						this multiplies the percentage by the width of whatever machine you're running it on, this
*						will resize everything according to the resolution used
*
*/
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class OverworldEngine extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4112613234084496632L;
	public static final int width = 1280, height = 720;
	public Thread thread;
	private boolean running = false;

	public OverworldEngine()
	{
		
		OverChar.playerSpeed=10000.0/1360*MainMenu.width;
		

		addMouseListener(new Board.Mouse());
		this.addKeyListener(new KeyIn());


		Board.init();


	}
	

 	public synchronized void start()
	{
 		Handler.addObject(new GGTop(MainMenu.width/2+MainMenu.offsetx,MainMenu.height/2+MainMenu.offsety,ID.Player));
		Handler.addObject(new GGTop((int)(30000.0/1360*MainMenu.width),(int)(-871000.0/1360*MainMenu.width),ID.Map));
		Handler.addObject(new GGTop((int)(30000.0/1360*MainMenu.width),(int)(-871000.0/1360*MainMenu.width),ID.HUD));
 		thread = new Thread(this);
		thread.start();
		running = true;
		this.requestFocus();
		

	}

	public synchronized void stop ()
	{
		try
		{
			thread.join();
			running = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public void run()
	{
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: "+ frames);
				frames = 0;
			}
		}
		stop();

	}
	
	private void tick()
	{
		Handler.tick();
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		Handler.render(g);
		g.dispose();
		bs.show();
	}
	
	//public static void go ()
	//{
	//	new OverworldEngine ();
	//}
}