package at.fhj.sodevl.shooter.View;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import at.fhj.sodevl.shooter.model.Alien;
import at.fhj.sodevl.shooter.model.Missile;
import at.fhj.sodevl.shooter.model.SpaceObject;
import at.fhj.sodevl.shooter.model.SpaceShip;

public class GameWorld extends JPanel {

		private SpaceShip ship;
		private Missile missile;
		ArrayList<Missile> missiles;
		private ArrayList<Alien> aliens;
		
		
		public GameWorld(){
			ship = new SpaceShip(70,70);
			missiles = new ArrayList<Missile>();
			aliens = new ArrayList<Alien>();
			int maxrow = 500/20;
			for(int a = 0; a <= 9; a ++){
				int row = (int)(Math.random()*maxrow);
				Alien alien = new Alien (480,row*20);
				aliens.add(alien);
			}
			
			System.out.println("Aliens " + aliens);
		}
		
		public void paint(Graphics g){
			if( ship != null){
				evaluateCrash();
			}
			if (ship == null){
				g.drawString("Game Over", 250, 250);
				return;
			}
			super.paint(g);
			setFocusable(true);
			ship.setSize(g.getFontMetrics().getStringBounds("[----]->", g));
			g.drawString("[----]->", ship.getX(), ship.getY());
//			System.out.println("ship:"+ ship + " " +ship.getX()+", "+ship.getY());
			
			if (missile != null){
				System.out.println("draw missile");
				g.drawString(">", missile.getX(), missile.getY());
				missile.moveX(2);
			}
			
			for(Missile m : new ArrayList<Missile>(missiles)){
				g.drawString("->", m.getX(), m.getY());
				m.moveX(2);
				if(m.getX()>500){
					System.out.println("Removing missile");
					missiles.remove(m);
				}
			}
			for(Alien a : aliens){
				g.drawImage(a.getImage(), a.getX(), a.getY(), a.getX()+20, a.getY()+20, 0, 0, a.getImage().getWidth(this), a.getImage().getHeight(this), this);
			}
		}
		
		private void evaluateCrash() {
			ArrayList<Missile>MissileRemove = new ArrayList<Missile>();
			ArrayList<Alien>AlienRemove = new ArrayList<Alien>();
			for(Missile m :missiles){
				for(Alien a :aliens){
					System.out.println("M vs. A" + m + " / " + a);
					if(isPointinAlien(m.getX(),m.getY(),a)){
						MissileRemove.add(m);
						AlienRemove.add(a);
					}
				}
			}
			

			missiles.removeAll(MissileRemove);
			aliens.removeAll(AlienRemove);
			boolean isGameOver = false;
			
			
			if(ship.getBounds() != null){
			for(Alien a : aliens){
				System.out.println("bounds: " + ship.getBounds());
				System.out.println("alien: " + a);
				System.out.println(isPointinAlien(ship.getX(),ship.getY(),a) + " " + 
						isPointinAlien(ship.getX()+(int)ship.getBounds().getWidth(),ship.getY(),a)+ " " +
						isPointinAlien(ship.getX()+(int)ship.getBounds().getWidth(),ship.getY()+(int)ship.getBounds().getHeight(),a)+ " " +
						isPointinAlien(ship.getX(),ship.getY()+(int)ship.getBounds().getHeight(),a));
				isGameOver = isPointinAlien(ship.getX(),ship.getY(),a)||
						isPointinAlien(ship.getX()+(int)ship.getBounds().getWidth(),ship.getY(),a)||
						isPointinAlien(ship.getX()+(int)ship.getBounds().getWidth(),ship.getY()+(int)ship.getBounds().getHeight(),a)||
						isPointinAlien(ship.getX(),ship.getY()+(int)ship.getBounds().getHeight(),a)
						|| checkInBounds(a.getX(),a.getY(),ship,(int)ship.getBounds().getWidth())
						||checkInBounds(a.getX(),a.getY()+20,ship,(int)ship.getBounds().getWidth())
								||checkInBounds(a.getX()+20,a.getY(),ship,(int)ship.getBounds().getWidth())
										||checkInBounds(a.getX()+20,a.getY()+20,ship,(int)ship.getBounds().getWidth());
				if(isGameOver)
					break;
			}
			}
			System.out.println("GAMEOVER" + isGameOver);
			if(isGameOver){
				aliens.clear();
				missiles.clear();
				ship = null;
			}
		}
		private boolean	isPointinAlien(int x, int y,Alien a){
			return checkInBounds(x, y, a, 20);
			
		}
		
		private boolean checkInBounds(int x, int y, SpaceObject a , int width){
			return (x> a.getX() && x < a.getX() + width &&
					y > a.getY() && y < a.getY() + width);
		}
		
		public SpaceShip getSpaceShip(){
			return this.ship;
		}
		//konstruktor missile 
		public void addMissile(){
//			System.out.println("add Missile");
			missiles.add(new Missile(this.ship.getX(),this.ship.getY()));
		}

		public void moveAliens() {
			for(Alien a : aliens){
				a.moveX(-10);
				
			}
			
		}
		
		
}
