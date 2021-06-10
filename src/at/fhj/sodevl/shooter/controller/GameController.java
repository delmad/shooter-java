package at.fhj.sodevl.shooter.controller;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import at.fhj.sodevl.shooter.View.GameWorld;

public class GameController implements KeyListener,Runnable{
	
	GameWorld  world;

	public void setGameWorld(GameWorld gameWorld){
		world = gameWorld;
		world.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
			int key = e.getKeyCode();
			System.out.println(key);
			if(world.getSpaceShip()==null){
				return;
			}
			if (key == KeyEvent.VK_UP){
				 world.getSpaceShip().moveY(-2);
				System.out.println("up");
			}
			if (key == KeyEvent.VK_DOWN){
				 world.getSpaceShip().moveY(2);
				System.out.println("down");
			}
			if (key == KeyEvent.VK_LEFT){
				 world.getSpaceShip().moveX(-2);
				System.out.println("left");
			}
			if (key == KeyEvent.VK_RIGHT){
				 world.getSpaceShip().moveX(2);
				System.out.println("right");
			}
			if(key == KeyEvent.VK_SPACE){
				world.addMissile();
			}
			
			world.repaint();
		
	}
	@Override
	public void run() {
		int counter = 0;
		while(true){
			try{
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			if (world.getSpaceShip() == null){
				break;
			}
			if (counter%10 == 0){
				world.moveAliens();
			}
			world.repaint();
			counter ++;
		}
		}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	
		
	}
		


