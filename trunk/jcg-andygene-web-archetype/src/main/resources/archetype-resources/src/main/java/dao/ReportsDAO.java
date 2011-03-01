#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;


import org.springframework.stereotype.Repository;

import ${package}.domain.Reports;

@Repository("reportsDAO")
public class ReportsDAO extends GenericDAO<Reports,Long>{

}
