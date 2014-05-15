package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.JPanelDrawingTable;
import view.NewAttributeView;
import view.NewMethodView;
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
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {    
        int i=0;
        int buttonPositionY;
        int buttonPositionX;
        boolean quit=false;;
        while(i<model.objectsListSize() && !quit){
        	buttonPositionY = model.getObjectUmlAtIndex(i).getY()+50+20*model.getObjectUmlAtIndex(i).attributListSize();
        	buttonPositionX = model.getObjectUmlAtIndex(i).getX();
        	buttonPositionY-=10;
        	buttonPositionX+=jPanelDrawingtable.maxLength(i, jPanelDrawingtable.getG())+30;
            if (e.getX()>=model.getObjectUmlAtIndex(i).getX() && e.getX()<=model.getObjectUmlAtIndex(i).getX()+10 && e.getY()>=model.getObjectUmlAtIndex(i).getY() && e.getY()<=model.getObjectUmlAtIndex(i).getY()+10){
                model.setSelectedObject(i);
                quit=true;
            }
            if (e.getX()>=buttonPositionX && e.getX()<=buttonPositionX+10 && e.getY()>=buttonPositionY && e.getY()<=buttonPositionY+10){
                new NewAttributeView(model,i).setVisible(true);
                quit=true;
            }
            buttonPositionY+=20+model.getObjectUmlAtIndex(i).methodeListSize()*20;
            if (e.getX()>=buttonPositionX && e.getX()<=buttonPositionX+10 && e.getY()>=buttonPositionY && e.getY()<=buttonPositionY+10){
                new NewMethodView(model,i).setVisible(true);
                quit=true;
            }
            i++;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        model.setSelectedObject(-1);
    }

}



