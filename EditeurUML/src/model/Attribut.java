package model;

public class Attribut {
	String nom;
	String type;
	int visibiliteA;
	
	
	public Attribut(String nom,String type,int visibiliteA){
		this.nom=nom;
		this.type=type;
		this.visibiliteA=visibiliteA;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getVisibiliteA() {
		return visibiliteA;
	}


	public void setVisibiliteA(int visibiliteA) {
		this.visibiliteA = visibiliteA;
	}
	
	
	
}
