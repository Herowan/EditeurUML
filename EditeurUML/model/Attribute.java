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
	int visibilityA;
	
	
	public Attribute(String name,String type,int visibilityA){
		this.name=name;
		this.type=type;
		this.visibilityA=visibilityA;
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


	public int getVisibilityA() {
		return visibilityA;
	}
	
	public String getVisibilityString(){
		switch (getVisibilityA()) {
		case 0:
			return "-";
		case 1:
			return "#";
		case 2:
			return " ";
		case 3:
			return "+";
		default:
			return " ";
		}
	}

	public void setVisibilityA(int visibilityA) {
		this.visibilityA = visibilityA;
	}
	
	public String toString(){
		return getVisibilityString()+" "+getName()+": "+getType();
	}
	
	
}