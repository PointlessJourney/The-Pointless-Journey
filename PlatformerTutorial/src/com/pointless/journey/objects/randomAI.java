package com.pointless.journey.objects;

import java.awt.image.BufferedImage;
import com.pointless.journey.framework.ObjectId;
import com.pointless.journey.window.Game;
import com.pointless.journey.window.Handler;

public class randomAI extends Player{
	
	private double[] range = new double[2];
	private double speed;
	private int stage = 0;
	int health;
	int collisionDamage;
	int x;
	int y;
	double size;
	Handler handler;

	private boolean seeking = false;
	public static double rage = 0;
	
	public randomAI(int x, int y, ObjectId id, double size) {
		
		super(x, y, id);

		// TODO Auto-generated constructor stub
		speed = 12000;
		health = 1;
		collisionDamage = 15;
		if (rage >=6)
		{
			speed = (speed + (Math.random() * 1000));
			//System.out.print("Speed is up" + speed);
		}
		if (rage >=12)
		{
			speed = (speed + ((Game.life) * 100));
			health = 4;
			//System.out.print("Health is up" + health);
		}
	}

	public void tick() {
		// TODO Auto-generated method stub

		double angle = Math.atan2(getY()-y, getX()-x);
		if(seeking||Math.sqrt(((getX()-x)/1000)*((getX()-x)/1000)+((getY()-y)/1000)*((getY()-y)/1000))*1000>range[stage]){

			x += (int)(speed *Math.cos(angle));
			y += (int)(speed *Math.sin(angle));		
		}else if(stage==0){
			stage=1;
		}
		else seeking = true;
		if(health<=0)
		{
			Handler.removeObject(this);
			rage = rage + 1;

		}
	}		
}	

