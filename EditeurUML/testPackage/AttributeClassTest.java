package testPackage;

import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class AttributeClassTest {

	@Test
	public void testConstructor() {
		Attribute a=new Attribute("name","Type",Visibility.DEFAULT);
		assertEquals("name",a.getName());
		assertEquals("Type",a.getType());
		assertEquals("name",a.getName());
		assertEquals(Visibility.DEFAULT,a.getVisibilityA());
	}

	@Test
	public void testEqualsAttribute(){
		Attribute a=new Attribute("name","Type",Visibility.DEFAULT);
		Attribute b=new Attribute("name","Type",Visibility.DEFAULT);
		Attribute c=new Attribute("nom","Type",Visibility.DEFAULT);
		Attribute d=new Attribute("name","typ",Visibility.DEFAULT);
		assertTrue(a.equals(b));
		assertTrue(a.equals(d));
		assertFalse(a.equals(c));
	}
	
	@Test
	public void testAttributeToString(){
		Attribute a=new Attribute("name","Type",Visibility.PRIVATE);
		assertEquals("- name: Type",a.toString());
	}
}
