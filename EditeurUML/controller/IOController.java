package controller;



import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import model.ProjectUML;

public class IOController {

	
	public void showSaveFileDialog(ProjectUML model,JFrame view) {

		JFileChooser fileChooserSave = new JFileChooser();
		fileChooserSave.setDialogTitle("Specify a file to save");
		UIManager.put("FileChooserSave.openButtonText","Save");
		int userSelection = fileChooserSave.showSaveDialog(view);
		if (userSelection == JFileChooser.APPROVE_OPTION) {

			
			String fileName=fileChooserSave.getSelectedFile().getAbsolutePath();
			if(!fileName.substring(fileName.length()-4).equals(".uml")){
				fileName+=".uml";
			}
			System.out.println(fileName);
			model.setSavePath(fileName);
			model.setIsSave(true);
			model.saveProjectAs(fileName);
			
		}
	}
	
	public void save(ProjectUML model,JFrame view) throws ClassNotFoundException{
		System.out.println(model.getSavePath());
		if(model.getSavePath()==null){
			showSaveFileDialog(model, view);
		}else{
			model.saveProject();
		}
	}
	
	public void showOpenFileDialog(ProjectUML model,JFrame view) throws ClassNotFoundException{
		JFileChooser fileChooserOpen = new JFileChooser();
		fileChooserOpen.setDialogTitle("Specify a file to open");
		UIManager.put("FileChooserOpen.openButtonText","Save");

		int userSelection = fileChooserOpen.showOpenDialog(view);
		if (userSelection == JFileChooser.OPEN_DIALOG) {

			String fileName=fileChooserOpen.getSelectedFile().getAbsolutePath();
			model.openProject(fileName);
			
		}
	}
	
	
	
	
	
}
