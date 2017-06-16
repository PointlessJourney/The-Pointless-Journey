import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Boss1Minion extends OverChar{

	private double[] range=new double[2],rotate=new double[2];
	private double speed, percent;
	private int stage = 0, delay = 0;
	private int[] direction= new int[2];
	private boolean seeking = false;
	private double angle;
	public Boss1Minion(int x, int y, ID id, BufferedImage map, double size, double percent) {
		super(x, y, id, map, size);
		this.percent=percent;
		speed = (Math.random()*2500+3500-2000*percent)/1360.0*MainMenu.width;
		health = 8;
		collisionDamage = 2;
		range[0]=(Math.random()*400000+300000)/1360.0*MainMenu.width;
		range[1]=(Math.random()*200000+100000)/1360.0*MainMenu.width;
		rotate[0]=Math.random()*Math.PI*2-Math.PI;
		rotate[1]=Math.random()*Math.PI*2-Math.PI;
		if(Math.random()>0.5){
			direction[0]=1;
		}else direction[0]=-1;
		if(Math.random()>0.5){
			direction[1]=1;
		}else direction[1]=-1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		angle = Math.atan2(playerY-y, playerX-x);
		if(seeking||Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))*1000>range[stage]){
			//System.out.println("here");
			x += (int)(speed *Math.cos(angle));
			y += (int)(speed *Math.sin(angle));
		}
		if(angle<rotate[stage]-Math.PI/8||angle>rotate[stage]+Math.PI/8){
			x += (int)(speed* (1.5+0.5*percent) *Math.cos(angle+Math.PI/2*direction[stage]));
			y += (int)(speed* (1.5+0.5*percent) *Math.sin(angle+Math.PI/2*direction[stage]));
		}else if(stage==0){
			stage=1;
		}else{
			seeking = true;
			delay = 1000;
		}
		if(health<=0)Handler.removeObject(this);
		if(seeking){
			delay--;
			if(delay==0){
				seeking = false;
				stage = 0;
			}
		}
		
	}
	
	@Override
		public void render(Graphics g,double angle){
		this.angle += Math.PI/2;
			super.render(g, this.angle);
		}

}
