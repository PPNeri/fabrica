package br.com.residencia.fabrica.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.residencia.fabrica.models.Endereco;

public class EnderecoDto {

	private Long id;
	private String rua;
	private String bairro;

	public EnderecoDto() {
	}

	public EnderecoDto(Endereco e) {
		this.id = e.getId();
		this.bairro = e.getBairro();
		this.rua = e.getRua();
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public Long getId() {
		return id;
	}

	public static List<EnderecoDto> convert(List<Endereco> enderecos) {

		return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());

	}

}
