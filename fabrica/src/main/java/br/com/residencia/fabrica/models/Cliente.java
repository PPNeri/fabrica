package br.com.residencia.fabrica.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private BigDecimal faturamentoAcumulado;
	private BigDecimal limiteDeCredito;
	@OneToOne
	private Endereco endereco;
	@ManyToOne
	private Vendedor vendedor;

	public Cliente() {
		super();
	}

	public Cliente(String nome, Endereco endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getFaturamentoAcumulado() {
		return faturamentoAcumulado;
	}

	public void setFaturamentoAcumulado(BigDecimal faturamentoAcumulado) {
		this.faturamentoAcumulado = faturamentoAcumulado;
	}

	public BigDecimal getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(BigDecimal limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", faturamentoAcumulado=" + faturamentoAcumulado
				+ ", limiteDeCredito=" + limiteDeCredito + ", endereco=" + endereco + ", vendedor=" + vendedor + "]";
	}

}
