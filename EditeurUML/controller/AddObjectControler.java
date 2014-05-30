package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EditeurUML;
import model.ProjectUML;
import model.TypeObject;

public class AddObjectControler implements ActionListener{

    private TypeObject type;
    private ProjectUML model;

  
    public AddObjectControler(TypeObject type, EditeurUML model){
        this.type=type;
        this.model=model.getProject();
    }
   

    @Override
    public void actionPerformed(ActionEvent arg0) {
        model.addObjectUml(type);
		model.setIsSave(false);
    }

    public void setModel(ProjectUML model){
    	this.model=model;
    }
}
