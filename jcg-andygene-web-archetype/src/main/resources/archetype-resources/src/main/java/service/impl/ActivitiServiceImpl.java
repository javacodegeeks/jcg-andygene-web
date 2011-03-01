#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;


import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.service.ActivitiService;
@Service("activitiService")
public class ActivitiServiceImpl implements ActivitiService {

	private Logger log = LoggerFactory.getLogger(ActivitiService.class);

	@Autowired
	private RuntimeService runtimeService;
	
	
	
	@Transactional
	public void startProcess() {
		
		log.info("Starting Process");
		runtimeService.startProcessInstanceByKey("JCGProcess");
		
	}

	
	public void sayHelloAction() {
		log.info("Java Code Geeks Say Hello To Activiti");

	}

}
