package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.ProjectUML;
import view.MainView;
import view.NewAssociationView;

public class AssociationController implements ActionListener {
	
	int type;
	ProjectUML model;
	MainView view;
	
	public AssociationController(MainView view, ProjectUML model,int type) {
		this.type=type;
		this.model=model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.objectsListSize() <2){
    		JOptionPane.showMessageDialog(view, "Create at least 2 Objects");
    	} else {
			new NewAssociationView(model,type).setVisible(true);
    	}
		
	}

	public void setModel(ProjectUML project) {
		this.model=project;		
	}
}
