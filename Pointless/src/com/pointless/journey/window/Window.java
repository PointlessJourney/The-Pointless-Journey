package com.pointless.journey.window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
public static boolean paused;
public static JFrame frame;
	public Window(int w, int h, String title, Game game){
		
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));
		
		//configure frame
		frame = new JFrame(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();//start game
		
	}

	
}
