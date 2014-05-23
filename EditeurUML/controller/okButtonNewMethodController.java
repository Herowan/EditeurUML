package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.NewMethodView;
import model.Method;
import model.Visibility;

public class okButtonNewMethodController implements ActionListener{
	NewMethodView newMethodView;
	
	public okButtonNewMethodController(NewMethodView newMethodView) {
		this.newMethodView=newMethodView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!newMethodView.getNameTextField().getText().equals("")){
			boolean unique=true;
			String visibility = (String) newMethodView.getVisibilityComboBox().getSelectedItem();
			Visibility visi;
			if (visibility.equals("private")) visi= Visibility.PRIVATE;
			else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
			else if (visibility.equals("default")) visi = Visibility.DEFAULT;
			else visi = Visibility.PUBLIC;
			Method newMethod = new Method(newMethodView.getNameTextField().getText(), (String) newMethodView.getReturnTypeComboBox().getSelectedItem(), visi, newMethodView.parameterValid());
			for (int i=0; i<newMethodView.getModel().getObjectUmlAtIndex(newMethodView.getIndex()).methodeListSize(); i++){
				if (newMethodView.getModel().getObjectUmlAtIndex(newMethodView.getIndex()).getMehodAt(i).equals(newMethod)){
					unique=false;
				}
			}
			if (unique){
				newMethodView.getModel().addMethod(newMethodView.getIndex(), newMethod);
				newMethodView.dispose();
			} else {
				JOptionPane.showMessageDialog(newMethodView, "This method already exist.");
			}
		} else {
			JOptionPane.showMessageDialog(newMethodView, "Take a name for your method please.");
		}		
	}

}
