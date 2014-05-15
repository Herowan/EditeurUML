package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.JPanelDrawingTable;
import view.NewAttributeView;
import model.ProjectUML;

public class DrawingTableController implements MouseMotionListener, MouseListener{
    
    private ProjectUML model;
    private JPanelDrawingTable jPanelDrawingtable;
    
    public DrawingTableController(ProjectUML model, JPanelDrawingTable jPanelDrawingtable){
        this.model=model;
        this.jPanelDrawingtable=jPanelDrawingtable;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (model.getSelectedObject()!=-1){
            model.setPositionObject(e.getX(), e.getY(), model.getSelectedObject());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	/*new NewAttributeView();
    	int i=0;
        while(i<model.objectsListSize()){
        	int buttonPositionX=model.getObjectUmlAtIndex(i).getX()+50+20*model.getObjectUmlAtIndex(i).attributListSize();
        	buttonPositionX+=jPanelDrawingtable.maxLength(i, jPanelDrawingtable.getG())+30;
        	int buttonPositionY=model.getObjectUmlAtIndex(i).getY();
        	buttonPositionY-=10;
            if (e.getX()>=buttonPositionX && e.getX()<=buttonPositionX+10 && e.getY()>=buttonPositionY && e.getY()<=buttonPositionY+10){
                new NewAttributeView();
                i=model.objectsListSize();
                System.out.println("Check");
            }
            i++;
        }*/
    }

    @Override
    public void mouseEntered(MouseEvent e) {new NewAttributeView();}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {    
        int i=0;
        while(i<model.objectsListSize()){
        	int buttonPositionY=model.getObjectUmlAtIndex(i).getX()+50+20*model.getObjectUmlAtIndex(i).attributListSize();
        	int buttonPositionX=model.getObjectUmlAtIndex(i).getY();
        	buttonPositionY-=10;
        	buttonPositionX+=jPanelDrawingtable.maxLength(i, jPanelDrawingtable.getG())+30;
            if (e.getX()>=model.getObjectUmlAtIndex(i).getX() && e.getX()<=model.getObjectUmlAtIndex(i).getX()+10 && e.getY()>=model.getObjectUmlAtIndex(i).getY() && e.getY()<=model.getObjectUmlAtIndex(i).getY()+10){
                model.setSelectedObject(i);

                i=model.objectsListSize();
            } else if (e.getX()>=buttonPositionX && e.getX()<=buttonPositionX+10 && e.getY()>=buttonPositionY && e.getY()<=buttonPositionY+10){
                new NewAttributeView().setVisible(true);
                i=model.objectsListSize();
            }
            i++;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        model.setSelectedObject(-1);
    }

}

