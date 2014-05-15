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
	private Graphics g;
	
	public JPanelDrawingTable(ProjectUML model){
		this.model=model;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.g=g;
		for (int i=0; i<model.objectsListSize(); i++){
			int positionX=model.getObjectUmlAtIndex(i).getX();
			int positionY=model.getObjectUmlAtIndex(i).getY();
			
			ObjectUML obj = model.getObjectUmlAtIndex(i);
			

					
			//Choose the color according to the type of the object
			Color color;
			switch (model.getObjectUmlAtIndex(i).getObjectType()) {
			case 1:
				color =new Color(228,228,228);
				break;
			case 2:
				color = new Color(183,229,255);
				break;
			case 3:
				color = new Color(255,183,183);
				break;
			default:
				color = new Color(228,228,228);
				break;
			}

			g.setColor(color);
			
			g.fillRect(positionX, positionY, maxLength(i, g)+40, 30);

			//Draw square red on the left top
			g.setColor(Color.GRAY);
			g.fillRect(positionX, positionY, 10, 10);
			g.setColor(Color.BLACK);
			g.drawRect(positionX, positionY, 10, 10);

			g.setColor(Color.BLACK);
			g.drawRect(positionX, positionY,maxLength(i, g)+40 , 30);

			//Warning => The position in the method is the point in the left bottom of the text
			g.setColor(Color.BLACK);
			g.drawString(obj.getName(), positionX+20, positionY+20);
			
			//Write if the class if abstract or a interface
			g.setColor(Color.BLACK);
			if (obj.getObjectType()==2){
				g.drawString("Interface", positionX+20, positionY -5);
			} else if(obj.getObjectType()==3){
				g.drawString("Abstract", positionX+20, positionY-5);
			}
			positionY=positionY+30;
			positionY=drawAttribute(obj, i, g, color, positionX,positionY);
			positionY=drawMethod(obj, i, g, color, positionX, positionY);

		
		}	
		
		
	}
	
	private int drawAttribute(ObjectUML obj,int i, Graphics g, Color color, int positionX, int positionY){
					//draw the attribute
			g.setColor(color);
			g.fillRect(positionX, positionY, maxLength(i, g)+40, obj.attributListSize()*20+20);
			g.setColor(Color.BLACK);
			g.drawRect(positionX, positionY,maxLength(i, g)+40 ,  obj.attributListSize()*20+20);
			
			g.setColor(Color.BLACK);
			for (int j=0; j<obj.attributListSize(); j++){
				g.drawString(obj.getAttributeAt(j).toString(), positionX+20, positionY+20);
				positionY=positionY+20;
			}
			positionY+=20;
			
			// +Button
			g.setColor(color.RED);
			g.fillRect(positionX+maxLength(i, g)+30, positionY-10, 10, 10);
			g.setColor(color.BLACK);
			g.drawRect(positionX+maxLength(i, g)+30, positionY-10, 10, 10);
			g.drawString("+",positionX+maxLength(i, g)+31 ,positionY-1);
			
			return positionY;
	}
	private int drawMethod(ObjectUML obj,int i, Graphics g, Color color, int positionX, int positionY){
		//draw the attribute
		g.setColor(color);
		g.fillRect(positionX, positionY, maxLength(i, g)+40, obj.methodeListSize()*20+20);
		g.setColor(Color.BLACK);
		g.drawRect(positionX, positionY,maxLength(i, g)+40 ,  obj.methodeListSize()*20+20);
		
		g.setColor(Color.BLACK);
		for (int j=0; j<obj.methodeListSize(); j++){
			g.drawString(obj.getMehodAt(j).toString(), positionX+20, positionY+20);
			positionY=positionY+20;
		}
		positionY+=20;
		
		// +Button
		g.setColor(color.RED);
		g.fillRect(positionX+maxLength(i, g)+30, positionY-10, 10, 10);
		g.setColor(color.BLACK);
		g.drawRect(positionX+maxLength(i, g)+30, positionY-10, 10, 10);
		g.drawString("+",positionX+maxLength(i, g)+31 ,positionY-1);
		
		return positionY;
	}
	public int maxLength(int index, Graphics g){
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

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

}
