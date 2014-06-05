package testPackage;

import static org.junit.Assert.*;

import javax.swing.JButton;

import model.ProjectUML;
import model.TypeObject;

import org.junit.Before;
import org.junit.Test;

import view.NewAssociationView;
import controller.OkButtonNewAssociationController;

public class OKButtonNewAssociationControllerTest {
	OkButtonNewAssociationController ok;
	JButton button;
	ProjectUML model;
	
	@Before
	public void before(){
		model = new ProjectUML();
		button = new JButton();
	}

	@Test
	public void testAssociation() {
		NewAssociationView view = new NewAssociationView(model, 0);
		model.addObjectUml(TypeObject.CLASS);
		model.addObjectUml(TypeObject.CLASS);
		view.getClass1ComboBox().setSelectedIndex(0);
		view.getClass2ComboBox().setSelectedIndex(1);
		ok = new OkButtonNewAssociationController(model, view, 0);
		button.addActionListener(ok);
		button.doClick();
		assertEquals(1, model.getAssociationList().size());
		assertEquals(0, model.getAssociationList().get(0).getTypeOfAssociation());
	}
	@Test
	public void testExtend() {
		NewAssociationView view = new NewAssociationView(model, 0);
		model.addObjectUml(TypeObject.CLASS);
		model.addObjectUml(TypeObject.CLASS);
		view.getClass1ComboBox().setSelectedIndex(0);
		view.getClass2ComboBox().setSelectedIndex(1);
		ok = new OkButtonNewAssociationController(model, view, 1);
		button.addActionListener(ok);
		button.doClick();
		assertEquals(1, model.getAssociationList().size());
		assertEquals(1, model.getAssociationList().get(0).getTypeOfAssociation());
	}
	@Test
	public void testImplement() {
		NewAssociationView view = new NewAssociationView(model, 0);
		model.addObjectUml(TypeObject.CLASS);
		model.addObjectUml(TypeObject.CLASS);
		view.getClass1ComboBox().setSelectedIndex(0);
		view.getClass2ComboBox().setSelectedIndex(1);
		ok = new OkButtonNewAssociationController(model, view, 2);
		button.addActionListener(ok);
		button.doClick();
		assertEquals(1, model.getAssociationList().size());
		assertEquals(2, model.getAssociationList().get(0).getTypeOfAssociation());
	}
	@Test
	public void testDependence() {
		NewAssociationView view = new NewAssociationView(model, 0);
		model.addObjectUml(TypeObject.CLASS);
		model.addObjectUml(TypeObject.CLASS);
		view.getClass1ComboBox().setSelectedIndex(0);
		view.getClass2ComboBox().setSelectedIndex(1);
		ok = new OkButtonNewAssociationController(model, view, 3);
		button.addActionListener(ok);
		button.doClick();
		assertEquals(1, model.getAssociationList().size());
		assertEquals(3, model.getAssociationList().get(0).getTypeOfAssociation());
	}

}
