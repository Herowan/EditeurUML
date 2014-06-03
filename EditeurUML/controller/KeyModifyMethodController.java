package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import model.Method;
import model.ProjectUML;
import model.Visibility;
import view.ModifyMethodObjectView;

public class KeyModifyMethodController implements KeyListener {

	private ModifyMethodObjectView view;
	private String name;
	ProjectUML model;

	public KeyModifyMethodController(ModifyMethodObjectView view,ProjectUML model,String name){
		this.view=view;
		this.name=name;
		this.model=model;
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
		if (!name.equals("")){
			boolean unique=true;
			String visibility = (String) view.getVisibilityComboBox().getSelectedItem();
			Visibility visi;
			if (visibility.equals("private")) visi= Visibility.PRIVATE;
			else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
			else if (visibility.equals("default")) visi = Visibility.DEFAULT;
			else visi = Visibility.PUBLIC;
			Method newMethod = new Method(name, (String) view.getReturnTypeComboBox().getSelectedItem(), visi, view.parameterValid());

			for (int i=0; i<view.getModel().getObjectUmlAtIndex(view.getIndex()).methodeListSize(); i++){
				if (view.getMethod()!=i
						&& view.getModel().getObjectUmlAtIndex(view.getIndex()).getMehodAt(i).equals(newMethod)){
					unique=false;
				}
			}
			if (unique){			
				view.getOkButton().setEnabled(false);
			} else {
				model.setWarning("This method already exist");
				view.getOkButton().setEnabled(false);
			}
		} else {
			model.setWarning("Method name is empty");
		}		
		if(name.charAt(0)>='A'&&name.charAt(0)<='Z'){
			model.setWarning("Method Name begin with a lower case");
		}
	}

}

