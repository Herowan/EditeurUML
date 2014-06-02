package view;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import model.ProjectUML;

public class ComboBoxClassModel implements ComboBoxModel<String> {
	ProjectUML model;
	String item;
	
	public ComboBoxClassModel(ProjectUML model) {
		this.model=model;
	}

	@Override
	public int getSize() {
		return model.objectsListSize();
	}

	@Override
	public String getElementAt(int index) {
		return model.getObjectUmlAtIndex(index).getName();
	}

	@Override
	public void addListDataListener(ListDataListener l) {}

	@Override
	public void removeListDataListener(ListDataListener l) {}

	@Override
	public void setSelectedItem(Object anItem) {
		item=(String) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return item;
	}

}
