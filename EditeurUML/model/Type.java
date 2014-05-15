package model;

import java.util.ArrayList;

public class Type {
	ArrayList<String> typeList;
	
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

	public void addType(String name) {
		typeList.add(name);
	}
	public String getTypeAt(int index){
		return typeList.get(index);
	}
	public int typesListSize(){
		return typeList.size();
	}
}
