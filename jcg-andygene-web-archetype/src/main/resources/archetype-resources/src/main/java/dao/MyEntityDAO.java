#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;


import org.springframework.stereotype.Repository;

import ${package}.domain.MyEntity;

@Repository("myEntityDAO")
public class MyEntityDAO extends GenericDAO<MyEntity,Long> {
	

}
