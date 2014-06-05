package testPackage;

import static org.junit.Assert.*;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import model.EditeurUML;
import org.junit.Before;
import org.junit.Test;
import view.ChangesNotesView;

public class ChangeNotesViewTest {
	ChangesNotesView view;
	
	@Before
	public void setup() {
		EditeurUML editeur = new EditeurUML();
		view=new ChangesNotesView(editeur.getProject());
		view.setVisible(true);
	}

	@Test
	public void testDefault() {
		assertTrue(view.isShowing());
		assertTrue(view.isEnabled());
	}
	
	@Test
	public void testComposition(){
		java.awt.Container c = view.getContentPane();
		assertEquals(4, c.getComponents().length);
		
		Component cp = c.getComponent(0);
		assertTrue(cp instanceof JScrollPane);
		
		cp = c.getComponent(2);
		assertTrue(cp instanceof JButton);
		assertEquals("Cancel", ((JButton) cp).getText());
		
		cp = c.getComponent(1);
		assertTrue(cp instanceof JLabel);
		assertEquals("Notes :", ((JLabel) cp).getText());
		
		cp = c.getComponent(3);
		assertTrue(cp instanceof JButton);
		assertEquals("Save", ((JButton) cp).getText());
	}

	@Test
	public void testAddNote() {
		view.getjTextArea1().setText("Hello world");
		java.awt.Container c = view.getContentPane();
		JButton cp = (JButton) c.getComponent(3);
		cp.doClick();
		
		assertEquals("Hello world",view.getModel().getNotes());
	}


}
