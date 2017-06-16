import java.awt.MouseInfo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class KeyIn extends KeyAdapter {
	
	public KeyIn (){	
	}
	int speed = (int)(OverChar.playerSpeed/1600.0*MainMenu.width);
	
	int back = speed*-1;
	int down = speed;
	int up = back;
	int left = back;
	int right = speed;//easter egg made by armaan
	public static int mkuv = 0;
	public static int EEChar = 0;
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		

		
			if(mkuv == 0&&key == KeyEvent.VK_M){
				mkuv = 1;
			}else if(mkuv == 1&&key == KeyEvent.VK_K){
				mkuv = 2;
			}else if(mkuv == 2&&key==KeyEvent.VK_U){
				mkuv = 3;
			}else if(mkuv == 3&&key ==KeyEvent.VK_V){
				//EEChar = 1;//This is to change the character image
				//use this image ("SBEE.png);
				Handler.addObject(new EEDoodleBob(OverChar.playerX,OverChar.playerY-500000,ID.Enemy,OverChar.LoadImage("SBEE.png") ,0.5));
				mkuv=0;
			}else{
				mkuv = 0;
				
			}
			
					//player movement keys

				

					
				if (key == KeyEvent.VK_W||key == KeyEvent.VK_UP)OverChar.setVelY(up);
				if (key == KeyEvent.VK_S||key == KeyEvent.VK_DOWN)OverChar.setVelY(down);
				if (key == KeyEvent.VK_A||key == KeyEvent.VK_LEFT)OverChar.setVelX(left);		
				if (key == KeyEvent.VK_D||key == KeyEvent.VK_RIGHT)OverChar.setVelX(right);
				if (key==KeyEvent.VK_C)System.out.println("x:" + OverChar.playerX + "    y:"+OverChar.playerY+"  "+MouseInfo.getPointerInfo().getLocation().x+"  "+MouseInfo.getPointerInfo().getLocation().y);
				if (key==KeyEvent.VK_9)Handler.addObject(new BossOne(OverChar.playerX,OverChar.playerY-500000,ID.Enemy,OverChar.LoadImage("Boss1-1.png"),4));
				if (key==KeyEvent.VK_8)Handler.addObject(new Boss1Minion(OverChar.playerX,OverChar.playerY-500000,ID.Enemy,OverChar.LoadImage("BGtop.png"),3.5,1.0));
				if (key==KeyEvent.VK_7)Handler.addObject(new BossTwo(OverChar.playerX,OverChar.playerY-500000,ID.Enemy,OverChar.LoadImage("Sp clone.png"),0.5));
				if (key==KeyEvent.VK_R)Board.fire=true;
				//System.out.println(OverChar.playerX);

				if (key == KeyEvent.VK_B)Handler.addObject(new Spawner(OverChar.playerX + 556, OverChar.playerY + 284, ID.Enemy,OverChar.LoadImage("Sp clone.png"), 1.3));


				/*if(e.isShiftDown()){
					speed = (int)(OverChar.playerSpeed/1600.0*MainMenu.width);
					 back = speed*-1;
					 down = speed;
					 up = back;
					 left = back;
					 right = speed;
				}*/
				
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
				if (key == KeyEvent.VK_W||key == KeyEvent.VK_UP&&OverChar.getVelY()==up)OverChar.setVelY(0);
				if (key == KeyEvent.VK_S||key == KeyEvent.VK_DOWN&&OverChar.getVelY()==down)OverChar.setVelY(0);
				if (key == KeyEvent.VK_A||key == KeyEvent.VK_LEFT&&OverChar.getVelX()==left)OverChar.setVelX(0);		
				if (key == KeyEvent.VK_D||key == KeyEvent.VK_RIGHT&&OverChar.getVelX()==right)OverChar.setVelX(0);	

			
						
	}

}