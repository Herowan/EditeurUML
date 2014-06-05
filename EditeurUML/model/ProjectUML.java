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
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ObjectUML> objectsList;
	private ArrayList<Association> associationList;
	// For the JpanelDrawingTable view
	private int selectedObject;
	private String savePath=null; // save du chemin ou est enregistr�� le projet pour le controller Save
	private boolean isSave=true;
	private Type types;
	private String warning="";
	private String notes;
	
	// Attributes selected for the view
	private int nameSelected=-1;
	private int attributeSelected=-1;
	private int objectOfAttributeSelected=-1;
	private int methodSelected=-1;
	private int objectOfMethodSelected =-1;

	/**
	 * Constructs anProjectUML with a List<ObjectUML> and List<Association> and instantiate a new Type.
	 */
	public ProjectUML(){
		objectsList = new ArrayList<ObjectUML>();
		associationList = new ArrayList<Association>();
		types=new Type();
	//	addProject();
	}
	
	//Method for New Project
	
	/**
	 * Resets the ProjectUML
	 */
	public void resetProject(){
		objectsList.clear();
		associationList.clear();
		savePath=null;
		setChanged();
		notifyObservers();
	}

	
	/**
	 * Returns ObjectUML the index location.
	 * @param index :The index of the ObjectUML we want to return.
	 * @return Returns ObjectUML the index location.
	 */
	public ObjectUML getObjectUmlAtIndex(int index){
		return objectsList.get(index);
	}
	
	/**
	 * Return the object corresponding to the name entered in parameter.
	 * @param name: The name of the object you want to return.
	 * @return Return the object corresponding to the name entered in parameter.
	 */
	public ObjectUML getObjectByName(String name){
		for (int i=0; i<objectsListSize(); i++){
			if (objectsList.get(i).getName().equals(name)){
				return objectsList.get(i);
			}
		}
		return null;
	}

	/**
	 * Returns the size of the list of Object.
	 * @return Returns the size of the list of Object.
	 */
	public int objectsListSize(){
		return objectsList.size();
	}
	
	/**
	 * Return an integer corresponding to the number of type object entered parameter.
	 * @param type :The type of object you want to count the number of objects having this type.
	 * @return Return an integer corresponding to the number of type object entered parameter.
	 */
	private int objectWhoHaveType(TypeObject type){
		int count=0;
		for (int i=0; i<objectsListSize(); i++){
			if (getObjectUmlAtIndex(i).getObjectType()==type){
				count++;
			}
		}
		return count;
	}

	/**
	 * Test if the entered parameter object belongs to the project.
	 * @param object :The object which we test membership in the Project.
	 * @return true if the object belongs to projects else returns false.
	 */
	public boolean projectContains(ObjectUML object){
		for (int i=0; i<objectsListSize(); i++){
			if (getObjectUmlAtIndex(i).equals(object)) return true;
		}
		return false;
	}
	
	/**
	 * Adding the objetUMl enter parameter.
	 * @param type :The type of object to add. 
	 */
	public void addObjectUml(TypeObject type){
		objectsList.add(new ObjectUML(type,  objectsListSize(),objectWhoHaveType(type)));
		types.addType(objectsList.get(objectsListSize()-1).getName());
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Returns a list of ObjetUML contained in the project.
	 * @return Returns a list of ObjetUML contained in the project.
	 */
	public ArrayList<ObjectUML> getObjectsList() {
		return objectsList;
	}

	/**
	 * Defines a List of ObjectUML.
	 * @param objectsList: The list of ObjectUML contained in the project.
	 */
	public void setObjectsList(ArrayList<ObjectUML> objectsList) {
		this.objectsList = objectsList;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Returns a list of Association content in the project.
	 * @return Returns a list of Association content in the project.
	 */
	public ArrayList<Association> getAssociationList() {
		return associationList;
	}
	
	/**
	 * Defines a list of Association.
	 * @param associationList : The list of Association contained in the project.
	 */
	public void setAssociationList(ArrayList<Association> associationList) {
		this.associationList = associationList;
		setChanged();
		notifyObservers();
	}

	/**
	 * Delete ObjectUML located in the position index.
	 * @param index :The index of the ObjectUML we want to delete.
	 */
	public void deleteObjectUml(int index){
		objectsList.remove(index);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Add an Attribute to the index parameter entered in the ProjectUML
	 * @param index :The index of the Attribute  we want to add.
	 * @param attribute :Attribute that you want to add
	 */
	public void addAttribute(int index, Attribute attribute){
		objectsList.get(index).addAttribute(attribute);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Add an Method to the index parameter entered in the ProjectUML
	 * @param index :The index of the Method  we want to add.
	 * @param method :Method that you want to add
	 */
	public void addMethod(int index, Method method){
		objectsList.get(index).addMethod(method);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Defines the position of the ObjectUML.
	 * @param x : the point on the axis of abscissa of ObjectUML.
	 * @param y :the point on the axis of ordinate of ObjectUML.
	 * @param index : :The index of the ObjectUML  we want to define.
	 */
	public void setPositionObject(int x, int y, int index){
		objectsList.get(index).setPosition(x, y);
		setChanged();
		notifyObservers();
	}

	/**
	 * Return the integer representing the object select. 
	 * @return Return the integer representing the object select. 
	 */
	public int getSelectedObject() {
		return selectedObject;
	}

	/**
	 * Define integer object select.
	 * @param selectedObject : The selected object.
	 */
	public void setSelectedObject(int selectedObject) {
		this.selectedObject = selectedObject;
	}

	/**
	 * Returns the file path.
	 * @return Returns the file path.
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * Define the file path.
	 * @param savePath : the file path.
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * Test if the file is saved.
	 * @return Returns true if the file is saved, false otherwise.
	 */
	public boolean isSave() {
		return isSave;
	}

	/**
	 * Define if the file is saved. 
	 * @param isSave :Boolean true if he is saved, otherwise false.
	 */
	public void setIsSave(boolean isSave) {
		this.isSave=isSave;
	}

	/**
	 * Returns the type 
	 * @return Return the type
	 */
	public Type getTypes() {
		return types;
	}

	/**
	 * Return the name selected.
	 * @return Return the name selected.
	 */
	public int getNameSelected() {
		return nameSelected;
	}

	/**
	 * Define the name selected.
	 * @param nameSelected : the name selected.
	 */
	public void setNameSelected(int nameSelected) {
		this.nameSelected = nameSelected;
		setChanged();
		notifyObservers();
	}

	/**
	 * Return the Attribute selected
	 * @return Return the Attribute selected
	 */
	public int getAttributeSelected() {
		return attributeSelected;
	}

	/**
	 * Define the Attribute selected
	 * @param attributeSelected : the Attribute selected
	 */
	public void setAttributeSelected(int attributeSelected) {
		this.attributeSelected = attributeSelected;
	}

	/**
	 * Return the Object of Attribute selected.
	 * @return Return the Object of Attribute selected.
	 */
	public int getObjectOfAttributeSelected() {
		return objectOfAttributeSelected;
	}
	
	/**
 	 * Define the Object of Attribute selected.
 	 * @param objectOfAttributeSelected : the object of attribute selected
 	 */
	public void setObjectOfAttributeSelected(int objectOfAttributeSelected) {
		this.objectOfAttributeSelected = objectOfAttributeSelected;
	}

	/**
	 * Return integer Method select.
	 * @return Return integer Method select.
	 */
	public int getMethodSelected() {
		return methodSelected;
	}

	/**
	 * Define integer Method select.
	 * @param methodSelected :The Method selected.
	 */
	public void setMethodSelected(int methodSelected) {
		this.methodSelected = methodSelected;
	}

	/**
	 * Return the Object of Method selected.
	 * @return Return the Object of Method selected.
	 */
	public int getObjectOfMethodSelected() {
		return objectOfMethodSelected;
	}

	/**
	 * Define the Object of Method selected.
	 * @param objectOfMethodSelected : the object of attribute selected
	 */
	public void setObjectOfMethodSelected(int objectOfMethodSelected) {
		this.objectOfMethodSelected = objectOfMethodSelected;
	}

	/**
	 * Returns integer corresponding to the position of the object entered parameter.
	 * @param object : The object that we want to index.
	 * @return Returns integer corresponding to the position of the object entered parameter.
	 */
	public int getIndexOfObject(ObjectUML object) {
		for (int i=0; i<objectsListSize(); i++){
			if (getObjectUmlAtIndex(i).equals(object)) return i;
		}
		return -1;
	}
	
	/**
	 * Returns a character string with an error message.
	 * @return Returns a character string with an error message.
	 */
	public String getWarning() {
		return warning;
	}

	/**
	 * Define error message.
	 * @param warning : The error message.
	 */
	public void setWarning(String warning) {
		this.warning = warning;
		setChanged();
		notifyObservers();
	}

	/**
	 * Returns the notes of a project.
	 * @return Returns the notes of a project.
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Define the notes of a project
	 * @param notes : Note of a project.
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Genere the Java code.
	 * @throws IOException :Exceptions produced by failed or interrupted I/O operations.
	 */
	public void generateJava() throws IOException{
		String pathR;
		int last=0;
		for(int i=0;i<this.savePath.length();i++){
			if(savePath.charAt(i)=='/') last=i;
		}
		pathR=savePath.substring(0,last+1);
		for(int j=0;j<objectsListSize();j++){
			pathR+=objectsList.get(j).getName()+".java";
			FileOutputStream fichier = new FileOutputStream(pathR);
			ObjectOutputStream out = new ObjectOutputStream(fichier);
			out.writeObject(objectsList.get(j).toStringJava());
			out.flush();
			out.close();
		}
	}
	
}
