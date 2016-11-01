package br.com.caelum.estoque.main;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.exception.AutenticacaoException;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName="todosOsItens")
	@WebResult(name="item")
	@ResponseWrapper(localName="itens")
	@RequestWrapper(localName="listaItens")
	public List<Item> getListaItens(@WebParam(name="filtros")Filtros filtros) {
		System.out.println("Chamando a Lista de Todos os Itens");
		return dao.todosItens(filtros.getLista());
	}
	
	@WebMethod(operationName="cadastrarItem")
	@WebResult(name="item")
	public Item cadastraItem(
			@WebParam(name="token",header=true)TokenUsuario token,
			@WebParam(name="item")Item item) throws AutenticacaoException{
		boolean ehValido = new TokenDao().ehValido(token);
		
		if(!ehValido)
			throw new AutenticacaoException("Token Invalido!");
		
		this.dao.cadastrar(item);
		System.out.println("Item cadastrado: " + item);
		return item;
	}
}
