package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class EditeurUML extends Observable implements Serializable,Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ProjectUML> projectList;
	private ProjectUML project;

	public EditeurUML(){
		projectList=new ArrayList<ProjectUML>();
		project=new ProjectUML();
		project.addObserver(this);
	}
	public ArrayList<ProjectUML> getProjectList() {
		return projectList;
	}

	public void setProjectList(ArrayList<ProjectUML> projectList) {
		this.projectList = projectList;
	}

	public ProjectUML getProject() {
		return project;
	}

	public void setProject(ProjectUML project) {
		this.project = project;
	}

	
	public void addProject(){
		projectList.add(new ProjectUML());
	}
	
	public void saveProject(){
		System.out.println("2");
		try {
			project.setIsSave(true);
			System.out.println("2");
			FileOutputStream fichier = new FileOutputStream(project.getSavePath());
			System.out.println("2");
			ObjectOutputStream out = new ObjectOutputStream(fichier);
			System.out.println("2");
			out.writeObject(this);
			System.out.println("2");
			out.flush();
			System.out.println("2");
			out.close();
		}
		catch (java.io.IOException e) {
			System.out.println("FAIL out");
			e.printStackTrace();
		}
	}
	
	public void saveProjectAs(String path){
		try {
			project.setIsSave(true);
			FileOutputStream fichier = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fichier);
			out.writeObject(project);
			out.flush();
			out.close();
		}
		
		catch (java.io.IOException e) {
			System.out.println("FAIL out");
			e.printStackTrace();
		}
	}
	
	public void openProject(String path) throws ClassNotFoundException{
		System.out.println(path);
		try {
			FileInputStream fichier = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fichier);
			project=(ProjectUML)in.readObject();
			in.close();
		}
		catch (java.io.IOException e) {
			System.out.println("FAIL in");
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}
}
