package at.fhj.sodevl.shooter.View;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import at.fhj.sodevl.shooter.controller.GameController;

public class GameWindow extends JFrame{
	
	private GameWorld gw;
	private GameController gc;

	public GameWindow(){
		super();
		this.setTitle("The GameWindow");
		this.setSize(500, 500);
		this.setResizable(true);
		this.getContentPane().setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gw = new GameWorld();
		this.add(gw, BorderLayout.CENTER);
		gw.addMissile();
		
		gc = new GameController();
		gc.setGameWorld(gw);
		
		GameController gameLoop;
		gameLoop = new GameController();
		gameLoop.setGameWorld(gw);
		
		Thread t = new Thread(gameLoop);
		t.start();
	}
		
	
		
	}

	
