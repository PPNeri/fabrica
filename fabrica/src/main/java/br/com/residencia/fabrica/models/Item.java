package br.com.residencia.fabrica.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private int quantidade;
	private BigDecimal precoCotado;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Peca peca;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoCotado() {
		return precoCotado;
	}

	public void setPrecoCotado(BigDecimal precoCotado) {
		this.precoCotado = precoCotado;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", quantidade=" + quantidade + ", precoCotado=" + precoCotado + ", pedido="
				+ pedido + ", peca=" + peca + "]";
	}

}
