package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Dashell
 *
 */
public class Method implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String returnType;
	ArrayList<String> params;
	Visibility visibilityM;
	
	public Method(String name,String returnType,Visibility visibilityM,ArrayList<String> params){
		this.name=name;
		this.returnType=returnType;
		this.visibilityM=visibilityM;
		this.params=params;
	}
	
	public String toString(){
		String aff= getName()+"(";
		for(int i=0; i<getParams().size(); i++){
			aff=aff+getParams().get(i);
			if (i!=getParams().size()-1) aff=aff+", ";
		}
		aff=aff+") : "+getReturnType();
		return aff;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public ArrayList<String> getParams() {
		return params;
	}

	public void setParams(ArrayList<String> params) {
		this.params = params;
	}

	public Visibility getVisibilityM() {
		return visibilityM;
	}

	public void setVisibilityM(Visibility visibilityM) {
		this.visibilityM = visibilityM;
	}
	
	
}
