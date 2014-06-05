package testPackage;

import static org.junit.Assert.*;

import javax.swing.JButton;
import model.Attribute;
import model.ProjectUML;
import model.Type;
import model.TypeObject;
import model.Visibility;
import org.junit.Before;
import org.junit.Test;
import view.ModifyAttributeObjectView;
import controller.OkButtonModifyAttributeController;

public class OkButtonModifyAttributeControllerTest {
	OkButtonModifyAttributeController ok;
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
		model.getObjectUmlAtIndex(0).addAttribute(new Attribute("test", new Type().getTypeAt(0), Visibility.DEFAULT));
		ModifyAttributeObjectView view = new ModifyAttributeObjectView(model,0,0);
		ok = new OkButtonModifyAttributeController(view);
		view.getNameTextField().setText("test2");
		
		button.addActionListener(ok);
		button.doClick();
		
		assertEquals("test2", model.getObjectUmlAtIndex(0).getAttributeAt(0).getName());

	}

}
