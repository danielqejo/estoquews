package br.com.caelum.estoque.main;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName="todosOsItens")
	@WebResult(name="item")
	public List<Item> getListaItens(Filtros filtros) {
		System.out.println("Chamando a Lista de Todos os Itens");
		return dao.todosItens(filtros.getLista());
	}
}
