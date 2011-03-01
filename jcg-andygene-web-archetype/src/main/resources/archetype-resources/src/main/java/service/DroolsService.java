#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.drools.MyDomain;

public interface DroolsService {

	public void executeRules(MyDomain domain);
	
}
