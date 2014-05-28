package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.JPanelDrawingTable;
import view.ModifyAttributeObjectView;
import view.ModifyMethodObjectView;
import view.ModifyNameObjectView;
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
    public void mouseMoved(MouseEvent e) {
    	int i=0;
    	boolean quitName=false;
    	boolean quitAttribute=false;
    	boolean quitMethod=false;
    	while(!quitName && !quitAttribute && i<model.objectsListSize()){
    		if (nameOfTheObject(e, i)){
    			model.setNameSelected(i);
    			quitName=true;
    		}
    		int j=0;
    		while (!quitAttribute && j<model.getObjectUmlAtIndex(i).attributListSize()){
    			if(attributeOfTheObject(e, i, j)){
    				model.setAttributeSelected(j);
    				model.setObjectOfAttributeSelected(i);
    				quitAttribute=true;
    			}
    			j++;
    		}
    		int k=0;
    		while(!quitMethod && k<model.getObjectUmlAtIndex(i).methodeListSize()){
    			if(methodOfTheObject(e, i, k)){
    				model.setMethodSelected(k);
    				model.setObjectOfMethodSelected(i);
    				quitMethod=true;
    			}
    			k++;
    		}
    		i++;
    	}
    	if (!quitName){
    		model.setNameSelected(-1); 
    	}
    	if(!quitAttribute){
    		model.setAttributeSelected(-1);
    		model.setObjectOfAttributeSelected(-1);
    	}
    	if(!quitMethod){
    		model.setMethodSelected(-1);
    		model.setObjectOfMethodSelected(-1);
    	}
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {    
        int i=model.objectsListSize()-1;
        int buttonPositionY;
        int buttonPositionX;
        boolean quit=false;
        
        while(i>=0 && !quit){
        	buttonPositionY = model.getObjectUmlAtIndex(i).getY()+50+20*model.getObjectUmlAtIndex(i).attributListSize();
        	buttonPositionX = model.getObjectUmlAtIndex(i).getX();
        	buttonPositionY-=10;
        	buttonPositionX+=jPanelDrawingtable.maxLength(i, jPanelDrawingtable.getG())+30;
            quit =moveZone(e, i);
            if(!quit) quit =crossAttributeZone(e, i, buttonPositionX, buttonPositionY);
            buttonPositionY+=20+model.getObjectUmlAtIndex(i).methodeListSize()*20;
            if(!quit) quit =crossMethodZone(e, i, buttonPositionX, buttonPositionY);
            if(!quit) quit =crossQuitZone(e,i);
            if(!quit && nameOfTheObject(e, i)){
            	new ModifyNameObjectView(model,i).setVisible(true);
            	quit=true;
            }
            if (!quit){
            	for (int j=0; j<model.getObjectUmlAtIndex(i).attributListSize(); j++){
            		if(attributeOfTheObject(e, i, j) && !quit){
            			quit=true;
            			new ModifyAttributeObjectView(model,i,j).setVisible(true);;
            		}
            	}
            }
            if (!quit){
            	for (int j=0; j<model.getObjectUmlAtIndex(i).methodeListSize();j++){
            		if(methodOfTheObject(e, i, j) && !quit){
            			quit = true;
            			new ModifyMethodObjectView(model,i,j).setVisible(true);;
            		}
            	}
            }
            i--;
        }
    }
    
    private boolean crossQuitZone(MouseEvent e, int i) {
    	if (e.getX()>=model.getObjectUmlAtIndex(i).getX()+jPanelDrawingtable.maxLength(i, jPanelDrawingtable.getGraphics())+30 && e.getX()<=model.getObjectUmlAtIndex(i).getX()+jPanelDrawingtable.maxLength(i, jPanelDrawingtable.getGraphics())+40 && e.getY()>=model.getObjectUmlAtIndex(i).getY() && e.getY()<=model.getObjectUmlAtIndex(i).getY()+10){
            model.deleteObjectUml(i);
            return true;
        }
		return false;
	}

	private boolean moveZone(MouseEvent e, int i){
        if (e.getX()>=model.getObjectUmlAtIndex(i).getX() && e.getX()<=model.getObjectUmlAtIndex(i).getX()+10 && e.getY()>=model.getObjectUmlAtIndex(i).getY() && e.getY()<=model.getObjectUmlAtIndex(i).getY()+10){
            model.setSelectedObject(i);
            return true;
        }
        return false;
    }
    private boolean crossAttributeZone(MouseEvent e, int i, int buttonPositionX, int buttonPositionY){
    	if (e.getX()>=buttonPositionX && e.getX()<=buttonPositionX+10 && e.getY()>=buttonPositionY && e.getY()<=buttonPositionY+10){
            new NewAttributeView(model,i).setVisible(true);
            return true;
        }
    	return false;
    }
    private boolean crossMethodZone(MouseEvent e, int i, int buttonPositionX, int buttonPositionY){
    	if (e.getX()>=buttonPositionX && e.getX()<=buttonPositionX+10 && e.getY()>=buttonPositionY && e.getY()<=buttonPositionY+10){
            new NewMethodView(model,i).setVisible(true);
            return true;
        }
    	return false;
    }
    private boolean nameOfTheObject(MouseEvent e, int i){
    	if (e.getX()>=model.getObjectUmlAtIndex(i).getX()+20 && e.getX()<=model.getObjectUmlAtIndex(i).getX()+20+jPanelDrawingtable.lengthOf(model.getObjectUmlAtIndex(i).getName(), jPanelDrawingtable.getGraphics())
    		&& e.getY()>=model.getObjectUmlAtIndex(i).getY()+9 && e.getY()<=model.getObjectUmlAtIndex(i).getY()+21){
    		return true;
    	}
    	return false;
    
    }
    private boolean attributeOfTheObject(MouseEvent e, int i, int j){
    	if(e.getX()>=model.getObjectUmlAtIndex(i).getX()+20 && e.getX()<=model.getObjectUmlAtIndex(i).getX()+20+jPanelDrawingtable.lengthOf(model.getObjectUmlAtIndex(i).getAttributeAt(j).toString(), jPanelDrawingtable.getGraphics())
    			&& e.getY()>=model.getObjectUmlAtIndex(i).getY()+39+j*20 && e.getY()<=model.getObjectUmlAtIndex(i).getY()+51+j*20){
    		return true;
    	}
    	return false;
    }
    private boolean methodOfTheObject(MouseEvent e, int i, int j){
    	if(e.getX()>=model.getObjectUmlAtIndex(i).getX()+20 && e.getX()<=model.getObjectUmlAtIndex(i).getX()+20+jPanelDrawingtable.lengthOf(model.getObjectUmlAtIndex(i).getMehodAt(j).toString(), jPanelDrawingtable.getGraphics())
    		&& e.getY()>=model.getObjectUmlAtIndex(i).getY()+59+20*model.getObjectUmlAtIndex(i).attributListSize()+20*j && e.getY()<=model.getObjectUmlAtIndex(i).getY()+71+20*model.getObjectUmlAtIndex(i).attributListSize()+20*j){
    		return true;
    	}
    	return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        model.setSelectedObject(-1);
    }

}



