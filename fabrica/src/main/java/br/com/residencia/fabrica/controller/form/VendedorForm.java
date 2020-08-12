package br.com.residencia.fabrica.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.residencia.fabrica.models.Endereco;
import br.com.residencia.fabrica.models.Vendedor;
import br.com.residencia.fabrica.repository.EnderecoRepository;

public class VendedorForm {
	@NotNull
	private String nome;
	private Long enderecoId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}

	public Vendedor convert(EnderecoRepository er) {

		Optional<Endereco> endereco = er.findById(enderecoId);

		return new Vendedor(nome, endereco.get());

	}

}
