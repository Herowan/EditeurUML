package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import model.Method;
import model.ProjectUML;
import model.Visibility;
import view.ModifyMethodObjectView;

public class KeyModifyMethodController implements KeyListener {

	private ModifyMethodObjectView view;
	private ProjectUML model;

	public KeyModifyMethodController(ModifyMethodObjectView view,ProjectUML model){
		this.view=view;
		this.model=model;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!view.getNameTextField().getText().equals("")){
			boolean unique=true;
			String visibility = (String) view.getVisibilityComboBox().getSelectedItem();
			Visibility visi;
			if (visibility.equals("private")) visi= Visibility.PRIVATE;
			else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
			else if (visibility.equals("default")) visi = Visibility.DEFAULT;
			else visi = Visibility.PUBLIC;
			Method newMethod = new Method(view.getNameTextField().getText(), (String) view.getReturnTypeComboBox().getSelectedItem(), visi, view.parameterValid());

			for (int i=0; i<view.getModel().getObjectUmlAtIndex(view.getIndex()).methodeListSize(); i++){
				if (view.getMethod()!=i
						&& view.getModel().getObjectUmlAtIndex(view.getIndex()).getMehodAt(i).equals(newMethod)){
					unique=false;
				}
			}
			if (unique){
				model.setWarning("");

				view.getOkButton().setEnabled(true);
			} else {
				model.setWarning("This method already exist");
				view.getOkButton().setEnabled(false);
			}
			if(view.getNameTextField().getText().charAt(0)>='A'&&view.getNameTextField().getText().charAt(0)<='Z'){
				model.setWarning("Method Name begin with a lower case");
			}
		} else {
			model.setWarning("Method name is empty");
			view.getOkButton().setEnabled(false);
		}		
	}

}

