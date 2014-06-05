package testPackage;

import static org.junit.Assert.*;

import javax.swing.JButton;

import model.Association;
import model.ObjectUML;
import model.ProjectUML;
import model.TypeObject;
import org.junit.Before;
import org.junit.Test;
import view.ModifyAssociationView;
import controller.OkButtonModifyAssociationController;

public class OkButtonModifyAssociationControllerTest {
	OkButtonModifyAssociationController ok;
	JButton button;
	ProjectUML model;
	
	@Before
	public void before(){
		model = new ProjectUML();
		button = new JButton();
	}

	@Test
	public void testActionPerformed() {		
		model.getAssociationList().add(new Association(new ObjectUML(TypeObject.CLASS, 1, 1), new ObjectUML(TypeObject.CLASS, 2, 1), 0, "TEST"));

		ModifyAssociationView view = new ModifyAssociationView(model, 0, 0);
		model.addObjectUml(TypeObject.CLASS);
		model.addObjectUml(TypeObject.CLASS);
		view.getClass1ComboBox().setSelectedIndex(0);
		view.getClass2ComboBox().setSelectedIndex(1);
		ok = new OkButtonModifyAssociationController(model, view, 0, 0);
		view.getNameTextField().setText("Hello");
		button.addActionListener(ok);
		button.doClick();
		assertEquals("Hello", model.getAssociationList().get(0).getName());
	}

}
