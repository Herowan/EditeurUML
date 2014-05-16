package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;
/**
 * 
 * @author Dashell
 *
 */

public class ProjectUML extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ObjectUML> objectsList;
	private ArrayList<Association> associationList;
	private int selectedObject;
	private String savePath=null; // save du chemin ou est enregistr�� le projet pour le controller Save
	private boolean isSave=false;
	private Type types;

	public ProjectUML(){
		objectsList = new ArrayList<ObjectUML>();
		associationList = new ArrayList<Association>();
		types=new Type();
		addProject();
	}
	
	//Method for New Project
	
	public void resetProject(){
		objectsList.clear();
		associationList.clear();
	}

	// Method for Development
	private void addProject() {
		ObjectUML object = new ObjectUML(1, objectsList.size());
		object.setName("Hello");
		object.addAttribute(new Attribute("Blablabam", "int", Visibility.PRIVATE));
		object.addAttribute(new Attribute("test", "void", Visibility.PROTECTED));
		object.addAttribute(new Attribute("Blab", "String", Visibility.PROTECTED));
		object.addAttribute(new Attribute("test2", "long", Visibility.PUBLIC));
		ArrayList<String> liste1= new ArrayList<String>();
		liste1.add("int");
		liste1.add("int");
		liste1.add("String");
		object.addMethod(new Method("HelloWorld", "void", Visibility.DEFAULT, liste1));
		ArrayList<String> liste2= new ArrayList<String>();
		object.addMethod(new Method("Banana", "int", Visibility.PRIVATE, liste2));
		objectsList.add(object);

		ObjectUML object2 = new ObjectUML(1, objectsList.size());
		objectsList.add(object2);

	}

	public ObjectUML getObjectUmlAtIndex(int index){
		return objectsList.get(index);
	}

	public int objectsListSize(){
		return objectsList.size();
	}

	public void addObjectUml(int type){
		objectsList.add(new ObjectUML(type, objectsListSize()));
		types.addType(objectsList.get(objectsListSize()-1).getName());
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<ObjectUML> getObjectsList() {
		return objectsList;
	}

	public void setObjectsList(ArrayList<ObjectUML> objectsList) {
		this.objectsList = objectsList;
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Association> getAssociationList() {
		return associationList;
	}

	public void setAssociationList(ArrayList<Association> associationList) {
		this.associationList = associationList;
		setChanged();
		notifyObservers();
	}
	

	//Method about Serialization , let's go !!

	public void saveProject(String projectName){
		try {
			FileOutputStream fichier = new FileOutputStream(projectName);
			ObjectOutputStream out = new ObjectOutputStream(fichier);
			out.writeObject(objectsList);
			out.flush();
			out.close();
		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}

	}

	public void addAttribute(int index, Attribute attribute){
		objectsList.get(index).addAttribute(attribute);
		setChanged();
		notifyObservers();
	}
	public void addMethod(int index, Method method){
		objectsList.get(index).addMethod(method);
		setChanged();
		notifyObservers();
	}
	
	public void setPositionObject(int x, int y, int index){
		objectsList.get(index).setPosition(x, y);
		setChanged();
		notifyObservers();
	}

	public int getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(int selectedObject) {
		this.selectedObject = selectedObject;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public boolean isSave() {
		return isSave;
	}

	public void setIsSave(boolean isSave) {
		this.isSave=isSave;
	}

	public Type getTypes() {
		return types;
	}
	
	
}
