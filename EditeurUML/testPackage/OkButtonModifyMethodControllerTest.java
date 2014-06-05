package testPackage;

import static org.junit.Assert.*;
import java.util.ArrayList;
import javax.swing.JButton;
import model.Method;
import model.ProjectUML;
import model.Type;
import model.TypeObject;
import model.Visibility;
import org.junit.Before;
import org.junit.Test;
import view.ModifyMethodObjectView;
import controller.OkButtonModifyMethodController;

public class OkButtonModifyMethodControllerTest {

	OkButtonModifyMethodController ok;
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
		model.getObjectUmlAtIndex(0).addMethod(new Method("test", new Type().getTypeAt(0), Visibility.DEFAULT, new ArrayList<String>()));
		ModifyMethodObjectView view = new ModifyMethodObjectView(model, 0,0);
		ok = new OkButtonModifyMethodController(view);
		view.getNameTextField().setText("test2");
		
		button.addActionListener(ok);
		button.doClick();
		
		assertEquals("test2", model.getObjectUmlAtIndex(0).getMehodAt(0).getName());
	}

}
