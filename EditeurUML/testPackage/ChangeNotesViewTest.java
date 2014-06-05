package testPackage;

import static org.junit.Assert.*;
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
	public void test() {
	}

}
