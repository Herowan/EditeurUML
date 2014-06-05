package testPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Association;
import model.Attribute;
import model.Method;
import model.ObjectUML;
import model.ProjectUML;
import model.TypeObject;
import model.Visibility;

import org.junit.Test;

public class ProjectUMLTest {

	ProjectUML p=new ProjectUML();

	@Test
	public void testResetProject() {
		p.addObjectUml(TypeObject.CLASS);
		ObjectUML o1 =new ObjectUML(TypeObject.CLASS, 0, 0);
		ObjectUML o2 =new ObjectUML(TypeObject.CLASS, 0, 0);

		p.getAssociationList().add(new Association(o1,o2,0,""));
		p.resetProject();
		assertEquals(0,p.getObjectsList().size());
		assertEquals(0,p.getAssociationList().size());
	}

	@Test
	public void testObjectsListSize() {
		p.addObjectUml(TypeObject.CLASS);
		p.addObjectUml(TypeObject.CLASS);
		p.addObjectUml(TypeObject.CLASS);
		assertEquals(3,p.objectsListSize());
	}


	@Test
	public void testProjectContains() {
		ObjectUML o1 =new ObjectUML(TypeObject.CLASS, 0, 0);
		o1.setName("Test");
		ObjectUML o2 =new ObjectUML(TypeObject.CLASS, 0, 0);
		o2.setName("BLA");
		p.addObjectUml(TypeObject.CLASS);
		p.getObjectUmlAtIndex(0).setName("Test");
		assertTrue(p.projectContains(o1));
		assertFalse(p.projectContains(o2));
	}

	@Test
	public void testAddObjectUml() {
		assertEquals(0,p.objectsListSize());
		p.addObjectUml(TypeObject.CLASS);
		assertEquals(1,p.objectsListSize());
	}

	@Test
	public void testDeleteObjectUml() {
		ObjectUML o1 =new ObjectUML(TypeObject.CLASS, 0, 0);
		o1.setName("Test");
		p.addObjectUml(TypeObject.CLASS);
		p.getObjectUmlAtIndex(0).setName("Test");
		assertTrue(p.projectContains(o1));
		p.deleteObjectUml(0);
		assertFalse(p.projectContains(o1));
	}

	@Test
	public void testAddAttribute() {
		p.addObjectUml(TypeObject.CLASS);
		Attribute a= new Attribute("name","type",Visibility.PUBLIC);
		p.addAttribute(0, a);
		assertEquals(a,p.getObjectUmlAtIndex(0).getAttributeAt(0));
	}

	@Test
	public void testAddMethod() {
		p.addObjectUml(TypeObject.CLASS);
		ArrayList<String> list=new ArrayList<String>();
		Method m=new Method("name","rtype",Visibility.PUBLIC,list);
		p.addMethod(0, m);
		assertEquals(m,p.getObjectUmlAtIndex(0).getMehodAt(0));
	}

}
