package com.pointless.journey.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.pointless.journey.framework.GameObject;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.objects.Block;

public class Handler {
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void tick(){
		
		for (int i = 0; i < object.size(); i++){
			
			tempObject = object.get(i);//setting tempObject to current object in list
			
			tempObject.tick(object);
			
		}
		
	}
	
	public void render(Graphics g){
		
		for (int i = 0; i < object.size(); i++){
			
			tempObject = object.get(i);//setting tempObject to current object in list
			
			tempObject.render(g);
			
		}
		
	}
	
	public void addObject(GameObject object){
		
		this.object.add(object);
		
	}
	public void removeObject(GameObject object){
		
		this.object.remove(object);
		
	}
	
	public void createLevel(){
		
		for(int xx = 0; xx < Game.WIDTH+32; xx += 32)
			addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
		
	}


}
