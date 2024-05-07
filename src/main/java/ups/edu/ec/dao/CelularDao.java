package ups.edu.ec.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.model.Celular;

@Stateless
public class CelularDao {

	@PersistenceContext
	private EntityManager em;

	public void insert(Celular celular) {
		em.persist(celular);
	}

	public void update(Celular celular) {
		em.merge(celular);
	}

	public void remove(int codigo) {
		Celular celular = em.find(Celular.class, codigo);
		em.remove(celular);
	}

	public Celular read(int codigo) {
		Celular celular = em.find(Celular.class, codigo);
		return celular;
	}

	public List<Celular> getAll() {
		String jpql = "SELECT c FROM Celular c";
		Query q = em.createQuery(jpql, Celular.class);
		return q.getResultList();
	}


	public Celular getCelularPorId(int codigo) {
		String jpql = "SELECT c FROM Celular c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Celular.class);
		q.setParameter("codigo", codigo);
		List<Celular> Celulars = q.getResultList();
		if (Celulars.size() > 0)
			return Celulars.get(0);
		return null;
	}
}
