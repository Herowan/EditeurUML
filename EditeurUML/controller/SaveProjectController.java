package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import model.ProjectUML;

public class SaveProjectController implements ActionListener{

ProjectUML model;
JFrame view;
public SaveProjectController(ProjectUML model,JFrame view){
this.model=model;
this.view=view;
}

public void save(){
if(model.getSavePath()==null){
new SaveAsProjectController(model, this.view);
}else{
try {
FileOutputStream fichier = new FileOutputStream(model.getSavePath());
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
private void showSaveFileDialog() {

JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Specify a file to save");
UIManager.put("FileChooser.openButtonText","Save");
int userSelection = fileChooser.showSaveDialog(view);
if (userSelection == JFileChooser.APPROVE_OPTION) {

String fileName=fileChooser.getSelectedFile().getAbsolutePath();
if(!fileName.substring(fileName.length()-4).equals(".uml")){
fileName+=".uml";
}
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
public void actionPerformed(ActionEvent e) {
if(model.getSavePath()==null){
showSaveFileDialog();
}else{
save();	
}
}
}