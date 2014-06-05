package testPackage;

import static org.junit.Assert.*;
import javax.swing.JButton;
import model.ProjectUML;
import model.TypeObject;
import org.junit.Before;
import org.junit.Test;
import view.NewMethodView;
import controller.OkButtonNewMethodController;

public class OkButtonNewMethodControllerTest {
	OkButtonNewMethodController ok;
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
		NewMethodView view = new NewMethodView(model, 0);
		ok = new OkButtonNewMethodController(view);
		button.addActionListener(ok);
		button.doClick();
		
		assertEquals(1,model.getObjectUmlAtIndex(0).methodeListSize());
	}

}
