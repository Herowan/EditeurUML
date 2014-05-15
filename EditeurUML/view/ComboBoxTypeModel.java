package view;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import model.ProjectUML;

public class ComboBoxTypeModel implements ComboBoxModel{
	ProjectUML model;
	
	public ComboBoxTypeModel(ProjectUML model) {
		this.model=model;
	}

	@Override
	public int getSize() {
		return model.getTypes().typesListSize();
	}

	@Override
	public Object getElementAt(int index) {
		return model.getTypes().getTypeAt(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {}

	@Override
	public void removeListDataListener(ListDataListener l) {}

	@Override
	public void setSelectedItem(Object anItem) {}

	@Override
	public Object getSelectedItem() {return null;}


}
