package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelDrawingTable extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.GRAY);
		g.fillRect(10, 10, 100, 100);
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, 100, 100);
	}

}
