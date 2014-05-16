package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import model.ProjectUML;

public class SaveProjectController extends IOController implements ActionListener{

	ProjectUML model;
	JFrame view;
	public SaveProjectController(ProjectUML model,JFrame view){
		this.model=model;
		this.view=view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(model.getSavePath()==null){
			showSaveFileDialog(model,view);
			model.setIsSave(true);
		}else{
			save(model,view);	
			model.setIsSave(true);

		}
	}
}
