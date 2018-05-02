package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Produto")
public class Produto {

	public Produto() {

	}

	@Column(name = "ProdutoID")
	private int id;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "preco")
	private int preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}
}
