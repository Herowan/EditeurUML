package testPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Attribute;
import model.Method;
import model.ObjectUML;
import model.Type;
import model.TypeObject;
import model.Visibility;

import org.junit.Before;
import org.junit.Test;

public class ObjectUMLTest {
	ObjectUML o1;
	
	@Before
	public void before(){
		o1 = new ObjectUML(TypeObject.CLASS,1,2);
	}

	@Test
	public void testEquals() {
		o1.setName("test");
		ObjectUML o2 = new ObjectUML(TypeObject.CLASS,2,2);
		o2.setName("test");
		assertTrue(o1.equals(o2));
		
		o2.setName("test2");
		assertFalse(o1.equals(o2));	
	}

	@Test
	public void testAddMethod(){
		assertEquals(0,o1.methodeListSize());
		o1.addMethod(new Method("test", new Type().getTypeAt(0), Visibility.DEFAULT, new ArrayList<String>()));
		assertEquals(1,o1.methodeListSize());
		assertEquals("test",o1.getMehodAt(0).getName());
	}
	
	@Test
	public void testSizeMethod(){
		assertEquals(0,o1.methodeListSize());
		o1.addMethod(new Method("test", new Type().getTypeAt(0), Visibility.DEFAULT, new ArrayList<String>()));
		assertEquals(1,o1.methodeListSize());
		o1.addMethod(new Method("test1", new Type().getTypeAt(0), Visibility.DEFAULT, new ArrayList<String>()));
		assertEquals(2,o1.methodeListSize());
		o1.addMethod(new Method("test", new Type().getTypeAt(0), Visibility.DEFAULT, new ArrayList<String>()));
		assertEquals(3,o1.methodeListSize());
	}
	@Test
	public void testAddAttribut(){
		assertEquals(0,o1.attributListSize());
		o1.addAttribute(new Attribute("test", new Type().getTypeAt(0), Visibility.DEFAULT));
		assertEquals(1,o1.attributListSize());
		assertEquals("test",o1.getAttributeAt(0).getName());
	}
	
	@Test
	public void testSizeAttribute(){
		assertEquals(0,o1.attributListSize());
		o1.addAttribute(new Attribute("test", new Type().getTypeAt(0), Visibility.DEFAULT));
		assertEquals(1,o1.attributListSize());
		o1.addAttribute(new Attribute("test2", new Type().getTypeAt(0), Visibility.DEFAULT));
		assertEquals(2,o1.attributListSize());
		o1.addAttribute(new Attribute("test3", new Type().getTypeAt(0), Visibility.DEFAULT));
		assertEquals(3,o1.attributListSize());
	}
	
	@Test
	public void testDeleteMethod(){
		assertEquals(0,o1.methodeListSize());
		o1.addMethod(new Method("test", new Type().getTypeAt(0), Visibility.DEFAULT, new ArrayList<String>()));
		assertEquals(1,o1.methodeListSize());
		o1.deleteMethod(0);
		assertEquals(0,o1.methodeListSize());
	}
	
	@Test
	public void testDeleteAttribut(){
		assertEquals(0,o1.attributListSize());
		o1.addAttribute(new Attribute("test", new Type().getTypeAt(0), Visibility.DEFAULT));
		assertEquals(1,o1.attributListSize());
		o1.deleteAttribute(0);
		assertEquals(0,o1.attributListSize());
	}
	@Test
	public void testIsAbove(){
		ObjectUML o2 = new ObjectUML(TypeObject.CLASS,2,2);
		o2.setPosition(10, 10);
		o1.setPosition(0, 0);
		assertEquals(10,o1.isAbove(o2));
	}
	@Test
	public void testIsOnTheRight(){
		ObjectUML o2 = new ObjectUML(TypeObject.CLASS,2,2);
		o2.setPosition(10, 10);
		o1.setPosition(0, 0);
		assertEquals(-10,o1.isOnTheRigth(o2));
	}
}
