package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.NewAttributeView;
import model.Attribute;
import model.ProjectUML;
import model.Visibility;

public class KeyNewAttributeController implements KeyListener {

	NewAttributeView view;
	ProjectUML model;

	public KeyNewAttributeController(NewAttributeView view,ProjectUML model) {
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
		if (!view.getNameTextField().getText().equals("")){
			boolean unique=true;
			String visibility = (String) view.getVisibilityComboBox().getSelectedItem();
			Visibility visi;
			if (visibility.equals("private")) visi= Visibility.PRIVATE;
			else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
			else if (visibility.equals("default")) visi = Visibility.DEFAULT;
			else visi = Visibility.PUBLIC;
			Attribute newAttribute = new Attribute(view.getNameTextField().getText(),(String) view.getTypeComboBox().getSelectedItem(),visi);

			for (int i=0; i<view.getModel().getObjectUmlAtIndex(view.getIndex()).attributListSize(); i++){
				if (view.getModel().getObjectUmlAtIndex(view.getIndex()).getAttributeAt(i).equals(newAttribute)){
					unique=false;
				}
			}

			if (unique){
				model.setWarning("");
				view.getOkButton().setEnabled(true);
			} else {
				model.setWarning("This Attribute already exist");
				view.getOkButton().setEnabled(false);
			}
			if(view.getNameTextField().getText().charAt(0)>='A'&&view.getNameTextField().getText().charAt(0)<='Z'){
				model.setWarning("Attribute Name begin with a lower case");
			}
		} else {
			model.setWarning("Attribute name is empty");
			view.getOkButton().setEnabled(false);
		}			
	}

}
