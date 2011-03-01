#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice.impl;


import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.domain.MyEntity;
import ${package}.service.MyEntityService;
import ${package}.webservice.MyEntitySOAPService;

@WebService(endpointInterface = "${package}.webservice.MyEntitySOAPService")
public class MyEntitySOAPServiceImpl implements MyEntitySOAPService {

	private Logger log = LoggerFactory.getLogger(MyEntitySOAPService.class);
	
	@Autowired
	private MyEntityService myEntityService;
	
	public String insert(@WebParam(name = "myentity")MyEntity entity) {
		log.info("insert method invoked");
		myEntityService.persist(entity);
		return "entity with id =[{"+entity.getId()+"}] persisted";
	}
	
	public MyEntity findById(@WebParam(name = "id")Long id) {
		return myEntityService.find(id);
	}

}
