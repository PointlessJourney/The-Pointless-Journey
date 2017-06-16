package com.pointless.journey.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.KeyInput;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.window.BufferedImageLoader;
import com.pointless.journey.window.Game;
import com.pointless.journey.window.Handler;
import com.pointless.journey.window.Window;

public class Player extends GameObject{

	private float width = 64, height = 64;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;

	private KeyInput keyIn = new KeyInput();
	private BufferedImage player = null;//use to load level
	
	BufferedImageLoader playerIcon = new BufferedImageLoader();

	public Player(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {

		x += velX;
		y += velY;//Ended Here Java Game Programming #8 - Keyboard Input & Basic Collision

		if (falling || jumping){

			velY += gravity;

			//limit to gravity speed
			if (velY > MAX_SPEED)
				velY = MAX_SPEED;

		}

		Collision(object);

	}

	private void Collision(LinkedList<GameObject> object){

		for(int i = 0; i < Handler.object.size(); i++){

			GameObject tempObject = Handler.object.get(i);

			if (tempObject.getId() == ObjectId.Block){

				//top collision
				if(getBoundsTop().intersects(tempObject.getBounds())){

					y = tempObject.getY() + 32;//adjust top collision here
					velY = 0;	

				}

				//bottom collision
				if(getBounds().intersects(tempObject.getBounds())){

					y = tempObject.getY() - height;//adjust bottom collision here
					velY = 0;
					falling = false;
					jumping = false;


				} else
					falling = true;

				//right collision
				if(getBoundsRight().intersects(tempObject.getBounds())){

					x = tempObject.getX() - width;//adjust collision here

				}

				//left collision
				if(getBoundsLeft().intersects(tempObject.getBounds())){

					x = tempObject.getX() + 33;//adjust collision here

				}

			}//if block

			/////////////////////////////////////////////////////////////////////////////////////

			if(tempObject.getId() == ObjectId.SwitchBlock){

				//right collision
				if(getBoundsRight().intersects(tempObject.getBounds())){

					Window.paused=false;
					Window.frame.setVisible(false);

				}

				//left collision
				if(getBoundsLeft().intersects(tempObject.getBounds())){


					Window.paused=false;
					Window.frame.setVisible(false);
					
				}
				
				//top collision
				if(getBoundsTop().intersects(tempObject.getBounds())){

					

					Window.paused=false;   
					Window.frame.setVisible(false);          

				}


			}
			else {


			}


		}

	}

	public void render(Graphics g) {

		g.setColor(Color.lightGray);

		//converting g into a Graphics 2D Variable
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		
		player = playerIcon.loadImage("MainHero.gif");//loading the level
		
		g2d.drawImage(player, (int)x, (int)y, (int)width, (int)height, null);
		

		/*drawing collision bounds
		g2d.draw(getBounds());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsTop());
		*/
		 


	}

	//Bottom Box
	public Rectangle getBounds() {

		return new Rectangle((int) ((int)x + (width/2)-((width/2)/2)), (int) ((int)y + (height/2)), (int)width/2, (int)height/2);

	}
	//Top Box
	public Rectangle getBoundsTop() {

		return new Rectangle((int) ((int)x + (width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);

	}
	//Box on the right
	public Rectangle getBoundsRight() {

		return new Rectangle((int) ((int)x + width - 5), (int)y + 5, (int)5, (int)height - 10);

	}
	//Box on the left
	public Rectangle getBoundsLeft() {

		return new Rectangle((int)x, (int)y + 5, (int)5, (int)height - 10);

	}

}
