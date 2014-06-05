package testPackage;

import static org.junit.Assert.*;
import model.EditeurUML;
import model.ProjectUML;

import org.junit.Test;

public class EditeurUMLTest {
	EditeurUML e=new EditeurUML();

	@Test
	public void testConstructorEditeurUml() {
		EditeurUML e=new EditeurUML();
		assertNotNull(e.getProjectList());
		assertNotNull(e.getProject());
	}
	
	@Test
	public void testAddProject(){
		ProjectUML p=new ProjectUML();
		e.addProject(p);
		assertEquals(p,e.getProjectList().get(0));
	}

}
