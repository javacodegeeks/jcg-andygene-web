#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.dao.MyEntityDAO;
import ${package}.domain.MyEntity;
import ${package}.service.MyEntityService;

@Service("myEntityService")
public class MyEntityServiceImpl implements MyEntityService {
	@Autowired
	private MyEntityDAO myEntityDAO;
	
	private Logger log = LoggerFactory.getLogger(MyEntityServiceImpl.class);

	@Transactional(readOnly=false)
	public void persist(MyEntity entity) {
		myEntityDAO.persist(entity);
		log.info("persist {}",entity);

	}

	@Transactional(readOnly=false)
	public void remove(MyEntity entity) {
		myEntityDAO.remove(entity);
		log.info("remove {}",entity);

	}

	@Transactional(readOnly=false)
	public void removeAll() {
		myEntityDAO.removeAll();
		log.info("removeAll");

	}

	@Transactional(readOnly=false)
	public void refresh(MyEntity entity) {
		myEntityDAO.refresh(entity);
		log.info("refresh {}",entity);

	}

	@Transactional(readOnly=true)
	public MyEntity find(Long id) {
		return myEntityDAO.find(id);
		
	}

	@Transactional(readOnly=false)
	public void flush() {
		myEntityDAO.flush();

	}
	@Transactional(readOnly=false)
	public void merge(MyEntity entity) {
		myEntityDAO.merge(entity);
		log.info("merge {}",entity);
	}

	@Transactional(readOnly=true)
	public long count() {
		return myEntityDAO.count();
	}
	
	@Transactional(readOnly=true)
	public List<MyEntity> findAll() {
		return myEntityDAO.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<MyEntity> findEntries(int firstResult, int maxResults) {
		return myEntityDAO.findEntries(firstResult, maxResults);
	}

}
