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
		objectsList=new ArrayList<ObjectUML>();
		
		addProject();
	}

	// Method for Development
	private void addProject() {
		ObjectUML object = new ObjectUML(1, objectsList.size());
		object.setName("Classe test");
		objectsList.add(object);
	}
	
}
