import java.awt.MouseInfo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyIn extends KeyAdapter {
	
	public KeyIn (){	
	}
	int speed = (int)(OverChar.playerSpeed/1600.0*MainMenu.width);
	
	int back = speed*-1;
	int down = speed;
	int up = back;
	int left = back;
	int right = speed;
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		

			
			
					//player movement keys



					
				if (key == KeyEvent.VK_W)OverChar.setVelY(up);
				if (key == KeyEvent.VK_S)OverChar.setVelY(down);
				if (key == KeyEvent.VK_A)OverChar.setVelX(left);		
				if (key == KeyEvent.VK_D)OverChar.setVelX(right);
				if (key==KeyEvent.VK_C)System.out.println("x:" + OverChar.playerX + "    y:"+OverChar.playerY+"  "+MouseInfo.getPointerInfo().getLocation().x+"  "+MouseInfo.getPointerInfo().getLocation().y);
				
			//System.out.println(OverChar.playerX);
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
				if (key == KeyEvent.VK_W&&OverChar.getVelY()==up)OverChar.setVelY(0);
				if (key == KeyEvent.VK_S&&OverChar.getVelY()==down)OverChar.setVelY(0);
				if (key == KeyEvent.VK_A&&OverChar.getVelX()==left)OverChar.setVelX(0);		
				if (key == KeyEvent.VK_D&&OverChar.getVelX()==right)OverChar.setVelX(0);	

			
						
	}

}