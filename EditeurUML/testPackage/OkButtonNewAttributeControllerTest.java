package testPackage;

import static org.junit.Assert.*;
import javax.swing.JButton;
import model.ProjectUML;
import model.TypeObject;
import org.junit.Before;
import org.junit.Test;
import view.NewAttributeView;
import controller.OkButtonNewAttributeController;

public class OkButtonNewAttributeControllerTest {
	OkButtonNewAttributeController ok;
	JButton button;
	ProjectUML model;
	
	@Before
	public void before(){
		model = new ProjectUML();
		button = new JButton();
	}

	@Test
	public void testAttribute() {		
		model.addObjectUml(TypeObject.CLASS);
		NewAttributeView view = new NewAttributeView(model, 0);
		ok = new OkButtonNewAttributeController(view);
		button.addActionListener(ok);
		button.doClick();
		
		assertEquals(1,model.getObjectUmlAtIndex(0).attributListSize());
	}

}
