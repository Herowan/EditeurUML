package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.EditeurUML;
import model.ProjectUML;

public class NewProjectController extends IOController implements ActionListener {
	EditeurUML model;
	JFrame view;
	public NewProjectController(EditeurUML model,JFrame view){
		this.model=model;
		this.view=view;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(model.getProject().isSave()){
			model.getProject().resetProject();
		}else if(!(model.getProject().getSavePath()==null)){
			try {
				save(model,view);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model.getProject().resetProject();

		}else{
			showSaveFileDialog(model,view);
			model.getProject().resetProject();

		}
	}
	
	
	
	



}
