package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Type implements Serializable{
	
	private static final long serialVersionUID = 1L;
	ArrayList<String> typeList;
	
	/**
	 * Type constructor to create a list of different types.
	 */
	public Type(){
		typeList=new ArrayList<String>();
		typeList.add("void");
		typeList.add("int");
		typeList.add("char");
		typeList.add("byte");
		typeList.add("short");
		typeList.add("long");
		typeList.add("float");
		typeList.add("double");
		typeList.add("boolean");
		typeList.add("String");
	}

	/**
	 * Add a type from the list.
	 * @param name : The name of a new Type.
	 */
	public void addType(String name) {
		typeList.add(name);
	}
	
	/**
	 * Return Type located in the position index.
	 * @param index : The index of the Type we want to return.
	 * @return Returns a character string type being placed indexes entered parameter.
	 */
	public String getTypeAt(int index){
		return typeList.get(index);
	}
	
	/**
	 * Returns the size of the list of Type.
	 * @return Returns the size of the list of Type.
	 */
	public int typesListSize(){
		return typeList.size();
	}
	
	/**
	 * Removes the type corresponding to the name entered in parameter.
	 * @param type :The type name you want to delete
	 */
	public void remove(String type){
		typeList.remove(type);
	}
}
