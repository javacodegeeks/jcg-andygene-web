#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;


import java.util.List;

import ${package}.domain.MyEntity;

public interface MyEntityService {
	public void persist(MyEntity entity);
	public void remove(MyEntity entity);
	public void removeAll();
	public void refresh(MyEntity entity);
	public MyEntity find(Long id);
	public void flush();
	public void merge(MyEntity entity);
	public long count();
	public List<MyEntity> findAll();
	public List<MyEntity> findEntries(int firstResult, int maxResults);
	
}
