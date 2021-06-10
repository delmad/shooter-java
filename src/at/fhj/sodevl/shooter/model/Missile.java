package at.fhj.sodevl.shooter.model;

public class Missile extends SpaceObject{

	public Missile(int x, int y) {
		super(x, y);
		
	}	
	public void moveX(int x){
		super.x += x;	
	}
	
	@Override
	public String toString(){
		return "Missile: " + this.x + "/" + this.y;
	}
}
