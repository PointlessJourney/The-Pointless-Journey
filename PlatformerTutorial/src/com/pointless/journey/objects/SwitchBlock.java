package com.pointless.journey.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.ObjectId;

public class SwitchBlock extends GameObject{

	public SwitchBlock(float x, float y, ObjectId id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.drawRect((int)x, (int)y, 32, 32);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(getBounds());
		
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
