package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.ModifyAttributeObjectView2;
import model.Visibility;

public class okButtonModifyAttributeController implements ActionListener{
	
	ModifyAttributeObjectView2 modifyAttributeView;
	
	public okButtonModifyAttributeController(ModifyAttributeObjectView2 modifyAttributeView) {
		this.modifyAttributeView=modifyAttributeView;
	}

	public void actionPerformed(ActionEvent e) {
		boolean unique=true;
		if (modifyAttributeView.getNameTextField().getText().equals("")){
			JOptionPane.showMessageDialog(modifyAttributeView, "Take a name for your attribute please.");
		} else {
			for (int i=0; i<modifyAttributeView.getModel().getObjectUmlAtIndex(modifyAttributeView.getIndex()).attributListSize(); i++){
				if (modifyAttributeView.getModel().getObjectUmlAtIndex(modifyAttributeView.getIndex()).getAttributeAt(i).getName().equals(modifyAttributeView.getNameTextField().getText())){
					unique=false;
				}
			}
			if (unique){
				modifyAttributeView.getModel().getObjectUmlAtIndex(modifyAttributeView.getIndex()).getAttributeAt(modifyAttributeView.getAttribute()).setName(modifyAttributeView.getNameTextField().getText());
				String visibility = (String) modifyAttributeView.getVisibilityComboBox().getSelectedItem();
				Visibility visi;
				if (visibility.equals("private")) visi= Visibility.PRIVATE;
				else if (visibility.equals("protected")) visi =Visibility.PROTECTED;
				else if (visibility.equals("default")) visi = Visibility.DEFAULT;
				else visi = Visibility.PUBLIC;
				modifyAttributeView.getModel().getObjectUmlAtIndex(modifyAttributeView.getIndex()).getAttributeAt(modifyAttributeView.getAttribute()).setVisibilityA(visi);
				modifyAttributeView.getModel().getObjectUmlAtIndex(modifyAttributeView.getIndex()).getAttributeAt(modifyAttributeView.getAttribute()).setType(modifyAttributeView.getModel().getTypes().getTypeAt(modifyAttributeView.getTypeComboBox().getSelectedIndex()));
				modifyAttributeView.dispose();
			}
			else {
				JOptionPane.showMessageDialog(modifyAttributeView, "This attribute already exist.");
			}
		}
	}
}
