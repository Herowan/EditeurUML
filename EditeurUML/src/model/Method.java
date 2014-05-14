package model;

import java.util.ArrayList;
import java.util.Observable;
/**
 * 
 * @author Dashell
 *
 */
public class Method {
	String name;
	String returnType;
	ArrayList<String> params;
	int visibilityM;
	
	public Method(String name,String returnType,int visibilityM,ArrayList<String> params){
		this.name=name;
		this.returnType=returnType;
		this.visibilityM=visibilityM;
		this.params=params;
	}
	
	
	
}
