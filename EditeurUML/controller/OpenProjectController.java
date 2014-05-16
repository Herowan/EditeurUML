package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import model.ObjectUML;
import model.ProjectUML;

public class OpenProjectController extends IOController implements ActionListener{
	ProjectUML model;
	JFrame view;
	public OpenProjectController(ProjectUML model,JFrame view){
		this.model=model;
		this.view=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			showOpenFileDialog(model,view);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

