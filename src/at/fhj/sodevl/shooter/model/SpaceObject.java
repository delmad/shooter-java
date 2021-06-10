package at.fhj.sodevl.shooter.model;

public class SpaceObject {

	protected int x,y;
	
	public int getX(){
		return x;
		
	}
	public int getY(){
		return y;
		
	}
	
	
	//Konstruktor
	public SpaceObject(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}
