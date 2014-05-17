package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import model.ObjectUML;
import model.ProjectUML;

public class IOController {

	
	public void showSaveFileDialog(ProjectUML model,JFrame view) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		UIManager.put("FileChooser.openButtonText","Save");
		int userSelection = fileChooser.showSaveDialog(view);
		if (userSelection == JFileChooser.APPROVE_OPTION) {

			String fileName=fileChooser.getSelectedFile().getAbsolutePath()+".uml";
			model.setSavePath(fileName);
			model.setIsSave(true);
			try {
				FileOutputStream fichier = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(fichier);
				out.writeObject(model.getObjectsList());
				out.flush();
				out.close();
			}
			catch (java.io.IOException e) {
				System.out.println("FAIL out");
				e.printStackTrace();
			}
		}
	}
	
	public void save(ProjectUML model,JFrame view) throws ClassNotFoundException{
		if(model.getSavePath()==null){
			showOpenFileDialog(model, view);
		}else{
			try {
				FileOutputStream fichier = new FileOutputStream(model.getSavePath());
				ObjectOutputStream out = new ObjectOutputStream(fichier);
				out.writeObject(model.getObjectsList());
				out.flush();
				out.close();
				model.setIsSave(true);
			}
			catch (java.io.IOException e) {
				System.out.println("FAIL out");
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void showOpenFileDialog(ProjectUML model,JFrame view) throws ClassNotFoundException{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to open");

		int userSelection = fileChooser.showSaveDialog(view);
		if (userSelection == JFileChooser.APPROVE_OPTION) {

			String fileName=fileChooser.getSelectedFile().getAbsolutePath();
			try {
				FileInputStream fichier = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fichier);
				model.setObjectsList((ArrayList<ObjectUML>)in.readObject());
				in.close();
			}
			catch (java.io.IOException e) {
				System.out.println("FAIL in");
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
