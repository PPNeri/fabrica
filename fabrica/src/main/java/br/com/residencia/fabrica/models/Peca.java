package br.com.residencia.fabrica.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Peca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;
	private BigDecimal preco;
	private int quatidadeEstoque;
	@ManyToOne
	private Armazem aramzem;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuatidadeEstoque() {
		return quatidadeEstoque;
	}

	public void setQuatidadeEstoque(int quatidadeEstoque) {
		this.quatidadeEstoque = quatidadeEstoque;
	}

	public Armazem getAramzem() {
		return aramzem;
	}

	public void setAramzem(Armazem aramzem) {
		this.aramzem = aramzem;
	}

	@Override
	public String toString() {
		return "Peca [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quatidadeEstoque="
				+ quatidadeEstoque + ", aramzem=" + aramzem + "]";
	}

}
