package modele;

import java.util.ArrayList;

public class Methode {
	String nom;
	String returnType;
	ArrayList<String> params;
	int visibiliteM;
	
	public Methode(String nom,String returnType,int visibiliteM,ArrayList<String> params){
		this.nom=nom;
		this.returnType=returnType;
		this.visibiliteM=visibiliteM;
		this.params=params;
	}
	
	
	
}
