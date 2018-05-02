package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "PedidoDetalhe")
public class PedidoDetalhe {

	public PedidoDetalhe() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "NroPedido")
	private int nroPedido;

	@Column(name = "ProdutoID")
	private int produtoID;

	public int getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(int nroPedido) {
		this.nroPedido = nroPedido;
	}

	public int getProdutoID() {
		return produtoID;
	}

	public void setProdutoID(int produtoID) {
		this.produtoID = produtoID;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	@Column(name = "Quantidade")
	private int qtd;

	@Column(name = "Preco")
	private int preco;

}
