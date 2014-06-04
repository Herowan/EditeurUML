package controller;

import java.awt.event.ActionListener;


import view.ModifyNameObjectView;

public class okButtonModifyNameController implements ActionListener{
	ModifyNameObjectView view;
	

	public okButtonModifyNameController(ModifyNameObjectView view) {
		this.view=view;
	}
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		
				view.getModel().getTypes().remove(view.getModel().getObjectUmlAtIndex(view.getIndex()).getName());
				view.getModel().getTypes().addType(view.getNameJTextField().getText());
				view.getModel().getObjectUmlAtIndex(view.getIndex()).setName(view.getNameJTextField().getText());
				view.dispose();
		
	}
}
