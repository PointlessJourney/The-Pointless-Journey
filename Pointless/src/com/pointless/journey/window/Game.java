package com.pointless.journey.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.KeyInput;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.objects.Block;
import com.pointless.journey.objects.Player;
import com.pointless.journey.objects.Speed;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6915988236045308280L;

	private boolean running = false;
	private Thread thread; //instantiate new Thread
	
	public static int WIDTH, HEIGHT;
	
	private BufferedImage level = null;//use to load level
	
	Random rand = new Random();//object of type Random, use to get Random Numbers

	//Object
	Handler handler;
	GameObject object;
	Camera cam;
	
	//initializer
	private void init(){
		
		//ended here, created the base platform layer, Follow player gravity
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		//loading level
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("LevelOne.png");//loading the level
		
		handler = new Handler();
		
		cam = new Camera(0, 0);//camera for side scroller
		
		LoadImageLevel(level);
		
		//handler.addObject(new Player(100, 600, handler, ObjectId.Player));
		
		//handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));//for key input
		
	}
	
	public Game(){
		
	}
	
	public synchronized void start(){

		//if thread is already running, this will make sure tht a new thread is not recreated
		if(running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start(); //start thread

	}

	public void run(){
		init();
		this.requestFocus();
		System.out.println("Thread has begun");

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while (running){
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			
			render();
			frames++;

			if(System.currentTimeMillis() - timer  > 1000){
					
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
				
			}//if
		}//while

	}
	
	public void tick(){
		
		handler.tick();//this will tick all the objects
		
		for (int i = 0; i < handler.object.size(); i++){
			
			if(handler.object.get(i).getId() == ObjectId.Player){
				cam.tick(handler.object.get(i));
			}//if
			
		}//for
		
	}//tick
	
	public void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		//////////////////////////////////
		//Draw here
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(), cam.getY()); //Begin of Cam
		
		handler.render(g);//render all objects
		
		g2d.translate(-cam.getX(), -cam.getY()); //End of Cam
		
		//////////////////////////////////
		g.dispose();
		bs.show();
		
		
	}
	
	private void LoadImageLevel(BufferedImage image){
		
		int w = image.getWidth();
		int h = image.getHeight();
		
		System.out.println("Width, Height " + w + " " + h);
		
		for (int xx = 0; xx < h; xx++){
			
			for (int yy = 0; yy < w; yy++){
				
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 && blue == 255) handler.addObject(new Block(xx*32, yy*32, ObjectId.Block));
				if(red == 0 && green == 0 && blue == 255) handler.addObject(new Player(xx*32, yy*32, handler, ObjectId.Player));
				//if(red == 0 && green == 255 && blue == 0) handler.addObject(new Speed(xx*32, yy*32, handler, ObjectId.Speed));
				
			}//for
			
		}//for
		
	}

	public static void main (String args[]){

		new Window(1280, 720, "PointlessJourney", new Game());

	}

}
