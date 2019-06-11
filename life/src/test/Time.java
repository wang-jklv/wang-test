package test;

import java.awt.Color;
import java.awt.Graphics;   
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.JPanel;  
import javax.swing.Timer; 

public class Time extends JPanel{
	
	//设置更新间隔时间
	private Timer timer;
	private int once_time = 12000;
	
	public Timer getTimer() {
		return timer;
	}
	
	public int getOnce_time() {
		return once_time;
	}
	
	public void set_timer(Timer timer) {
		this.timer = timer;
	}
	
	public void set_once_time(int once_time) {
		this.once_time = once_time;
	}
}
	
	