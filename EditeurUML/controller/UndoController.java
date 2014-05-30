package controller;

import model.EditeurUML;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoController implements ActionListener{


	EditeurUML model;
	
	
	public UndoController(EditeurUML model){
		this.model=model;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		model.Undo();
	}	
}
