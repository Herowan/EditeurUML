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
		
		//Warning => The position in the method is the point in the left bottom of the text
		g.drawString("Classe test", 20, 25);
	}

}
