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
		String visibility = (String) modifyMethodView.getVisibilityComboBox().getSelectedItem();

		Visibility visi;
		if (visibility.equals("private")) visi= Visibility.PRIVATE;
		else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
		else if (visibility.equals("default")) visi = Visibility.DEFAULT;
		else visi = Visibility.PUBLIC;
		
		modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setName(modifyMethodView.getNameTextField().getText());
		modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setReturnType((String) modifyMethodView.getReturnTypeComboBox().getSelectedItem());
		modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setVisibilityM(visi);
		modifyMethodView.getModel().getObjectUmlAtIndex(modifyMethodView.getIndex()).getMehodAt(modifyMethodView.getMethod()).setParams(modifyMethodView.parameterValid());
		modifyMethodView.dispose();

	}
}
