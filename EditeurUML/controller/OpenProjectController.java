


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

public class OpenProjectController implements ActionListener{
ProjectUML model;
JFrame view;
public OpenProjectController(ProjectUML model,JFrame view){
this.model=model;
this.view=view;
}
@SuppressWarnings("unchecked")
public void showOpenFileDialog() throws ClassNotFoundException{
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
@Override
public void actionPerformed(ActionEvent e) {
try {
showOpenFileDialog();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
}

}