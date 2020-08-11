package br.com.residencia.fabrica.controller.form;

import br.com.residencia.fabrica.models.Endereco;

public class EnderecoForm {

	private String bairro;
	private String cep;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco convert() {

		return new Endereco(bairro, cep);

	}

}
