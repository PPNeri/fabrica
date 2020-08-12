package br.com.residencia.fabrica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.residencia.fabrica.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query("SELECT e FROM Endereco e where e.bairro like :startsWith%")
	List<Endereco> findByBairro(@Param("startsWith") String startsWith);

}
