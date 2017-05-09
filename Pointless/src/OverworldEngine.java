import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class OverworldEngine extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4112613234084496632L;
	public Thread thread;
	private boolean running = false;

	public OverworldEngine()
	{
		
		
		Handler.addObject(new GGTop(MainMenu.width/2+MainMenu.offsetx,MainMenu.height/2+MainMenu.offsety,ID.Map));
		Handler.addObject(new GGTop(MainMenu.width/2+MainMenu.offsetx,MainMenu.height/2+MainMenu.offsety,ID.Player));
		
		this.addKeyListener(new KeyIn());

	}

 	public synchronized void start()
	{
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

			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: "+ frames);
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
		g.fillRect(0, 0, MainMenu.width, MainMenu.height);
		
		Handler.render(g);
		g.dispose();
		bs.show();
	}
	
	//public static void go ()
	//{
	//	new OverworldEngine ();
	//}
}