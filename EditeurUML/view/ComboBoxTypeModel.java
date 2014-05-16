package view;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import model.ProjectUML;

public class ComboBoxTypeModel implements ComboBoxModel<String>{
	ProjectUML model;
	String anItem;
	
	public ComboBoxTypeModel(ProjectUML model) {
		this.model=model;
	}

	@Override
	public int getSize() {
		return model.getTypes().typesListSize();
	}

	@Override
	public String getElementAt(int index) {
		return model.getTypes().getTypeAt(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {}

	@Override
	public void removeListDataListener(ListDataListener l) {}

	@Override
	public String getSelectedItem() {return anItem;}

	@Override
	public void setSelectedItem(Object anItem) {
		this.anItem=(String) anItem;
		
	}


}
