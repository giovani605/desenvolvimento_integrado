package entidade;

import javax.persistence.Column;

public class Endereco {

	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "EnderecoID")
	private int id;

	@Column(name = "clienteID")
	private int clienteID;

	@Column(name = "rua")
	private String rua;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private String estado;

}
