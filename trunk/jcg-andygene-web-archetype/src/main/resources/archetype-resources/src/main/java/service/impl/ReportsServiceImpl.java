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

import ${package}.dao.ReportsDAO;
import ${package}.domain.Reports;
import ${package}.service.ReportsService;
@Service("reportsService")
public class ReportsServiceImpl implements ReportsService {
	
	private Logger log = LoggerFactory.getLogger(ReportsService.class);
	
	@Autowired
	private ReportsDAO reportsDAO;
	
	@Transactional
	public void initReports(int maxNumbers) {
		log.info("Generating [{}] reports data",maxNumbers);
		Reports reports = null;
		for(int i = 0;i < maxNumbers;i++) {
			reports = new Reports();
			reports.setName("Name"+i);
			reports.setPrice((double)i);
			reports.setDescription("Description"+i);
			reportsDAO.persist(reports);
		}

	}

	public List<Reports> getReports() {
		return reportsDAO.findAll();
	}

}
