package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.ProjectUML;

public class JPanelDrawingTable extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProjectUML model;
	
	public JPanelDrawingTable(ProjectUML model){
		this.model=model;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for (int i=0; i<model.objectsListSize(); i++){
			
			g.setColor(new Color(228,228,228));
			g.fillRect(10, 10, 100, 100);
			g.setColor(Color.BLACK);
			g.drawRect(10, 10, 100, 100);

			//Warning => The position in the method is the point in the left bottom of the text
			// X = position + 10
			// Y = position + 15
			g.drawString(model.getObjectUmlAtIndex(i).getName(), 20, 25);
		}
		
	}

}
