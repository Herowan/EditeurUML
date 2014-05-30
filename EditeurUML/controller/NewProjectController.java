package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.EditeurUML;

public class NewProjectController extends IOController implements ActionListener {
	EditeurUML model;
	JFrame view;
	public NewProjectController(EditeurUML model,JFrame view){
		this.model=model;
		this.view=view;
	}


	public void actionPerformed(ActionEvent e){
		if(model.getProject().isSave()){
			model.getProject().resetProject();
		}else{
			if(JOptionPane.showConfirmDialog(view, "This Project is not save, Want you save it ?", "Etiquettes Java", JOptionPane.YES_NO_OPTION)==0){
				try {
					save(model,view);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			model.getProject().resetProject();	
		}
	}







}
