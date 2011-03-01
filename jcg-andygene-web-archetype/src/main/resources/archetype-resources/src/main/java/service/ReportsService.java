#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;


import java.util.List;

import ${package}.domain.Reports;

public interface ReportsService {
	public void initReports(int maxNumbers);
	public List<Reports> getReports();

}
