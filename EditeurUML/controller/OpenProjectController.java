package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import view.MainView;
import model.ProjectUML;

public class OpenProjectController extends IOController implements ActionListener{
	ProjectUML model;
	MainView view;
	
	public OpenProjectController(ProjectUML model,MainView view){
		this.model=model;
		this.view=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(model.isSave()){
			
			openFile();
		}else{
			openFile();
		}
	}
	
	public void openFile(){
		try {
			showOpenFileDialog(model,view);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

