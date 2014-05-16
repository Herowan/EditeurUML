package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import model.ProjectUML;

public class ExitProjectController extends IOController implements ActionListener{

	ProjectUML model;
	MainView view;
	
	public ExitProjectController(ProjectUML model,MainView view){
		this.model=model;
		this.view=view;
	}
	public void actionPerformed(ActionEvent e) {
		view.exitSoftware();
	}
}
