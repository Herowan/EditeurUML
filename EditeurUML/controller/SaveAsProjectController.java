package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

import javax.swing.JFrame;

public class SaveAsProjectController extends IOController implements ActionListener{
	ProjectUML model;
	JFrame view;

	public SaveAsProjectController(ProjectUML model,JFrame view){
		this.model=model;
		this.view=view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		showSaveFileDialog(model,view);
		model.setIsSave(true);

	}

}

