package model;

public enum Visibility {
	PRIVATE("private",'-'),
	PROTECTED("private",'#'),
	DEFAULT("default",' '),
	PUBLIC("public",'+');
	
	private final String name;
	private final char charac;
	
	/**
	 * Constructor of visibility with its name and character associated with it. 
	 * @param name : the name of Visibility.
	 * @param charac :the character of Visibility.
	 */
	Visibility(String name, char charac){
		this.name=name;
		this.charac=charac;
	}

	/**
	 * Return a name of Visibility.
	 * @return Return a name of Visibility.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return a character of Visibility.
	 * @return Return a character of Visibility.
	 */
	public char getCharac() {
		return charac;
	}
}
