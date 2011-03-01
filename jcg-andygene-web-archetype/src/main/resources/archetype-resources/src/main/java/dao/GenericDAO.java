#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAO<E extends Serializable, K extends Serializable> {

	protected Class<E> entityClass;

	@PersistenceContext(unitName = "myUnit")
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		 this.entityClass = (Class<E>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}
		
	public void persist(E e) {
		entityManager.persist(e);
	}
	
	public void remove(E e) {
		entityManager.remove(e);
	}
	
	public void removeAll() {
		entityManager.createQuery("delete from " + entityClass.getName() + " o").executeUpdate();
	}
	
	public void refresh(E e) {
		entityManager.refresh(e);
	}

	public E find(K k) {
		return entityManager.find(entityClass, k);
	}
	
	public void flush() {
		entityManager.flush();
	}
	
	public void merge(E e) {
		entityManager.merge(e);
		entityManager.flush();
	}

	public long count() {
		return entityManager.createQuery("select count(o) from " + entityClass.getName() + " o",Long.class).getSingleResult();
	}

	public List<E> findAll() {
		return entityManager.createQuery("select o from " + entityClass.getName() + " o", entityClass).getResultList();
	}

	public List<E> findEntries(int firstResult, int maxResults) {
		return entityManager.createQuery("select o from " + entityClass.getName() + " o",entityClass).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

}
