package test;

import java.awt.Color;
import java.awt.Graphics;   
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.JPanel;  
import javax.swing.Timer; 

public class Paint extends JPanel{
	
	Map map = new Map();
	Time time = new Time();
	Timer timer = time.getTimer();
			
	//¸üÐÂ
	public Paint() {
		this.first_action();
	}
			
	public void first_action() {
		map.setworld();
		for (int row = 0; row < map.getWorld().length; row++) {  
		    for (int col = 0; col < map.getWorld()[0].length; col++) {  
		    	map.getSecond_world()[row][col] = map.getWorld()[row][col];  
		        map.getFirst_world()[row][col] = map.getWorld()[row][col];  
		    }  
		} 
		timer = new Timer(time.getOnce_time(), new ActionListener() {   
		    public void actionPerformed(ActionEvent e) {  
		        map.update_cell(); 
		        repaint();  
		    }  
		});  
		timer.start(); 
	}
			
	public void paintComponent(Graphics g) {  
	    g.setColor(Color.red);
		super.paintComponent(g);  
		for (int i = 0; i < map.getSecond_world().length; i++) {  
			for (int j = 0; j < map.getSecond_world()[i].length; j++) {  
			     if (map.getSecond_world()[i][j] == 'l') {  
			         g.fill3DRect(j*20, i*20, 20, 20,true);   
			     } 
			}  
		}  
	} 
}

