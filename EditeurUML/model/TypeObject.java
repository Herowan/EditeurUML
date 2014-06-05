package model;

public enum TypeObject {
	CLASS("Class"),
	ABSTRACT_CLASS("AbstractClass"),
	INTERFACE("Interface"),
	ENUM("Enum");
	
	private final String name;
	
	/**
	 * Defines a name of TypeObject.
	 * @param name :The name you want to define.
	 */
	private TypeObject(String name){
		this.name=name;
	}

	/**
	 * Return a name of TypeObject.
	 * @return  Return a name of TypeObject.
	 */
	public String getName() {
		return name;
	}
}
