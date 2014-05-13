package model;

import java.util.ArrayList;

public class ObjetUML {
	private String nom;
	private ArrayList<Methode> listeMethode;
	private ArrayList<Attribut> listeAttribut;

	private Coordonnees position;
	
	
	public ObjetUML(){
		listeMethode= new ArrayList<Methode>();
		listeAttribut=new ArrayList<Attribut>();
		//a changer , les coordonnées seront pas 0,0 par default
		position=new Coordonnees(0,0);
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	public String getNom(){
		return this.nom;
	}
	
	
	//Gestion de la liste des méthodes:
	public void ajouterMethode(Methode m){
		listeMethode.add(m);
	}
	int tailleListeMethode(){
		return listeMethode.size();
	}
	
	
	
	//Gestion de la liste des attributs:
	public void ajouterAttribut(Attribut a){
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
	public int isAbove(ObjetUML obj){
		return obj.getY()-this.getY();
	}
	/**
	 * 
	 * @param obj UML Object to Compare position on the horizontal axe
	 * @return a positive number if the main object is on the right, negative else
	 */
	public int isOnTheRigth(ObjetUML obj){
		return this.getX()-obj.getX();
	}
	
}
