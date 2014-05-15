package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ProjectUML;

public class AddObjectControler implements ActionListener{

    private int type;
    private ProjectUML model;
   
    public AddObjectControler(int type, ProjectUML model){
        this.type=type;
        this.model=model;
    }
   
    @Override
    public void actionPerformed(ActionEvent arg0) {
        model.addObjectUml(type);
    }

}