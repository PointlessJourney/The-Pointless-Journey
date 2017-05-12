package com.pointless.journey.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.window.Handler;

public class Player extends GameObject{
	
	private float width = 48, height = 96;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	
	private Handler handler;

	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
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
		
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
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
					
					x = tempObject.getX() - width;//adject collision here
					
				}
				
				//left collision
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					
					x = tempObject.getX() + 35;//adjust collision here
					
				}
				
			}
			
		}
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		//converting g into a Graphics 2D Variable
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		
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
