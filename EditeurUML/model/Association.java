package model;

import java.io.Serializable;

public class Association implements Serializable{

	
	private static final long serialVersionUID = 1L;
	ObjectUML firstObject;
	ObjectUML lastObject;
	int typeOfAssociation;
	String name;
	
	/**
	 * Construct an Association between firstObject and lastObject with typeOfAssociation. 
	 * @param firstObject : the first object attached to the Association
	 * @param lastObject : the last object attached to the Association
	 * @param typeOfAssociation : the type of the corresponding Association
	 */
	public Association(ObjectUML firstObject, ObjectUML lastObject,int typeOfAssociation,String name){
		this.firstObject=firstObject;
		this.lastObject=lastObject;
		this.typeOfAssociation=typeOfAssociation;
		this.name=name;
	}

	/**
	 * return the firstObjetct of the Association
	 * @return return the firstObject of the Association
	 */
	public ObjectUML getFirstObject() {
		return firstObject;
	}

	/**
	 * Defines the first objects of the Association 
	 * @param firstObject : the first object attached to the Association
	 */
	public void setFirstObject(ObjectUML firstObject) {
		this.firstObject = firstObject;
	}

	/**
	 * return the lastObjetct of the Association
	 * @return return the last object attached to the Association
	 */
	public ObjectUML getLastObject() {
		return lastObject;
	}

	/**
	 * Defines the last objects of the Association
	 * @param lastObject : the last object attached to the Association
	 */
	public void setLastObject(ObjectUML lastObject) {
		this.lastObject = lastObject;
	}

	/**
	 * return the type of the corresponding Association
	 * @return return the type of the corresponding Association 
	 */
	public int getTypeOfAssociation() {
		return typeOfAssociation;
	}

	/**
	 * Defines the type of the corresponding Association 
	 * @param typeOfAssociation : the type of the corresponding Association
	 */
	public void setTypeOfAssociation(int typeOfAssociation) {
		this.typeOfAssociation = typeOfAssociation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
