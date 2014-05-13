package model;
/**
 * 
 * @author Dashell
 *
 */
public class Attribute {
	String name;
	String type;
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


	public void setVisibilityA(int visibilityA) {
		this.visibilityA = visibilityA;
	}
	
	
	
}
