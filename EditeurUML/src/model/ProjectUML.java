package model;

import java.util.ArrayList;
/**
 * 
 * @author Dashell
 *
 */
public class ProjectUML {
	ArrayList<ObjectUML> objectsList;


	public ProjectUML(){
		objectsList = new ArrayList<ObjectUML>();
		addProject();
	}

	// Method for Development
	private void addProject() {
		ObjectUML object = new ObjectUML(1, objectsList.size());
		object.setName("Classe Test");
		objectsList.add(object);
	}
	
	public ObjectUML getObjectUmlAtIndex(int index){
		return objectsList.get(index);
	}
	
	public int objectsListSize(){
		return objectsList.size();
	}
	
}
