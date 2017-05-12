package com.pointless.journey.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.KeyInput;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.objects.Player;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6915988236045308280L;

	private boolean running = false;
	private Thread thread; //instantiate new Thread
	
	public static int WIDTH, HEIGHT;
	
	Random rand = new Random();//object of type Random, use to get Random Numbers

	GameObject object;
	
	//Object
	Handler handler;
	
	//initializer
	private void init(){
		//ended here, created the base platform layer, Follow player gravity
		WIDTH = getWidth();
		HEIGHT = getHeight();
		handler = new Handler();
		
		handler.addObject(new Player(100, 600, handler, ObjectId.Player));
		
		handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
		
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
		
	}
	
	public void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		//Draw here
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		handler.render(g);//render all objects
		
		//////////////////////////////////
		g.dispose();
		bs.show();
		
		
	}

	public static void main (String args[]){

		new Window(1280, 720, "PointlessJourney", new Game());

	}

}
