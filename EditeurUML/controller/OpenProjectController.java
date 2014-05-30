package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.MainView;
import model.EditeurUML;

public class OpenProjectController extends IOController implements ActionListener{
	EditeurUML model;
	MainView view;
	
	public OpenProjectController(EditeurUML model,MainView view){
		this.model=model;
		this.view=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(model.getProject().isSave());
		if(model.getProject().isSave()){
			openFile();
		}else{
			if(JOptionPane.showConfirmDialog(view, "This Project is not save, Want you save it ?", "Etiquettes Java", JOptionPane.YES_NO_OPTION)==0){
				try {
					save(model,view);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
		openFile();
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

