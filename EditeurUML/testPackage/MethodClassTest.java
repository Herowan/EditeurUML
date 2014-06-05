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
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("int");
		ArrayList<String> li2= new ArrayList<String>();
		li2.add("int");
		li2.add("int");
		ArrayList<String> li3= new ArrayList<String>();
		li3.add("int");
		li3.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		Method m2= new Method("name","void",Visibility.PRIVATE,li2);
		Method m3= new Method("name","void",Visibility.PRIVATE,li3);
		
		assertTrue(m.equals(m2));
		assertFalse(m2.equals(m3));
		
	}
	
	@Test
	public void testgetName(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		
		assertEquals("name",m.getName());
	}
	
	@Test
	public void testsetName(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		
		m.setName("new");
		assertEquals("new",m.getName());
				
	}
	
	@Test
	public void testgetReturnType(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		
		assertEquals("void",m.getReturnType());
	}
	
	@Test
	public void testsetReturnType(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		
		m.setReturnType("int");;
		assertEquals("int",m.getReturnType());
				
	}
	
	@Test
	public void testgetVisibilityM(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		
		assertEquals("private",m.getVisibilityM().getName());
		assertEquals('-',m.getVisibilityM().getCharac());
				
	}
	
	@Test
	public void testsetVisibilityM(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		
		m.setVisibilityM(Visibility.PUBLIC);
		assertEquals("public",m.getVisibilityM().getName());
		assertEquals('+',m.getVisibilityM().getCharac());
	}
	
	@Test
	public void testsetParams(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		ArrayList<String> li2= new ArrayList<String>();
		li2.add("int");
		li2.add("int");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		m.setParams(li2);
		assertEquals("int",m.getParams().get(0));
		assertEquals("int",m.getParams().get(1));
				
	}
	
	@Test
	public void testgetParams(){
		ArrayList<String> li= new ArrayList<String>();
		li.add("int");
		li.add("boolean");
		
		Method m= new Method("name","void",Visibility.PRIVATE,li);
		m.setParams(li);
		
		assertEquals("int",m.getParams().get(0));
		assertEquals("boolean",m.getParams().get(1));
				
	}
	
}
