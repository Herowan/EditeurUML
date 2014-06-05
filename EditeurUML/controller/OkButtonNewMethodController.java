package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import view.NewMethodView;
import model.Method;
import model.Visibility;

public class OkButtonNewMethodController implements ActionListener{
	NewMethodView newMethodView;

	public OkButtonNewMethodController(NewMethodView newMethodView) {
		this.newMethodView=newMethodView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String visibility = (String) newMethodView.getVisibilityComboBox().getSelectedItem();
		Visibility visi;
		if (visibility.equals("private")) visi= Visibility.PRIVATE;
		else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
		else if (visibility.equals("default")) visi = Visibility.DEFAULT;
		else visi = Visibility.PUBLIC;

		
		Method newMethod = new Method(newMethodView.getNameTextField().getText(), (String) newMethodView.getReturnTypeComboBox().getSelectedItem(), visi, newMethodView.parameterValid());
		newMethodView.getModel().addMethod(newMethodView.getIndex(), newMethod);
		newMethodView.dispose();

	}

}
