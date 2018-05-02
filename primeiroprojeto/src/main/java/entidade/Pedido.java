package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Pedido")
public class Pedido {

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "ClienteID")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	@Column(name = "NumeroPedido")
	private int numeroPedido;
	@Column(name = "data_pedido")
	private Date data_pedido;
}
