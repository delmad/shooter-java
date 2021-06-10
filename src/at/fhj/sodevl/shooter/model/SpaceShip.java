package at.fhj.sodevl.shooter.model;

import java.awt.geom.Rectangle2D;

public class SpaceShip extends SpaceObject{
	
	private Rectangle2D bounds;


	//Konstruktor
		public SpaceShip(int x, int y) {
			super(x,y);
		}	
	public void moveX(int x){
		this.x += x;		
	}
	public void moveY(int y){
		
		this.y += y;
		
	}
	
	
	
	
	
	//box za igru
	public void setSize(Rectangle2D stringBounds) {
		this.setBounds(stringBounds);		
	}
	public Rectangle2D getBounds() {
		return bounds;
	}
	public void setBounds(Rectangle2D bounds) {
		this.bounds = bounds;
	}

}
