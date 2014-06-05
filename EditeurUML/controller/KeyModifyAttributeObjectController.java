package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



import view.ModifyAttributeObjectView;
import model.ProjectUML;


public class KeyModifyAttributeObjectController implements KeyListener {

	ModifyAttributeObjectView view;
	ProjectUML model;

	public KeyModifyAttributeObjectController(ModifyAttributeObjectView view,ProjectUML model){
		this.model=model;
		this.view=view;
		model.setWarning("");

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		boolean unique=true;
		if (view.getNameTextField().getText().equals("")){
			model.setWarning("Attribute name is empty");
			view.getOkButton().setEnabled(false);
		} else {
			for (int i=0; i<view.getModel().getObjectUmlAtIndex(view.getIndex()).attributListSize(); i++){
				if (view.getModel().getObjectUmlAtIndex(view.getIndex()).getAttributeAt(i).getName().equals(view.getNameTextField().getText())){
					unique=false;
				}
			}
			if (unique){
				model.setWarning("");
				view.getOkButton().setEnabled(true);
			}
			else {
				model.setWarning("This Attribute already exist");
				view.getOkButton().setEnabled(false);			
			}
			if(view.getNameTextField().getText().charAt(0)>='A'&&view.getNameTextField().getText().charAt(0)<='Z'){
				model.setWarning("Attribute Name begin with a lower case");
			}
		}
	}

}
