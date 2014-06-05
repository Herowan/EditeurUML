package testPackage;

import static org.junit.Assert.*;
import javax.swing.JButton;
import model.ProjectUML;
import model.TypeObject;
import org.junit.Before;
import org.junit.Test;
import view.ModifyNameObjectView;
import controller.OkButtonModifyNameController;

public class OkButtonModifyNameControllerTest {
	OkButtonModifyNameController ok;
	JButton button;
	ProjectUML model;
	
	@Before
	public void before(){
		model = new ProjectUML();
		button = new JButton();
	}

	@Test
	public void testActionPerformed() {
		model.addObjectUml(TypeObject.CLASS);
		model.getObjectUmlAtIndex(0).setName("test");
		ModifyNameObjectView view = new ModifyNameObjectView(model, 0);
		ok = new OkButtonModifyNameController(view);
		view.getNameTextField().setText("test2");
		
		button.addActionListener(ok);
		button.doClick();
		
		assertEquals("test2", model.getObjectUmlAtIndex(0).getName());

	}

}
