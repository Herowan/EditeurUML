package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import model.ProjectUML;

public class NewProjectController extends IOController implements ActionListener {
	ProjectUML model;
	JFrame view;
	public NewProjectController(ProjectUML model,JFrame view){
		this.model=model;
		this.view=view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(model.isSave()){
			model.resetProject();
		}else if(!(model.getSavePath()==null)){
			try {
				save(model,view);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model.resetProject();

		}else{
			showSaveFileDialog(model,view);
			model.resetProject();

		}
	}
	
	
	
	



}
