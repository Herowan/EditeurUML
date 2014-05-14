package model;

import java.util.ArrayList;
import java.util.Observable;
/**
 * 
 * @author Dashell
 *
 */
public class ProjectUML extends Observable{
	private ArrayList<ObjectUML> objectsList;


	public ProjectUML(){
		objectsList = new ArrayList<ObjectUML>();
		addProject();
	}

	// Method for Development
	private void addProject() {
		ObjectUML object = new ObjectUML(1, objectsList.size());
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
	
}
