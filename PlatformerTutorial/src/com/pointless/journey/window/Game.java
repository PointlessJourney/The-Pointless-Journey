package com.pointless.journey.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.KeyInput;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.objects.Block;
import com.pointless.journey.objects.Player;
import com.pointless.journey.objects.SwitchBlock;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6915988236045308280L;

	private boolean running = false;
	public static boolean initLevel = true;
	private Thread thread; //instantiate new Thread

	public static int WIDTH, HEIGHT;

	private BufferedImage level = null;//use to load level
	private BufferedImage hud = null;
	private SwitchBlock sBlock;
	private Player player;
	
	public static int red;
	public static int green;
	public static int blue;
	public static int xOfPlayer = 30;
	
	public static int life = 0;

	Random rand = new Random();//object of type Random, use to get Random Numbers

	//Object
	Handler Handler;
	GameObject object;
	Camera cam;

	//initializer
	private void init(){

		//ended here, created the base platform layer, Follow player gravity
		WIDTH = getWidth();
		HEIGHT = getHeight();

		//loading level
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/LevelOne.png");//loading the level
		hud = loader.loadImage("/SideHud.png");    

		Handler = new Handler();

		cam = new Camera(0, 0);//camera for side scroller

		LoadImageLevel(level);


		//Handler.addObject(new Player(100, 600, Handler, ObjectId.Player));

		//Handler.createLevel();

		this.addKeyListener(new KeyInput());//for key input


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

		Handler.tick();//this will tick all the objects

		for (int i = 0; i < Handler.object.size(); i++){

			if(Handler.object.get(i).getId() == ObjectId.Player){
				cam.tick(Handler.object.get(i));
			}//if

		}//for

	}//tick

	public void render(){

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){

			this.createBufferStrategy(3);
			return;

		}
		
		//life = 280;
		

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		//////////////////////////////////
		//Draw here

		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		g2d.translate(cam.getX(), cam.getY()); //Begin of Cam

		Handler.render(g);//render all objects
		g2d.drawImage(hud, -(int)cam.getX(), -(int)cam.getY(), null);
		
		g2d.setColor(Color.black);
		
		g2d.fillRect(-(int)cam.getX() + 865, -(int)cam.getY() + 100, life, 10);
		
		//Mini Map
		g2d.drawLine(-(int)cam.getX() + 30, -(int)cam.getY() + 100, -(int)cam.getX() + 215, -(int)cam.getY() + 100);
		g2d.drawLine(-(int)cam.getX() + 30, -(int)cam.getY() + 140, -(int)cam.getX() + 215, -(int)cam.getY() + 140);
		g2d.fillRect(-(int)cam.getX() + 205, -(int)cam.getY() + 100, 10, 5);
		g2d.drawRect(-(int)cam.getX() + 205, -(int)cam.getY() + 105, 10, 5);
		g2d.fillRect(-(int)cam.getX() + 205, -(int)cam.getY() + 110, 10, 5);
		g2d.drawRect(-(int)cam.getX() + 205, -(int)cam.getY() + 115, 10, 5);
		g2d.fillRect(-(int)cam.getX() + 205, -(int)cam.getY() + 120, 10, 5);
		g2d.drawRect(-(int)cam.getX() + 205, -(int)cam.getY() + 125, 10, 5);
		g2d.fillRect(-(int)cam.getX() + 205, -(int)cam.getY() + 130, 10, 5);
		g2d.drawRect(-(int)cam.getX() + 205, -(int)cam.getY() + 135, 10, 5);
		

		//Player for Mini Map
		
		g2d.setColor(Color.red);
		xOfPlayer = (int) (-cam.getX()+player.getX()/16512.0*165.0+30);//ADJUST 105 TO something Reasonable
		g2d.fillOval(xOfPlayer, -(int)cam.getY() + 113, 15, 15);
		//System.out.println(xOfPlayer);
		g2d.translate(-cam.getX(), -cam.getY()); //End of Cam

		//////////////////////////////////
		g.dispose();
		bs.show();


	}


	private void LoadImageLevel(BufferedImage image){

		int w = image.getWidth();
		int h = image.getHeight();

		int pixel;
		

		System.out.println("Width, Height " + w + " " + h);

		if (initLevel){

			for (int xx = 0; xx < h; xx++){

				for (int yy = 0; yy < w; yy++){

					pixel = image.getRGB(xx, yy);
					red = (pixel >> 16) & 0xff;
					green = (pixel >> 8) & 0xff;
					blue = (pixel) & 0xff;//here
					//System.out.println(xx +" "+yy+" "+red+" "+green+" "+blue);
					if(red == 255 && green == 255 && blue == 255) Handler.addObject(new Block(xx*32, yy*32, ObjectId.Block));
					if(red == 0 && green == 0 && blue == 255) Handler.addObject(player = new Player(xx*32, yy*32, ObjectId.Player));
					if (red == 255 && green == 255 && blue == 0) Handler.addObject(sBlock = new SwitchBlock(xx*32, yy*32, ObjectId.SwitchBlock));


				}//for

				initLevel = false;

			}//for

		}//if

		if (!initLevel){

			for (int xx = 0; xx < player.getX() + 20; xx++){

				for (int yy = 0; yy < player.getY() + 20; yy++){

					pixel = image.getRGB(xx, yy);
					red = (pixel >> 16) & 0xff;
					green = (pixel >> 8) & 0xff;
					blue = (pixel) & 0xff;
					
					System.out.println("X = " + xOfPlayer);

					//if(red == 255 && green == 255 && blue == 255) Handler.addObject(new Block(xx*32, yy*32, ObjectId.Block));
					//if(red == 0 && green == 0 && blue == 255) Handler.addObject(player = new Player(xx*32, yy*32, Handler, ObjectId.Player));
					//FIX LEVEL SWITCHING
					
					
					}

				}//for

			}//for

		}//if



	

	public static void main (String args[]){

		new Window(1280, 720, "PointlessJourney", new Game());

	}

}
