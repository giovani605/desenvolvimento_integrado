package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Cliente")
public class Cliente {

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente() {
	}

	@Column(name = "Nome")
	private String nome;
	@Column(name = "ClienteID")
	private int id;
}
