package controller;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.ModifyNameObjectView2;

public class okButtonModifyNameController implements ActionListener{
	ModifyNameObjectView2 view;
	

	public okButtonModifyNameController(ModifyNameObjectView2 view) {
		this.view=view;
	}
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		if (!view.getNameJTextField().equals("")){
			boolean unique=true;
			for (int i=0; i<view.getModel().objectsListSize();i++){
				if (view.getIndex()!=i
						&& view.getModel().getObjectUmlAtIndex(i).getName().equals(view.getNameJTextField().getText())){
					unique =false;
				}
			}
			if (unique){
				view.getModel().getTypes().remove(view.getModel().getObjectUmlAtIndex(view.getIndex()).getName());
				view.getModel().getTypes().addType(view.getNameJTextField().getText());
				view.getModel().getObjectUmlAtIndex(view.getIndex()).setName(view.getNameJTextField().getText());
				view.dispose();
			} else {
				JOptionPane.showMessageDialog(view, "This class already exist.");
			}
		} else {
			JOptionPane.showMessageDialog(view, "Take a name for your class please.");
		}
	}
}
