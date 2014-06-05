package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ModifyAssociationView;
import model.ProjectUML;

public class OkButtonModifyAssociationController implements ActionListener {

	ProjectUML model;
	ModifyAssociationView view;
	int type;
	int index;

	public OkButtonModifyAssociationController(ProjectUML model,
			ModifyAssociationView modifyAssociationView, int type, int i) {
		this.model=model;
		this.view=modifyAssociationView;
		this.type=type;
		this.index=i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.getAssociationList().get(index).setFirstObject(model.getObjectUmlAtIndex(view.getClass1ComboBox().getSelectedIndex()));
		model.getAssociationList().get(index).setLastObject(model.getObjectUmlAtIndex(view.getClass2ComboBox().getSelectedIndex()));
		model.getAssociationList().get(index).setName(view.getNameTextField().getText());


		view.dispose();
	}

}