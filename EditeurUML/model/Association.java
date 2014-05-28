package model;

import java.io.Serializable;

public class Association implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ObjectUML firstObject;
	ObjectUML lastObject;
	int typeOfAssociation;
	
	
	public Association(ObjectUML firstObject, ObjectUML lastObject,int typeOfAssociation){
		this.firstObject=firstObject;
		this.lastObject=lastObject;
		this.typeOfAssociation=typeOfAssociation;
	}


	public ObjectUML getFirstObject() {
		return firstObject;
	}


	public void setFirstObject(ObjectUML firstObject) {
		this.firstObject = firstObject;
	}


	public ObjectUML getLastObject() {
		return lastObject;
	}


	public void setLastObject(ObjectUML lastObject) {
		this.lastObject = lastObject;
	}


	public int getTypeOfAssociation() {
		return typeOfAssociation;
	}


	public void setTypeOfAssociation(int typeOfAssociation) {
		this.typeOfAssociation = typeOfAssociation;
	}
	
}
