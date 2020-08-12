package br.com.residencia.fabrica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.fabrica.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	List<Vendedor> findByNome(String name);

}
