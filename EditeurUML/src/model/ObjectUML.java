package model;

import java.util.ArrayList;

public class ObjectUML {
	private String nom;
	private ArrayList<Method> listeMethode;
	private ArrayList<Attribute> listeAttribut;

	private Coordinates position;
	
	
	public ObjectUML(){
		listeMethode= new ArrayList<Method>();
		listeAttribut=new ArrayList<Attribute>();
		//a changer , les coordonnées seront pas 0,0 par default
		position=new Coordinates(0,0);
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	public String getNom(){
		return this.nom;
	}
	
	
	//Gestion de la liste des méthodes:
	public void ajouterMethode(Method m){
		listeMethode.add(m);
	}
	int tailleListeMethode(){
		return listeMethode.size();
	}
	
	
	
	//Gestion de la liste des attributs:
	public void ajouterAttribut(Attribute a){
		listeAttribut.add(a);
	}
	int tailleListeAttribut(){
		return listeAttribut.size();
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
