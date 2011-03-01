#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice;


import javax.jws.WebService;

import ${package}.domain.MyEntity;

@WebService
public interface MyEntitySOAPService {
	public String insert(MyEntity entity);
	public MyEntity findById(Long id);

}
