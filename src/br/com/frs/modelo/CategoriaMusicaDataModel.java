package br.com.frs.modelo;

import java.util.ArrayList;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

public class CategoriaMusicaDataModel extends ListDataModel<CategoriaMusica> implements
		SelectableDataModel<CategoriaMusica> {

	public CategoriaMusicaDataModel() {
	}

	public CategoriaMusicaDataModel(ArrayList<CategoriaMusica> data) {
		super(data);
	}

	@Override
	public CategoriaMusica getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		ArrayList<CategoriaMusica> categorias = (ArrayList<CategoriaMusica>) getWrappedData();

		for (CategoriaMusica cat : categorias) {
			if (cat.getCategoria().equals(rowKey))
				return cat;
		}
		return null;
	}

	@Override
	public Object getRowKey(CategoriaMusica cat) {
		return cat.getCategoria();
	}
}
