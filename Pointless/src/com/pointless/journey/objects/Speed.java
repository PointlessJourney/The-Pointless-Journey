package com.pointless.journey.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.window.Handler;

public class Speed extends GameObject{
	
	private Handler handler;

	public Speed(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
	}


	public void tick(LinkedList<GameObject> object) {


	}

	public void render(Graphics g) {

		g.setColor(Color.green);
		g.drawOval((int)x, (int)y, 32, 32);

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
