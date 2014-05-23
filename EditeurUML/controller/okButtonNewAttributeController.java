package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.NewAttributeView;
import model.Attribute;
import model.Visibility;

public class okButtonNewAttributeController implements ActionListener{
	
	NewAttributeView newAttributeView;
	
	public okButtonNewAttributeController(NewAttributeView newAttributeView) {
		this.newAttributeView=newAttributeView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean unique=true;
		String visibility = (String) newAttributeView.getVisibilityComboBox().getSelectedItem();
		Visibility visi;
		if (visibility.equals("private")) visi= Visibility.PRIVATE;
		else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
		else if (visibility.equals("default")) visi = Visibility.DEFAULT;
		else visi = Visibility.PUBLIC;
		Attribute newAttribute = new Attribute(newAttributeView.getNameTextField().getText(),(String) newAttributeView.getTypeComboBox().getSelectedItem(),visi);
		
		for (int i=0; i<newAttributeView.getModel().getObjectUmlAtIndex(newAttributeView.getIndex()).attributListSize(); i++){
			if (newAttributeView.getModel().getObjectUmlAtIndex(newAttributeView.getIndex()).getAttributeAt(i).getName().equals(newAttribute.getName())){
				unique=false;
			}
		}
		
		if (unique){
			newAttributeView.getModel().addAttribute(newAttributeView.getIndex(),newAttribute);
			newAttributeView.dispose();
		} else{
			JOptionPane.showMessageDialog(newAttributeView, "This attribute already exist.");
		}
	}

}
