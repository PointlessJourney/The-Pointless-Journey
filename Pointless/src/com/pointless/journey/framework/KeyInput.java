package com.pointless.journey.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.pointless.journey.window.Handler;

public class KeyInput extends KeyAdapter{

	Handler handler;
	public int d = 7;
	public int a = -7;
	int clock;

	public KeyInput(Handler handler){

		this.handler = handler;

	}

	//when key is pressed
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++){

			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ObjectId.Player){

				if(tempObject.speeding){
					d = 12;
					a = -12;//ENDED HERE MAKE SURE POWERUP SHOW UP
					
					if(key == KeyEvent.VK_D) tempObject.setVelX(d);
					if(key == KeyEvent.VK_A) tempObject.setVelX(a);
					if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()){

						tempObject.setJumping(true);
						tempObject.setVelY(-12);

					}
				} else {

					resetSpeed();

					if(key == KeyEvent.VK_D) tempObject.setVelX(d);
					if(key == KeyEvent.VK_A) tempObject.setVelX(a);
					if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()){

						tempObject.setJumping(true);
						tempObject.setVelY(-12);

					}
				}
				//if(key == KeyEvent.VK_S) tempObject.setVelY(2);

			}

		}



		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}

	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void resetSpeed(){
		d = 7;
		a = -7;
	}

	//when key is released
	public void keyReleased(KeyEvent e){

		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++){

			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ObjectId.Player){

				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				//if(key == KeyEvent.VK_S) tempObject.setVelY(0);

			}

		}

	}

}
