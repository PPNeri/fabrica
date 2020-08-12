package br.com.residencia.fabrica.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.residencia.fabrica.controller.dto.VendedorDto;
import br.com.residencia.fabrica.controller.form.VendedorForm;
import br.com.residencia.fabrica.models.Vendedor;
import br.com.residencia.fabrica.repository.EnderecoRepository;
import br.com.residencia.fabrica.repository.VendedorRepository;

@RestController
@RequestMapping("/fabrica/vendedores")
public class VendedorController {

	@Autowired
	VendedorRepository vr;
	@Autowired
	EnderecoRepository er;

	@GetMapping
	public List<VendedorDto> findAllVendedores() {
		List<Vendedor> vendedores = vr.findAll();

		List<VendedorDto> vendedoresDto = VendedorDto.convert(vendedores);

		return vendedoresDto;

	}

//	Retornando um vendedor unico
	@GetMapping("/{id}")
	public VendedorDto findVendedorById(@PathVariable Long id) {

		Optional<Vendedor> vendedor = vr.findById(id);

		VendedorDto convertVendedor = VendedorDto.convertVendedor(vendedor);

		return convertVendedor;

	}

	@GetMapping("/nome/{nome}")
	public List<VendedorDto> findVendedorByNome(@PathVariable String nome) {

		List<Vendedor> vendedor = vr.findByNome(nome);

		return VendedorDto.convert(vendedor);

	}

	@PostMapping("/")
	ResponseEntity<VendedorDto> save(@RequestBody @Valid VendedorForm form, UriComponentsBuilder builder) {

		Vendedor vendedor = form.convert(er);

		vr.save(vendedor);

		URI uri = builder.path("/vendedores/{id}").buildAndExpand(vendedor.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(new VendedorDto(vendedor));

	}

}
