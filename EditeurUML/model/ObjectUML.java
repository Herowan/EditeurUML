package model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * 
 * @author Dashell
 *
 */
public class ObjectUML implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Method> methodeList;
	private ArrayList<Attribute> attributList;
	//Type de l'objet , 1 pour une classe , 2 pour une interface, 3 pour une classe abstraite
	private final TypeObject OBJECTTYPE;
	private Coordinates position;
	
	/**
	 * Constructs a ObjectUML with its name, type it returns, its visibility and list of parameter.
	 * @param objectType : The type of object created (class, abstract class and interface).
	 * @param number :The number of objects created in the EditeurUML. 
	 * @param count :The number of objects created with this object type (class, abstract class and interface).
	 */
	public ObjectUML(TypeObject objectType,int number, int count){
		methodeList= new ArrayList<Method>();
		attributList=new ArrayList<Attribute>();
		position=new Coordinates(10+10*number,10+10*number);
		//Cr��ation d'un objet vide
		this.OBJECTTYPE=objectType;
		name=objectType.getName()+(count+1);
	}
	
	/**
	 * Test the equality of two names ObjectUML.
	 * @param o : The ObjectUMl with which we want to compare its name.
	 * @return Returns true if the two names are identical to ObjectUML else returns false.
	 */
	public boolean equals(ObjectUML o){
		return this.getName().equals(o.getName());
	}
	
	/**
	 * Defines the name of the ObjectUML.
	 * @param name : The name of the ObjectUML.
	 */
	public void setName(String name){
		this.name=name;
	}
	
	/**
	 * Return the name of the ObjectUML
	 * @return Return the name of the ObjectUML
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Return The type of object created.
	 * @return Return the Type of object created (class, abstract class and interface).
	 */
	public TypeObject getOBJECTTYPE() {
		return OBJECTTYPE;
	}
	
	//Gestion de la liste des m��thodes:
	
	/**
	 * Adds a Method in ObjectUML.
	 * @param m : The parameter added to the object.
	 */
	public void addMethod(Method m){
		methodeList.add(m);
	}
	
	/**
	 * Returns the size of the list of Method.
	 * @return the List composed of Method.
	 */
	public int methodeListSize(){
		return methodeList.size();
	}
	
	/**
	 * Returns Method the index location.
	 * @param index :The index of the method we want to return.
	 * @return Returns Method the index location.
	 */
	public Method getMehodAt(int index){
		return methodeList.get(index);
	}
	
	/**
	 * Delete method located in the position index.
	 * @param index :The index of the method we want to delete.
	 */
	public void deleteMethod(int index){
		methodeList.remove(index);
	}
	
	//Gestion de la liste des attributs:
	
	/**
	 * Add an attribute in the List.
	 * @param a : The attribute is inserted in the list.
	 */
	public void addAttribute(Attribute a){
		attributList.add(a);
	}
	
	/**
	 * Returns the size of the list of Attribute.
	 * @return the List composed of Attribute.
	 */
	public int attributListSize(){
		return attributList.size();
	}
	
	/**
	 * Returns Attribute the index location.
	 * @param index :The index of the Attribute we want to return.
	 * @return Returns Attribute the index location.
	 */
	public Attribute getAttributeAt(int index){
		return attributList.get(index);
	}
	
	/**
	 * Delete Attribute located in the position index.
	 * @param index :The index of the method we want to delete.
	 */
	public void deleteAttribute(int index){
		attributList.remove(index);
	}
	
	//Gestion des coordonn��es
	
	/**
	 * Returns the point on the axis of abscissa of ObjectUML.
	 * @return Returns the point on the axis of abscissa of ObjectUML.
	 */
	public int getX(){
		return position.getX();
	}
	
	/**
	 * Returns the point on the axis of ordinate of ObjectUML.
	 * @return Returns the point on the axis of ordinate of ObjectUML.
	 */
	public int getY(){
		return position.getY();
	}
	
	//Gestion de la position d'un objet
	
	/**
	 * Returns a  positive number if the main object is above else a negative number.
	 * @param obj UML Object to Compare position on the vertical axe
	 * @return a positive number if the main object is above , negative else
	 */
	public int isAbove(ObjectUML obj){
		return obj.getY()-this.getY();
	}
	
	/**
	 * Returns a positive number if the main Object is on the right else a negative number.
	 * @param obj UML Object to Compare position on the horizontal axe
	 * @return a positive number if the main object is on the right, negative else
	 */
	public int isOnTheRigth(ObjectUML obj){
		return this.getX()-obj.getX();
	}
	
	/**
	 * Return The type of object created.
	 * @return Return the Type of object created (class, abstract class and interface).
	 */
	public TypeObject getObjectType() {
		return OBJECTTYPE;
	}
	
	/**
	 * Returns the position of the object.
	 * @param x :The point located on the axis of abscissa.
	 * @param y :The point located on the axis of ordinate.
	 */
	public void setPosition(int x, int y){
		position.setX(x);
		position.setY(y);
	}
	
	/**
	 * Returns a string for the generated Java code
	 * @return returns a string for the generated Java code
	 */
	public String toStringJava(){
		String attributes="//Attributes list\n",methods="",defaultConstructor="";
		for(int i=0;i<attributListSize();i++){
			attributes+=attributList.get(i).toStringJava()+"\n";
		}
		attributes+="\n//End Attributes\n\n";
		for(int i=0;i<methodeListSize();i++){
			methods+=methodeList.get(i).toStringJava()+"\n";
		}
		defaultConstructor="//Default Constructor\n \tpublic" + getName()+"(){\n\n\t}\n\n";
		return "public class " + getName()+ "{\n\n"+ attributes +defaultConstructor+ methods + "}";
				
	}
	
}
