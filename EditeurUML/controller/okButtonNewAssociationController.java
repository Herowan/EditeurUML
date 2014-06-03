package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NewAssociationView;
import model.Association;
import model.ProjectUML;

public class okButtonNewAssociationController implements ActionListener {
	ProjectUML model;
	NewAssociationView view;

	public okButtonNewAssociationController(ProjectUML model,NewAssociationView view) {
		this.model=model;
		this.view=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Association a = new Association(model.getObjectUmlAtIndex(view.getClass1ComboBox().getSelectedIndex()), model.getObjectUmlAtIndex(view.getClass2ComboBox().getSelectedIndex()), 3,view.getNameTextField().getText());
		model.getAssociationList().add(a);
		view.dispose();
	}

}
