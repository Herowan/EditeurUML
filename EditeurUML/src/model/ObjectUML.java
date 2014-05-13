package model;

import java.util.ArrayList;
/**
 * 
 * @author Dashell
 *
 */
public class ObjectUML {
	private String name;
	private ArrayList<Method> methodeList;
	private ArrayList<Attribute> attributList;

	private Coordinates position;
	
	
	public ObjectUML(){
		methodeList= new ArrayList<Method>();
		attributList=new ArrayList<Attribute>();
		//a changer , les coordonnées seront pas 0,0 par default
		position=new Coordinates(0,0);
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	
	
	//Gestion de la liste des méthodes:
	public void addMethod(Method m){
		methodeList.add(m);
	}
	int methodeListSize(){
		return methodeList.size();
	}
	
	
	
	//Gestion de la liste des attributs:
	public void addAttribute(Attribute a){
		attributList.add(a);
	}
	int attributListSize(){
		return attributList.size();
	}
	//Gestion des coordonnées
	public int getX(){
		return position.getX();
	}
	public int getY(){
		return position.getY();
	}
	
	//Gestion de la position d'un objet
	/**
	 * 
	 * @param obj UML Object to Compare position on the vertical axe
	 * @return a positive number if the main object is above , negative else
	 */
	public int isAbove(ObjectUML obj){
		return obj.getY()-this.getY();
	}
	/**
	 * 
	 * @param obj UML Object to Compare position on the horizontal axe
	 * @return a positive number if the main object is on the right, negative else
	 */
	public int isOnTheRigth(ObjectUML obj){
		return this.getX()-obj.getX();
	}
	
}
