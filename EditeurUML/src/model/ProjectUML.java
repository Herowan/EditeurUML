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
	
	
	
}
