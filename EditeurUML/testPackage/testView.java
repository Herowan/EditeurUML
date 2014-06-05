package testPackage;

import static org.junit.Assert.*;
import java.awt.Component;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import model.EditeurUML;
import model.TypeObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.MainView;

public class testView {
	MainView view;

	@Before
	public void setup() {
		EditeurUML editeur = new EditeurUML();
		view=new MainView(editeur);
		view.setVisible(true);
	}

	@Test
	public void testDefault() {
		assertTrue(view.isShowing());
		assertTrue(view.isEnabled());
		
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JToolBar jtb = (JToolBar) p.getComponent(0);
		JButton btn = (JButton) jtb.getComponent(0);
		btn.doClick();
		assertEquals(null, view.getModel().getProject().getSavePath());
	}
	
	@Test
	public void testObservable(){
		Observable mod = view.getModel();
		assertNotNull(mod);
		int nbObs = mod.countObservers();
		assertTrue(nbObs > 0);
		mod.deleteObserver(view);
		assertEquals(nbObs-1,
		 mod.countObservers());
	}
	
	@Test 
	public void testCompositionGeneral(){
		java.awt.Container c = view.getContentPane();
		assertEquals(2, c.getComponents().length);
		for (Component cp : c.getComponents())
			assertTrue(cp instanceof JPanel);
	}
	
	@Test 
	public void testCompositionFirstPanel(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		assertEquals(2, p.getComponents().length);
		
		Component cp = p.getComponent(0);
		assertTrue(cp instanceof JToolBar);
		
		cp = p.getComponent(1);
		assertTrue(cp instanceof JScrollPane);
	}
	
	@Test
	public void testCompositionSecondPanel(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(1);
		assertEquals(8, p.getComponents().length);
		Component cp = p.getComponent(0);
		assertTrue(cp instanceof JSeparator);

		for (int i=1; i<p.getComponents().length; i++){
			cp = p.getComponent(i);
			assertTrue(cp instanceof JButton);
		}
	}
	
	@Test
	public void testCompositionJScrollPane(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JScrollPane jsp = (JScrollPane) p.getComponent(1);
		assertEquals(3, jsp.getComponents().length);
	}
	
	@Test 
	public void testCompositionJToolBar(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JToolBar jtb = (JToolBar) p.getComponent(0);
		assertEquals(4, jtb.getComponents().length);
		for (Component cp : jtb.getComponents())
			assertTrue(cp instanceof JButton);		
	}
	@Test 
	public void testJToolBarButtonComposition1(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JToolBar jtb = (JToolBar) p.getComponent(0);
		assertEquals("", ((JButton) jtb.getComponent(0)).getText());
	}
	@Test 
	public void testJToolBarButtonComposition2(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JToolBar jtb = (JToolBar) p.getComponent(0);
		assertEquals("", ((JButton) jtb.getComponent(1)).getText());
	}
	@Test 
	public void testJToolBarButtonComposition3(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JToolBar jtb = (JToolBar) p.getComponent(0);
		assertEquals("", ((JButton) jtb.getComponent(2)).getText());
	}
	@Test 
	public void testJToolBarButtonComposition4(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JToolBar jtb = (JToolBar) p.getComponent(0);
		assertEquals("", ((JButton) jtb.getComponent(3)).getText());
	}
	
	@Test
	public void testToolBarButtonNew(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(0);
		JToolBar jtb = (JToolBar) p.getComponent(0);
		JButton btn = (JButton) jtb.getComponent(0);
		btn.doClick();
		assertEquals(null, view.getModel().getProject().getSavePath());
	}
	@Test
	public void testButtonClass(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(1);
		JButton btn = (JButton) p.getComponent(2);
		btn.doClick();
		assertEquals(1, view.getModel().getProject().objectsListSize());
		assertEquals(TypeObject.CLASS, view.getModel().getProject().getObjectUmlAtIndex(0).getObjectType());
		assertEquals("Class1", view.getModel().getProject().getObjectUmlAtIndex(0).getName());
		assertEquals(0, view.getModel().getProject().getObjectUmlAtIndex(0).attributListSize());
		assertEquals(0, view.getModel().getProject().getObjectUmlAtIndex(0).methodeListSize());
	}
	@Test
	public void testButtonAbstract(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(1);
		JButton btn = (JButton) p.getComponent(1);
		btn.doClick();
		assertEquals(1, view.getModel().getProject().objectsListSize());
		assertEquals(TypeObject.ABSTRACT_CLASS, view.getModel().getProject().getObjectUmlAtIndex(0).getObjectType());
		assertEquals("AbstractClass1", view.getModel().getProject().getObjectUmlAtIndex(0).getName());
		assertEquals(0, view.getModel().getProject().getObjectUmlAtIndex(0).attributListSize());
		assertEquals(0, view.getModel().getProject().getObjectUmlAtIndex(0).methodeListSize());
	}
	public void testButtonInterface(){
		java.awt.Container c = view.getContentPane();
		JPanel p = (JPanel) c.getComponent(1);
		JButton btn = (JButton) p.getComponent(2);
		btn.doClick();
		assertEquals(1, view.getModel().getProject().objectsListSize());
		assertEquals(TypeObject.INTERFACE, view.getModel().getProject().getObjectUmlAtIndex(0).getObjectType());
		assertEquals("Interface1", view.getModel().getProject().getObjectUmlAtIndex(0).getName());
		assertEquals(0, view.getModel().getProject().getObjectUmlAtIndex(0).attributListSize());
		assertEquals(0, view.getModel().getProject().getObjectUmlAtIndex(0).methodeListSize());
	}
	
	

	@After
	public void teardown() {
	 view.dispose();
	}
}
