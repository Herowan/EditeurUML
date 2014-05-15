


package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import model.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class SaveAsProjectController implements ActionListener{
ProjectUML model;
JFrame view;

public SaveAsProjectController(ProjectUML model,JFrame view){
this.model=model;
this.view=view;
}

private void showSaveFileDialog() {

JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Specify a file to save");
UIManager.put("FileChooser.openButtonText","Save");
int userSelection = fileChooser.showSaveDialog(view);
if (userSelection == JFileChooser.APPROVE_OPTION) {

String fileName=fileChooser.getSelectedFile().getAbsolutePath()+".uml";
model.setSavePath(fileName);
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


@Override
public void actionPerformed(ActionEvent arg0) {
showSaveFileDialog();
}

}