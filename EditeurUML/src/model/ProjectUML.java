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
	private int selectedObject;

	public ArrayList<ObjectUML> getObjectsList() {
		return objectsList;
	}

	public void setObjectsList(ArrayList<ObjectUML> objectsList) {
		this.objectsList = objectsList;
		setChanged();
		notifyObservers();
	}

	public ProjectUML(){
		objectsList = new ArrayList<ObjectUML>();
		addProject();
	}

	// Method for Development
	private void addProject() {
		ObjectUML object = new ObjectUML(1, objectsList.size());
		object.setName("Helo");
		object.addAttribute(new Attribute("Blablabam", "int", 1));
		object.addAttribute(new Attribute("test", "void", 0));
		object.addAttribute(new Attribute("Blab", "String", 2));
		object.addAttribute(new Attribute("test2", "long", 3));
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
	
}
