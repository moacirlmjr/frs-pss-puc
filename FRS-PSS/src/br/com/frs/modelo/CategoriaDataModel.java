package br.com.frs.modelo;

import java.util.ArrayList;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

public class CategoriaDataModel extends ListDataModel<Categoria> implements
		SelectableDataModel<Categoria> {

	public CategoriaDataModel() {
	}

	public CategoriaDataModel(ArrayList<Categoria> data) {
		super(data);
	}

	@Override
	public Categoria getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) getWrappedData();

		for (Categoria cat : categorias) {
			if (cat.getCategoria().equals(rowKey))
				return cat;
		}
		return null;
	}

	@Override
	public Object getRowKey(Categoria cat) {
		return cat.getCategoria();
	}
}
