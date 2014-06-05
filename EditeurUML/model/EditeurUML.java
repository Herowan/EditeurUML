package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;


public class EditeurUML extends Observable implements Serializable,Observer{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ProjectUML> projectList;
	private ProjectUML project;
	private ProjectUML projectRedo;
	private Stack<ProjectUML> undoRedoPile=new Stack<ProjectUML>();
	
	/**
	 * Constructs an EditeurUML with a List<ProjectUML> and instantiate a new ProjectUML.
	 */
	public EditeurUML(){
		projectList=new ArrayList<ProjectUML>();
		project=new ProjectUML();
		project.addObserver(this);
	}
	
	/**
	 * Return a List<ProjectUML> of a EditeurUML
	 * @return Return a list of the ProjectUML
	 */
	public ArrayList<ProjectUML> getProjectList() {
		return projectList;
	}
	
	/**
	 * Defines the Arraylist of the EditeurUML
	 * @param projectList : a List<ProjectUML> of a EditeurUML
	 */
	public void setProjectList(ArrayList<ProjectUML> projectList) {
		this.projectList = projectList;
	}
	
	/**
	 * Return a ProjectUML corresponding EditeurUML
	 * @return  Return a ProjectUML of a EditeurUML
	 */
	public ProjectUML getProject() {
		return project;
	}

	/**
	 * Defines the ProjectUML of the EditeurUML
	 * @param project : a list<ObjetUML>, a list<Association> and a Type of the ProjectUML
	 */
	public void setProject(ProjectUML project) {
		this.project = project;
		setChanged();
		notifyObservers();
	}

	/**
	 * Add a ProjectUML in EditeurUML
	 * @param p : a list<ObjetUML>, a list<Association> and a Type of the ProjectUML
	 */
	public void addProject(ProjectUML p){
		projectList.add(p);
	}
	
	/**
	 * Save the file to the location previously chosen.
	 */
	public void saveProject(){
		try {
			project.setIsSave(true);
			FileOutputStream fichier = new FileOutputStream(project.getSavePath());
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
	
	/**
	 * Save as to the location of the path passed in parameter.
	 * @param path : The path to save the file to this location.
	 */
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
	
	/**
	 * Open ProjectUML through the path parameter set.
	 * @param path : The path of the file UML in order to open it.
	 * @throws ClassNotFoundException : when the class cannot be found
	 */
	public void openProject(String path) throws ClassNotFoundException{
		try {
			FileInputStream fichier = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fichier);
			
			
			setProject((ProjectUML)in.readObject());
			in.close();
		}
		catch (java.io.IOException e) {
			System.out.println("FAIL in");
			e.printStackTrace();
		}
		project.addObserver(this);

		setChanged();
		notifyObservers();
	}
	
	/**
	 * Delete the last manipulation.
	 */
	public void Undo(){
		projectRedo=undoRedoPile.pop();
		setProject(undoRedoPile.pop());
	}
	
	/**
	 * Restore the last manipulation.
	 */
	public void Redo(){
		setProject(projectRedo);
	}

	@Override
	public void update(Observable o, Object arg) {
		undoRedoPile.push(project);
		setChanged();
		notifyObservers();
	}
}
