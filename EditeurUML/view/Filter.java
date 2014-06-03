package view;

import java.io.File;

import javax.swing.filechooser.FileFilter;


public class Filter extends FileFilter{
   //Description et extension acceptée par le filtre
   private String description;
   private String extension;
   //Constructeur à partir de la description et de l'extension acceptée
   public Filter(String description, String extension){
      if(description == null || extension ==null){
         throw new NullPointerException("La description (ou extension) ne peut être null.");
      }
      this.description = description;
      this.extension = extension;
   }

      public String getDescription(){
      return description;
   }
	@Override
	public boolean accept(File f) {
		 if(f.isDirectory()) { 
	         return true; 
	      } 
	      String nomFichier = f.getName().toLowerCase(); 
	 
	      return nomFichier.endsWith(extension);
	}
}

