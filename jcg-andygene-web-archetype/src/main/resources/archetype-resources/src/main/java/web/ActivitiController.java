#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ${package}.service.ActivitiService;

@RequestMapping("/activiti")
@Controller
public class ActivitiController {
	
	
	@Autowired
	private ActivitiService activitiService;
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String executeProcess(Model model) {
		activitiService.startProcess();
		model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","true");
		return "activiti/activiti";
    }

}