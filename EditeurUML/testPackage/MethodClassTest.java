package testPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.*;

import org.junit.Test;

public class MethodClassTest {

	@Test
	public void testConstructor() {
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("int");
		Method m= new Method("name","void",Visibility.DEFAULT,li);
		assertEquals("name",m.getName());
		assertEquals("void",m.getReturnType());
		assertEquals(Visibility.DEFAULT,m.getVisibilityM());
		assertEquals("int",m.getParams().get(0));
		assertEquals("int",m.getParams().get(1));
	}
	
	@Test
	public void testToString(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("int");
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		assertEquals("name(int, int) : void",m.toString());
	}

	@Test
	public void testEquals(){
		
	}
}
