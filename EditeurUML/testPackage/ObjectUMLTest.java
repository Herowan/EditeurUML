package testPackage;

import static org.junit.Assert.*;
import model.ObjectUML;
import model.TypeObject;

import org.junit.Test;

public class ObjectUMLTest {

	@Test
	public void testEquals() {
		ObjectUML o1 = new ObjectUML(TypeObject.CLASS,1,2);
		o1.setName("test");
		ObjectUML o2 = new ObjectUML(TypeObject.CLASS,2,2);
		o2.setName("test");
		assertTrue(o1.equals(o2));
		
		o2.setName("test2");
		assertFalse(o1.equals(o2));	
	}

}
