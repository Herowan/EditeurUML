package modele;

import java.util.ArrayList;

public class ObjetUML {
	private String nom;
	private ArrayList<Methode> listeMethode;
	private ArrayList<Attribut> listeAttribut;

	
	
	
	public ObjetUML(){
		listeMethode= new ArrayList<Methode>();
		listeAttribut=new ArrayList<Attribut>();
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
	
	
}
