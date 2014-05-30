package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EditeurUML;
import model.ProjectUML;
import model.TypeObject;

public class AddObjectControler implements ActionListener{

    private TypeObject type;
    private EditeurUML model;

  
    public AddObjectControler(TypeObject type, EditeurUML model){
        this.type=type;
        this.model=model;
    }
   

    @Override
    public void actionPerformed(ActionEvent arg0) {
        model.getProject().addObjectUml(type);
    }

}
