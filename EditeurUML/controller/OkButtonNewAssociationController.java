package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NewAssociationView;
import model.Association;
import model.ProjectUML;

public class OkButtonNewAssociationController implements ActionListener {
	ProjectUML model;
	NewAssociationView view;
	int type;
	
	public OkButtonNewAssociationController(ProjectUML model,NewAssociationView view, int type) {
		this.type=type;
		this.model=model;
		this.view=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Association a = new Association(model.getObjectUmlAtIndex(view.getClass1ComboBox().getSelectedIndex()), model.getObjectUmlAtIndex(view.getClass2ComboBox().getSelectedIndex()), type,view.getNameTextField().getText());
		model.getAssociationList().add(a);
		view.dispose();
	}

}
