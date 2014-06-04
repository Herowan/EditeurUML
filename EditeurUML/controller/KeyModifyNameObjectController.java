package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import model.ProjectUML;
import view.ModifyNameObjectView;

public class KeyModifyNameObjectController implements KeyListener {

	
	private ModifyNameObjectView view;
	private ProjectUML model;

	public KeyModifyNameObjectController(ModifyNameObjectView view,ProjectUML model){
		this.view=view;
		this.model=model;
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
		if (!view.getNameJTextField().getText().equals("")){
			boolean unique=true;
			for (int i=0; i<view.getModel().objectsListSize();i++){
				if (view.getIndex()!=i
						&& view.getModel().getObjectUmlAtIndex(i).getName().equals(view.getNameJTextField().getText())){
					unique =false;
				}
			}
			if (unique){
				model.setWarning("");
				view.getOkButton().setEnabled(true);
			} else {
				model.setWarning("This Object already exist");
				view.getOkButton().setEnabled(false);			
			}
			if(!(view.getNameJTextField().getText().charAt(0)>='A'&&view.getNameJTextField().getText().charAt(0)<='Z')){
				model.setWarning("Object Name begin with an upper case");
			}
		} else {
			model.setWarning("Object name is empty");
			view.getOkButton().setEnabled(false);		}
	}

}
