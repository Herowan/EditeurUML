package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EditeurUML;

public class RedoController implements ActionListener{

	EditeurUML model;
	
	
	public RedoController(EditeurUML model){
		this.model=model;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		model.Redo();
	}
	
	
	
	
}

