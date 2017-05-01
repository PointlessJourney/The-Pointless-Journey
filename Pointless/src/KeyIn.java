import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyIn extends KeyAdapter {
	private Handler handler;
	
	public KeyIn (Handler handler){
		this.handler = handler;		
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++)
		{
			OverChar temp = handler.object.get(i);	
			int x = temp.getX();
			int y = temp.getY();
			
			System.out.println("x:"+x+" y: "+y);
			
			int speed = 3;
			int back = speed*-1;
			int down = back;
			int up = speed;
			int left = speed;
			int right = back;
			if (temp.getID() == ID.Player)
			{		//player movement keys
				
				if (x >= 600)left=0;
				if (x <= -3309)right=0;
				if (y >= 296)up = 0;
				if ( y <= -2587)down = 0;
					
				if (key == KeyEvent.VK_W)temp.setVelY(up);
				if (key == KeyEvent.VK_S)temp.setVelY(down);
				if (key == KeyEvent.VK_A)temp.setVelX(left);		
				if (key == KeyEvent.VK_D) temp.setVelX(right);
					
				
			}
		}		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++)
		{
			OverChar temp = handler.object.get(i);
			
			if (temp.getID() == ID.Player)
			{		//player movement keys
				if (key == KeyEvent.VK_W)temp.setVelY(0);
				if (key == KeyEvent.VK_S)temp.setVelY(0);
				if (key == KeyEvent.VK_A)temp.setVelX(0);		
				if (key == KeyEvent.VK_D) temp.setVelX(0);	
			}
		}				
	}

}