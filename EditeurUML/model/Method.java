package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Dashell
 *
 */
public class Method implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String name;
	String returnType;
	ArrayList<String> params;
	Visibility visibilityM;
	
	/**
	 * Constructs a Method with its name, type it returns, its visibility and list of parameter.
	 * @param name : The name of the Method
	 * @param returnType : The type it returns.
	 * @param visibilityM : The visibility of the Method
	 * @param params : The list of character string is the parameter of the Method.
	 */
	public Method(String name,String returnType,Visibility visibilityM,ArrayList<String> params){
		this.name=name;
		this.returnType=returnType;
		this.visibilityM=visibilityM;
		this.params=params;
	}
	
	/**
	 * Returns a string with the name ,a list of String parameter and the type it returns.
	 */
	public String toString(){
		String aff= getName()+"(";
		for(int i=0; i<getParams().size(); i++){
			aff=aff+getParams().get(i);
			if (i!=getParams().size()-1) aff=aff+", ";
		}
		aff=aff+") : "+getReturnType();
		return aff;
		
	}
	
	/**
	 * Returns a boolean to compare two Methods.
	 * @param m A method with which a comparison is made.
	 * @return Returns true if the two methods are identical else returns false.
	 */
	public boolean equals(Method m){
		if(!this.getName().equals(m.getName())){
			return false;
		}
		
		if(this.getParams().size()!=m.getParams().size()) return false;
		for(int i=0;i<m.getParams().size();i++){
			if(!this.params.get(i).equals(m.getParams().get(i))) return false;
		}
		
		return true;
	}
	
	/**
	 * Returns the name of the Method
	 * @return Returns the name of the Method
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Defines the name of the Method.
	 * @param name : the name of the Method.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the type it returns.
	 * @return Returns the type it returns.
	 */
	public String getReturnType() {
		return returnType;
	}
	
	/**
	 * Defines the Type it returns.
	 * @param returnType : The type it returns.
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	/**
	 * Returns a list of character string is the parameter of the method. 
	 * @return Returns the list of character string is the parameter of the Method.
	 */
	public ArrayList<String> getParams() {
		return params;
	}

	/**
	 * Defines a list of character string is the parameter of the method.
	 * @param params : The list of character string is the parameter of the Method.
	 */
	public void setParams(ArrayList<String> params) {
		this.params = params;
	}

	/**
	 * Returns a visibility of the Method.
	 * @return Returns a visibility of the Method.
	 */
	public Visibility getVisibilityM() {
		return visibilityM;
	}

	/**
	 * Defines a visibility of the Method.
	 * @param visibilityM : The visibility of the Method
	 */
	public void setVisibilityM(Visibility visibilityM) {
		this.visibilityM = visibilityM;
	}
	
	/**
	 *  returns a string for the generated Java code with the name, a list of parameter and type it returns (separate by a space).
	 * @return  Returns a string for the generated Java code
	 */
	public String toStringJava(){
		String aff= getName()+"(";
		for(int i=0; i<getParams().size(); i++){
			aff=aff+getParams().get(i);
			if (i!=getParams().size()-1) aff=aff+", ";
		}
		aff="\t"+getReturnType()+" "+aff+"){"+"\n\n\t}\n";
		return aff;
			}
	
}
