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
	private Handler handler;

	public OverworldEngine()
	{
		handler = new Handler();
		handler.addObject(new GGTop(width/2-64,height/2-64,ID.Player));
		handler.addObject(new GGTop(width/2-64,height/2-64,ID.Player2));

		this.addKeyListener(new KeyIn(handler));

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
		handler.tick();
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
		
		handler.render(g);
		g.dispose();
		bs.show();
	}
	
	//public static void go ()
	//{
	//	new OverworldEngine ();
	//}
}