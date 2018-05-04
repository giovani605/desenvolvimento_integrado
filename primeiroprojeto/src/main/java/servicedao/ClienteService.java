package servicedao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidade.Cliente;

public class ClienteService {

	@PersistenceContext
	public EntityManager entityManager;

	public Cliente getById(Long id) {
		return entityManager.find(Cliente.class, id);
	}
	
	public ArrayList<Cliente> getAll(){
		@SuppressWarnings("unchecked")
		ArrayList<Cliente> lista = (ArrayList<Cliente>) 
				entityManager.createQuery( "SELECT c FROM Cliente c").getResultList();	
		
		if(lista.size() > 0){
			return lista;			
		}else{
			return null;
		}
	}
	
}
