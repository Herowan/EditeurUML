package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.ProjectUML;

public class DrawingTableControler implements MouseMotionListener, MouseListener{
	
	private ProjectUML model;
	
	public DrawingTableControler(ProjectUML model){
		this.model=model;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		model.setPositionObject(e.getX(), e.getY(), model.getSelectedObject());
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {		
		int i=0;
		while(i<model.objectsListSize()){
			if (e.getX()>=model.getObjectUmlAtIndex(i).getX() && e.getX()<=model.getObjectUmlAtIndex(i).getX()+8 && e.getY()>=model.getObjectUmlAtIndex(i).getY() && e.getY()<=model.getObjectUmlAtIndex(i).getY()+8){
				model.setSelectedObject(i);

				i=model.objectsListSize();
			}
			i++;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
