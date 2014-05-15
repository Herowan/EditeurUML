package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.ObjectUML;
import model.ProjectUML;

public class JPanelDrawingTable extends JPanel{

	/**
	 * 
	 * @author digeona
	 */
	private static final long serialVersionUID = 1L;
	
	private ProjectUML model;
	
	public JPanelDrawingTable(ProjectUML model){
		this.model=model;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		for (int i=0; i<model.objectsListSize(); i++){
			//Choose the color according to the type of the object
			switch (model.getObjectUmlAtIndex(i).getObjectType()) {
			case 1:
				g.setColor(new Color(228,228,228));
				break;
			case 2:
				g.setColor(new Color(183,229,255));
				break;
			case 3:
				g.setColor(new Color(255,183,183));
				break;
			default:
				g.setColor(new Color(228,228,228));
				break;
			}

			g.fillRect(model.getObjectUmlAtIndex(i).getX(), model.getObjectUmlAtIndex(i).getY(), maxLength(i, g)+40, 100);

			//Draw square red on the left top
			g.setColor(Color.GRAY);
			g.fillRect(model.getObjectUmlAtIndex(i).getX(), model.getObjectUmlAtIndex(i).getY(), 10, 10);
			g.setColor(Color.BLACK);
			g.drawRect(model.getObjectUmlAtIndex(i).getX(), model.getObjectUmlAtIndex(i).getY(), 10, 10);

			g.setColor(Color.BLACK);
			g.drawRect(model.getObjectUmlAtIndex(i).getX(), model.getObjectUmlAtIndex(i).getY(),maxLength(i, g)+40 , 100);

			//Warning => The position in the method is the point in the left bottom of the text
			g.drawString(model.getObjectUmlAtIndex(i).getName(), model.getObjectUmlAtIndex(i).getX()+20, model.getObjectUmlAtIndex(i).getY()+20);
		}	
		
		
	}
	
	private int maxLength(int index, Graphics g){
		ObjectUML obj = model.getObjectUmlAtIndex(index);
		int max=lengthOf(obj.getName(), g);
		for (int i=0; i<obj.methodeListSize();i++){
			if (lengthOf(obj.getMehodAt(i).toString(), g)>max){
				max=lengthOf(obj.getMehodAt(i).toString(),g);
			}
		}
		for (int i=0; i<obj.attributListSize();i++){
			if (lengthOf(obj.getAttributeAt(i).toString(), g)>max){
				max=lengthOf(obj.getAttributeAt(i).toString(),g);
			}
		}
		return max;
	}
	
	private int lengthOf(String ms,Graphics g){
		Font font = g.getFont();
		FontMetrics fm = g.getFontMetrics(font);
		
		return fm.stringWidth(ms);
	}

}
