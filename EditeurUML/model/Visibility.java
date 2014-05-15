package model;

public enum Visibility {
	PRIVATE("private",'-'),
	PROTECTED("private",'#'),
	DEFAULT("default",' '),
	PUBLIC("public",'+');
	
	private final String name;
	private final char charac;
	
	Visibility(String name, char charac){
		this.name=name;
		this.charac=charac;
	}

	public String getName() {
		return name;
	}

	public char getCharac() {
		return charac;
	}
}
