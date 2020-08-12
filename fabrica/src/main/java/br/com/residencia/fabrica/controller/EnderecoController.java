package br.com.residencia.fabrica.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.residencia.fabrica.controller.dto.EnderecoDto;
import br.com.residencia.fabrica.controller.form.EnderecoForm;
import br.com.residencia.fabrica.models.Endereco;
import br.com.residencia.fabrica.repository.EnderecoRepository;

@RestController
@RequestMapping("/fabrica/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository er;

	@GetMapping
	public List<EnderecoDto> listarEnderecos() {

		List<Endereco> enderecos = er.findAll();

		return EnderecoDto.convert(enderecos);

	}

	@GetMapping("/bairro/{startsWith}")
	public List<Endereco> findByStartWidth(@PathVariable String startsWith) {
		String upperCase = startsWith.toUpperCase();
		List<Endereco> enderecos = er.findByBairro(upperCase);

		return enderecos;

	}

	@PostMapping
	public ResponseEntity<EnderecoDto> cadastrarEndereco(@RequestBody EnderecoForm form, UriComponentsBuilder builder) {
		Endereco endereco = form.convert();
		er.save(endereco);

		URI uri = builder.path("fabrica/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));

	}

}
