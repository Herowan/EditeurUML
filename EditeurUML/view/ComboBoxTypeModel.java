package view;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import model.ProjectUML;

public class ComboBoxTypeModel implements ComboBoxModel<String>{
	ProjectUML model;
	String anItem;
	int typeModel;
	
	public ComboBoxTypeModel(ProjectUML model, int typeModel) {
		this.model=model;
		this.typeModel=typeModel;
	}

	@Override
	public int getSize() {
		return model.getTypes().typesListSize();
	}

	@Override
	public String getElementAt(int index) {
		if (typeModel==0) return model.getTypes().getTypeAt(index);
		
		if(index==0){
			return "---";
		} else { 
			return model.getTypes().getTypeAt(index);
		}
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
