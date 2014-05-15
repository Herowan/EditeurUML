package view;

import model.ProjectUML;

public class Main {
	public static void main (String[] args){
		new MainView(new ProjectUML()).setVisible(true);
	}
}
