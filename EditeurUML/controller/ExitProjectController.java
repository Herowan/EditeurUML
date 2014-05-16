package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.ProjectUML;

public class ExitProjectController extends IOController implements ActionListener{

	ProjectUML model;
	JFrame view;
	
	public ExitProjectController(ProjectUML model,JFrame view){
		this.model=model;
		this.view=view;
	}
	public void actionPerformed(ActionEvent e) {
		if(model.isSave()){
			view.dispose();
		}else if(!(model.getSavePath()==null)){
			try {
				save(model,view);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}	
			view.dispose();
		}else{
			showSaveFileDialog(model,view);
			view.dispose();
		}
	}
}
