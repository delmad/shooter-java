package at.fhj.sodevl.shooter.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Alien extends SpaceObject {

	private BufferedImage image;
	public Alien(int x, int y) {
		super(x, y);
		
		try { 
			image = ImageIO.read(new File("re/space-invaders.png")); 
		} catch (Exception e) {
			e.printStackTrace();
			
		} System.out.println(image);
		
		
			}
	public void moveX(int x){
		super.x += x;
	}
	public Image getImage() {
		
		return this.image;
	}
	
	@Override
	public String toString(){
		return "Alien: "  + " " + this.x + "/" + this.y + " img : ";
	}
	

}
