package testPackage;

import static org.junit.Assert.*;
import model.EditeurUML;
import model.ProjectUML;
import model.TypeObject;

import org.junit.Test;

import controller.AddObjectControler;

import javax.swing.*;
public class AddObjectControlerTest {

	
	JButton button=new JButton();
	EditeurUML model=new EditeurUML();

	
	@Test
	public void actionPerformedTestAddClass() {
		ProjectUML p=new ProjectUML();
		model.setProject(p);
		button.addActionListener(new AddObjectControler(TypeObject.CLASS, model));
		button.doClick();
		assertEquals(TypeObject.CLASS,p.getObjectsList().get(0).getObjectType());
	}
	
	@Test
	public void actionPerformedTestAddInterface() {
		ProjectUML p=new ProjectUML();
		model.setProject(p);
		button.addActionListener(new AddObjectControler(TypeObject.INTERFACE, model));
		button.doClick();
		assertEquals(TypeObject.INTERFACE,p.getObjectsList().get(0).getObjectType());
	}
	
	@Test
	public void actionPerformedTestAddAbstractClass() {
		ProjectUML p=new ProjectUML();
		model.setProject(p);
		button.addActionListener(new AddObjectControler(TypeObject.ABSTRACT_CLASS, model));
		button.doClick();
		assertEquals(TypeObject.ABSTRACT_CLASS,p.getObjectsList().get(0).getObjectType());
	}

}
