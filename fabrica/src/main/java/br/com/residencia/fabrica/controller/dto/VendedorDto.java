package br.com.residencia.fabrica.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.residencia.fabrica.models.Vendedor;

public class VendedorDto {

	private Long codigo;
	private String nome;
	private String cep;

	public VendedorDto() {
		super();
	}

	public VendedorDto(Vendedor v) {

		this.codigo = v.getCodigo();
		this.nome = v.getNome();
		this.cep = v.getEndereco().getCep();

	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getCep() {
		return cep;
	}

	public static List<VendedorDto> convert(List<Vendedor> v) {

		List<VendedorDto> dto = v.stream().map(VendedorDto::new).collect(Collectors.toList());

		return dto;

	}

	public static VendedorDto convertVendedor(Optional<Vendedor> vendedor) {

		return new VendedorDto(vendedor.get());

	}

}
