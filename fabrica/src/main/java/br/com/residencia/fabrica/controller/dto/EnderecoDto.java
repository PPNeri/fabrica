package br.com.residencia.fabrica.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.residencia.fabrica.models.Endereco;

public class EnderecoDto {

	private Long id;
	private String bairro;
	private String cep;

	public EnderecoDto() {
	}

	public EnderecoDto(Endereco e) {
		this.id = e.getId();
		this.bairro = e.getBairro();
		this.cep = e.getCep();
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public static List<EnderecoDto> convert(List<Endereco> enderecos) {

		return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());

	}

}
