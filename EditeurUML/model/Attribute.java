package model;

import java.io.Serializable;

/**
 * 
 * @author Dashell
 *
 */
public class Attribute implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String name;
	String type;
	// 0=> private ; 1=> protected; 2=> default ; 3=>public;
	Visibility visibilityA;
	
	/**
	 * Constructs an Attribute with the name, type and corresponding visibility.
	 * @param name : The name of the Attribute.
	 * @param type : the type of the Attribute.
	 * @param visibilityA : the visibility of the Attribute.
	 */
	public Attribute(String name,String type,Visibility visibilityA){
		this.name=name;
		this.type=type;
		this.visibilityA=visibilityA;
	}
	
	/**
	 * Return true if the attribute name is the same as name of the attribute in parameter passing.
	 * @param a : An Attribute
	 * @return true if attribute name is the same as name of the attribute in parameter passing.
	 */
	public boolean equals(Attribute a){
			return this.getName().equals(a.getName());
	}
	
	/**
	 * return the name of the Attribute
	 * @return return the name of the Attribute
	 */
	public String getName() {
		return name;
	}

	/**
	 * Defines the name of the Attribute
	 * @param name : The name of the Attribute.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return the type of the Attribute
	 * @return return the type of the Attribute.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Defines the type of the Attribute
	 * @param type : the type of the Attribute.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * return the Visibility of the Attribute
	 * @return return the Visibility of the Attribute
	 */
	public Visibility getVisibilityA() {
		return visibilityA;
	}
	
	/**
	 * Defines the Visibility of the Attribute
	 * @param visibilityA : the visibility of the Attribute.
	 */
	public void setVisibilityA(Visibility visibilityA) {
		this.visibilityA = visibilityA;
	}
	
	/**
	 * Returns a string with the visibility, name and type (separate by a space).
	 */
	public String toString(){
		return getVisibilityA().getCharac()+" "+getName()+": "+getType();
	}
	
	
}
