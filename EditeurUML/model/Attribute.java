package model;

import java.io.Serializable;

/**
 * 
 * @author Dashell
 *
 */
public class Attribute implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String type;
	// 0=> private ; 1=> protected; 2=> default ; 3=>public;
	Visibility visibilityA;
	
	
	public Attribute(String name,String type,Visibility visibilityA){
		this.name=name;
		this.type=type;
		this.visibilityA=visibilityA;
	}

	boolean equals(Attribute a){
			return this.getName().equals(a.getName());
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Visibility getVisibilityA() {
		return visibilityA;
	}
	

	public void setVisibilityA(Visibility visibilityA) {
		this.visibilityA = visibilityA;
	}
	
	public String toString(){
		return getVisibilityA().getCharac()+" "+getName()+": "+getType();
	}
	
	
}
