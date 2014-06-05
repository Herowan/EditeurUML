package testPackage;

import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class TypeClassTest {

	@Test
	public void testConstructeur() {
		Type t=new Type();
		assertEquals("void",t.getTypeAt(0));
		assertEquals("long",t.getTypeAt(5));
		assertEquals("String",t.getTypeAt(9));
	}
	
	@Test
	public void testgetTypeAt(){
		Type t=new Type();
		assertEquals("long",t.getTypeAt(5));
	}
	
	@Test
	public void testtypesListSize(){
		Type t=new Type();
		assertEquals(10,t.typesListSize());
	}
	
	@Test
	public void testremove(){
		Type t=new Type();
		t.remove("void");
		assertEquals(9,t.typesListSize());
	}

	@Test
	public void testaddType(){
		Type t=new Type();
		t.addType("new");
		assertEquals(11,t.typesListSize());
	}
}
