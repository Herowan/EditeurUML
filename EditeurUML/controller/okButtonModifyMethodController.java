package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Method;
import model.Visibility;
import view.ModifyMethodObjectView;

public class okButtonModifyMethodController implements ActionListener{
	
	ModifyMethodObjectView modifyMethodView;
	
	public okButtonModifyMethodController(ModifyMethodObjectView modifyMethodView) {
		this.modifyMethodView=modifyMethodView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!modifyMethodView.getNameTextField().getText().equals("")){
			boolean unique=true;
			String visibility = (String) modifyMethodView.getVisibilityComboBox().getSelectedItem();
			Visibility visi;
			if (visibility.equals("private")) visi= Visibility.PRIVATE;
			else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
			else if (visibility.equals("default")) visi = Visibility.DEFAULT;
			else visi = Visibility.PUBLIC;
			Method newMethod = new Method(modifyMethodView.getNameTextField().getText(), (String) modifyMethodView.getReturnTypeComboBox().getSelectedItem(), visi, modifyMethodView.parameterValid());

			for (int i=0; i<modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).methodeListSize(); i++){
				if (modifyMethodView.getMethod()!=i
						&& modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(i).equals(newMethod)){
					unique=false;
				}
			}
			if (unique){			
				modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setName(modifyMethodView.getNameTextField().getText());
				modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setReturnType((String) modifyMethodView.getReturnTypeComboBox().getSelectedItem());
				modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setVisibilityM(visi);
				modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setParams(modifyMethodView.parameterValid());
				modifyMethodView.dispose();
			} else {
				JOptionPane.showMessageDialog(modifyMethodView, "This method already exist.");
			}
		} else {
			JOptionPane.showMessageDialog(modifyMethodView, "Take a name for your method please.");
		}		
	}
}
