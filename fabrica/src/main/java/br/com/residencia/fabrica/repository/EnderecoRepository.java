package br.com.residencia.fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.fabrica.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
