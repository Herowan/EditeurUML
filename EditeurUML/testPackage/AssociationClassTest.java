package testPackage;

import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class AssociationClassTest {

	@Test
	public void testConstructor() {
		ObjectUML o1 = new ObjectUML(TypeObject.CLASS,1,2);
		ObjectUML o2 = new ObjectUML(TypeObject.CLASS,2,2);
		Association a= new Association(o1,o2,2,"name");
		assertEquals(o1,a.getFirstObject());
		assertEquals(o2,a.getLastObject());
		assertEquals(2,a.getTypeOfAssociation());
		assertEquals("name",a.getName());
		assertEquals(0,a.getFirst().getX());
		assertEquals(0,a.getFirst().getY());
		assertEquals(1,a.getLast().getX());
		assertEquals(1,a.getLast().getY());
	}

}
