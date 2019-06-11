package test;

import java.util.*;

import javax.swing.JFrame;

public class Life_game extends JFrame{
	
	Life_game(){  
		this.setSize(818,845);
		this.add(new Paint());
		this.setTitle("ÅöÎÒ¾ÍËé");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
	}
	
	public static void main(String args[]) {
		Life_game lifegame = new Life_game();  
		lifegame.setVisible(true);
		
	}
}
