import java.awt.image.BufferedImage;

public class Boss1Minion extends OverChar{

	private double[] range=new double[2],rotate=new double[2];
	private double speed;
	private int stage = 0;
	private int direction1,direction2;
	private boolean seeking = false;
	public Boss1Minion(int x, int y, ID id, BufferedImage map, double size) {
		super(x, y, id, map, size);
		speed = Math.random()*3000+2500;
		
		health = 10;
		collisionDamage = 2;
		range[0]=Math.random()*200000+100000;
		range[1]=Math.random()*50000+50000;
		rotate[0]=Math.random()*Math.PI*2-Math.PI;
		rotate[1]=Math.random()*Math.PI*2-Math.PI;
		if(Math.random()>0.5){
			direction1=1;
		}else direction1=-1;
		if(Math.random()>0.5){
			direction2=1;
		}else direction2=-1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		double angle = Math.atan2(playerY-y, playerX-x);
		if(seeking||Math.sqrt(((playerX-x)/1000)*((playerX-x)/1000)+((playerY-y)/1000)*((playerY-y)/1000))*1000>range[stage]){
			//System.out.println("here");
			x += (int)(speed *Math.cos(angle));
			y += (int)(speed *Math.sin(angle));
		}
		if(angle<rotate[stage]-Math.PI/8||angle>rotate[stage]+Math.PI/8){
			x += (int)(speed *Math.cos(angle+Math.PI/2*direction1));
			y += (int)(speed *Math.sin(angle+Math.PI/2*direction1));
		}else if(stage==0){
			stage=1;
		}else seeking = true;
		if(health<=0)Handler.removeObject(this);
	}
	
	

}
