package controller;

import java.awt.event.ActionListener;


import view.ModifyNameObjectView;

public class OkButtonModifyNameController implements ActionListener{
ModifyNameObjectView view;


public OkButtonModifyNameController(ModifyNameObjectView view) {
this.view=view;
}
public void actionPerformed(java.awt.event.ActionEvent evt) {

view.getModel().getTypes().remove(view.getModel().getObjectUmlAtIndex(view.getIndex()).getName());
view.getModel().getTypes().addType(view.getNameJTextField().getText());
view.getModel().getObjectUmlAtIndex(view.getIndex()).setName(view.getNameJTextField().getText());
view.dispose();
}
}