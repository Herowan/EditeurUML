package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import model.ProjectUML;

public class DrawingTableControler implements MouseMotionListener{
	
	private ProjectUML model;
	
	public DrawingTableControler(ProjectUML model){
		this.model=model;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int i=0;
		while(i<model.objectsListSize()){
			if (e.getX()>=model.getObjectUmlAtIndex(i).getX() && e.getX()<=model.getObjectUmlAtIndex(i).getX()+8
					&& e.getY()>=model.getObjectUmlAtIndex(i).getY() && e.getY()<=model.getObjectUmlAtIndex(i).getY()+8){
				model.setPositionObject(e.getX(), e.getY(), i);
				
				i=model.objectsListSize();
			}
			i++;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

}
