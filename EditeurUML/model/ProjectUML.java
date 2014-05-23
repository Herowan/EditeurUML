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
	// For the JpanelDrawingTable view
	private int selectedObject;
	private String savePath=null; // save du chemin ou est enregistr�� le projet pour le controller Save
	private boolean isSave=false;
	private Type types;
	
	// Attributes selected for the view
	private int nameSelected=-1;
	private int attributeSelected=-1;
	private int objectOfAttributeSelected=-1;
	private int methodSelected=-1;
	private int objectOfMethodSelected =-1;

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
		savePath=null;
		setChanged();
		notifyObservers();
	}

	// Method for Development
	private void addProject() {
		ObjectUML object = new ObjectUML(TypeObject.CLASS,  objectsList.size(), objectWhoHaveType(TypeObject.CLASS));
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

		ObjectUML object2 = new ObjectUML(TypeObject.CLASS, objectsList.size(), objectWhoHaveType(TypeObject.CLASS));
		objectsList.add(object2);

	}

	public ObjectUML getObjectUmlAtIndex(int index){
		return objectsList.get(index);
	}

	public int objectsListSize(){
		return objectsList.size();
	}
	
	private int objectWhoHaveType(TypeObject type){
		int count=0;
		for (int i=0; i<objectsListSize(); i++){
			if (getObjectUmlAtIndex(i).getObjectType()==type){
				count++;
			}
		}
		return count;
	}

	public void addObjectUml(TypeObject type){
		objectsList.add(new ObjectUML(type,  objectsListSize(),objectWhoHaveType(type)));
		
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
	


	public void deleteObjectUml(int index){
		objectsList.remove(index);
		setChanged();
		notifyObservers();
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

	public int getNameSelected() {
		return nameSelected;
	}

	public void setNameSelected(int nameSelected) {
		this.nameSelected = nameSelected;
		
		setChanged();
		notifyObservers();
	}

	public int getAttributeSelected() {
		return attributeSelected;
	}

	public void setAttributeSelected(int attributeSelected) {
		this.attributeSelected = attributeSelected;
	}

	public int getObjectOfAttributeSelected() {
		return objectOfAttributeSelected;
	}

	public void setObjectOfAttributeSelected(int objectOfAttributeSelected) {
		this.objectOfAttributeSelected = objectOfAttributeSelected;
	}

	public int getMethodSelected() {
		return methodSelected;
	}

	public void setMethodSelected(int methodSelected) {
		this.methodSelected = methodSelected;
	}

	public int getObjectOfMethodSelected() {
		return objectOfMethodSelected;
	}

	public void setObjectOfMethodSelected(int objectOfMethodSelected) {
		this.objectOfMethodSelected = objectOfMethodSelected;
	}
	
	public void saveProject(){
		try {
			this.setIsSave(true);
			FileOutputStream fichier = new FileOutputStream(this.getSavePath());
			ObjectOutputStream out = new ObjectOutputStream(fichier);
			out.writeObject(this);
			out.flush();
			out.close();
		}
		catch (java.io.IOException e) {
			System.out.println("FAIL out");
			e.printStackTrace();
		}
	}
	
	public void saveProjectAs(String path){
		try {
			this.setIsSave(true);
			FileOutputStream fichier = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fichier);
			out.writeObject(this);
			out.flush();
			out.close();
		}
		catch (java.io.IOException e) {
			System.out.println("FAIL out");
			e.printStackTrace();
		}
	}
	
	public void openProject(String path) throws ClassNotFoundException{
		try {
			FileInputStream fichier = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fichier);
			ProjectUML tmp=(ProjectUML)in.readObject();
			copyProject(tmp);
			in.close();
		}
		catch (java.io.IOException e) {
			System.out.println("FAIL in");
			e.printStackTrace();
		}
		
	}

	public void copyProject(ProjectUML tmp) {
		this.associationList=tmp.getAssociationList();
		this.attributeSelected=tmp.getAttributeSelected();
		this.isSave=tmp.isSave;
		this.methodSelected=tmp.methodSelected;
		this.nameSelected=tmp.nameSelected;
		this.objectOfAttributeSelected=tmp.objectOfAttributeSelected;
		this.objectOfMethodSelected=tmp.objectOfMethodSelected;
		this.objectsList=tmp.objectsList;
		this.savePath=tmp.savePath;
		this.selectedObject=tmp.selectedObject;
		this.types=tmp.types;
	}
	
}
