package br.com.frs.modelo;

import java.util.ArrayList;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

public class CategoriaFilmeDataModel extends ListDataModel<CategoriaFilme> implements
		SelectableDataModel<CategoriaFilme> {

	public CategoriaFilmeDataModel() {
	}

	public CategoriaFilmeDataModel(ArrayList<CategoriaFilme> data) {
		super(data);
	}

	@Override
	public CategoriaFilme getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		ArrayList<CategoriaFilme> categorias = (ArrayList<CategoriaFilme>) getWrappedData();

		for (CategoriaFilme cat : categorias) {
			if (cat.getCategoria().equals(rowKey))
				return cat;
		}
		return null;
	}

	@Override
	public Object getRowKey(CategoriaFilme cat) {
		return cat.getCategoria();
	}
}
