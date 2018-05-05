package servicedao;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidade.Cliente;

public class ClienteService {

	@PersistenceContext
	public EntityManager entityManager;

	public Cliente getById(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	public ArrayList<Cliente> getAll() {
		@SuppressWarnings("unchecked")
		ArrayList<Cliente> lista = (ArrayList<Cliente>) entityManager.createQuery("SELECT c FROM Cliente c")
				.getResultList();

		if (lista.size() > 0) {
			return lista;
		} else {
			return null;
		}
	}

	// id do cliente
	public void fecharFaturamento(Long id) {

	}

	public void fecharFaturamentoMes(Long idCliente, Date date) {

		String sql = "SELECT * from pedido p inner join pedidodetalhe"
				+ " as pd on p.numeropedido = pd.nropedido inner join produto"
				+ " as prod on pd.produtoid = prod.produtoid where p.clienteid=1 ?1 "
				+ " and   extract(month from p.data_pedido) = ?2  and extract(year from p.data_pedido) = ?3";
		Query query = this.entityManager.createQuery(sql);
		query.setParameter(1, idCliente);
		query.setParameter(2, date.getMonth());
		query.setParameter(3, date.getYear());
		query.getResultList();
		// fazer alguma coisa

	}

	public void fecharFaturamentoAno(Long idCliente, Date date) {

		String sql = "SELECT * from pedido p inner join pedidodetalhe"
				+ " as pd on p.numeropedido = pd.nropedido inner join produto"
				+ " as prod on pd.produtoid = prod.produtoid where p.clienteid=1 ?1 "
				+ " and extract(year from p.data_pedido) = ?2";
		Query query = this.entityManager.createQuery(sql);
		query.setParameter(1, idCliente);
		query.setParameter(2, date.getYear());
		query.getResultList();
		// fazer alguma coisa

	}

}
