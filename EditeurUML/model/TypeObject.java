package model;

public enum TypeObject {
	CLASS("Class"),
	ABSTRACT_CLASS("AbstractClass"),
	INTERFACE("Interface"),
	ENUM("Enum");
	
	private final String name;
	
	private TypeObject(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}
}
