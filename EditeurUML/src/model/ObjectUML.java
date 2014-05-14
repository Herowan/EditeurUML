package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Dashell
 *
 */
public class ObjectUML implements Serializable{
	private String name;
	private ArrayList<Method> methodeList;
	private ArrayList<Attribute> attributList;
	//Type de l'objet , 1 pour une classe , 2 pour une interface, 3 pour une classe abstraite
	private int objectType;
	
	private Coordinates position;
	
	
	public ObjectUML(int objectType,int number){
		methodeList= new ArrayList<Method>();
		attributList=new ArrayList<Attribute>();
		//a changer , les coordonn��es seront pas 0,0 par default
		// Done ?
		position=new Coordinates(10+10*number,10+10*number);
		//Cr��ation d'un objet vide
		this.objectType=objectType;
		name="Object"+(number+1);
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	
	
	//Gestion de la liste des m��thodes:
	public void addMethod(Method m){
		methodeList.add(m);
	}
	int methodeListSize(){
		return methodeList.size();
	}
	
	//lol
	
	//Gestion de la liste des attributs:
	public void addAttribute(Attribute a){
		attributList.add(a);
	}
	int attributListSize(){
		return attributList.size();
	}
	//Gestion des coordonn��es
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
