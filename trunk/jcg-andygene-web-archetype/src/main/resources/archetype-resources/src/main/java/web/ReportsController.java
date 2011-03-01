#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ${package}.service.ReportsService;
import ${package}.util.FormatUtil;
import ${package}.util.ReportUtil;

@RequestMapping("/reports")
@Controller
public class ReportsController {
	
	
	
	@Autowired
	private ReportsService reportsService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String fireReport(@ModelAttribute("formatUtil") @Valid FormatUtil formatUtil,BindingResult result,ModelMap modelMap,Model model,HttpServletRequest request) {
		JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(reportsService.getReports(),false);
		modelMap.put("format",formatUtil.getFormat());
		modelMap.put("reportList", jrDataSource);
		return "reportList";
	 }
	
	@RequestMapping(method = RequestMethod.POST)
    public String createForm(@ModelAttribute("reportUtil") @Valid ReportUtil reportUtil,BindingResult result,Model model,HttpServletRequest request) {
		if (result.hasErrors()) { 
			model.addAttribute("entitiesSelected","false");
	        model.addAttribute("jmsSelected","false");
	        model.addAttribute("reportsSelected","true");
	        model.addAttribute("droolsSelected","false");
	        model.addAttribute("activitiSelected","false");
			return "reports/init";  
		}  
		reportsService.initReports(reportUtil.getNumber().intValue());
		model.addAttribute("formatUtil", new FormatUtil());
		model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","true");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
		return "reports/generate";
    }
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model model) {
    
        model.addAttribute("reportUtil", new ReportUtil());
        model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","true");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "reports/init";
    }
	
	@RequestMapping(params = "generate", method = RequestMethod.GET)
    public String generateForm(Model model) {
    
        model.addAttribute("formatUtil", new FormatUtil());
        model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","true");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "reports/generate";
    }

}
