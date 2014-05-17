package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ProjectUML;
import view.MainView;

public class YesSaveButtonController extends IOController implements ActionListener{

	ProjectUML model;
	MainView view;
	
	public YesSaveButtonController(ProjectUML model,MainView view){
	this.model=model;
	this.view=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!(model.getSavePath()==null)){
			try {
				save(model,view);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else{
			showSaveFileDialog(model,view);
		}
	}

}
