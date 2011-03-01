#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;


import javax.annotation.PostConstruct;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.drools.MyDomain;
import ${package}.service.DroolsService;

@Service("droolsService")
public class DroolsServiceImpl implements DroolsService {
	
	private Logger log = LoggerFactory.getLogger(DroolsService.class);
	
	@Autowired
	private KnowledgeBase kbase1;
	
	
	private StatelessKnowledgeSession ksession1;
	
	
	private StatefulKnowledgeSession ksession2;
	
	
	@PostConstruct
	public void init() {
		ksession1 = kbase1.newStatelessKnowledgeSession();
		ksession2 = kbase1.newStatefulKnowledgeSession();
	}
	
	public void executeRules(MyDomain domain) {
		log.info("Executing Rules");
		ksession1.execute(domain);
//		ksession2.insert(domain);
//		ksession2.fireAllRules();
		
		
	}

}
