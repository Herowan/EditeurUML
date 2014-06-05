package testPackage;

import static org.junit.Assert.*;

import javax.swing.JButton;

import model.Association;
import model.ObjectUML;
import model.ProjectUML;
import model.TypeObject;

import org.junit.Before;
import org.junit.Test;

import controller.OkButtonNewAssociationController;
import view.NewAssociationView;

public class OkButtonNewAssociationControllerTest {

	ProjectUML model;
	NewAssociationView view;
	JButton button=new JButton();

	
	@Before
	public void createContext(){
		model=new ProjectUML();
		view=new NewAssociationView(model, 0);
		model.addObjectUml(TypeObject.CLASS);
		model.addObjectUml(TypeObject.CLASS);
		view.getClass1ComboBox().setSelectedIndex(0);
		view.getClass2ComboBox().setSelectedIndex(1);
	}
	
	@Test
	public void actionPerformerNewRelationtest() {	
		Association a = new Association(model.getObjectUmlAtIndex(view.getClass1ComboBox().getSelectedIndex()), model.getObjectUmlAtIndex(view.getClass2ComboBox().getSelectedIndex()), 0,view.getNameTextField().getText());
		button.addActionListener(new OkButtonNewAssociationController(model, view, 0));
		button.doClick();
		assertEquals(a,model.getAssociationList().get(0));
	}

	@Test
	public void actionPerformerNewImplement() {
		fail("Not yet implemented");
	}
	
	@Test
	public void actionPerformerNewExtend() {
		fail("Not yet implemented");
	}
	
	@Test
	public void actionPerformerNewDependence() {
		fail("Not yet implemented");
	}
}
