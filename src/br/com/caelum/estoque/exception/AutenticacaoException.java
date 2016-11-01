package br.com.caelum.estoque.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault")
public class AutenticacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public AutenticacaoException(String mensagem) {
		super(mensagem);
	}

	public String getFaultInfo() {
		return "Token invalido";
	}

}
