#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ${package}.drools.MyDomain;
import ${package}.service.DroolsService;

@RequestMapping("/drools")
@Controller
public class DroolsController {
	
	
	
	@Autowired
	private DroolsService droolsService;
	
		
	@RequestMapping(method = RequestMethod.POST)
    public String createForm(@ModelAttribute("drools") @Valid MyDomain drools,BindingResult result,Model model,HttpServletRequest request) {
		if (result.hasErrors()) { 
			drools.setDescription("");
			model.addAttribute("drools",drools);
			model.addAttribute("entitiesSelected","false");
	        model.addAttribute("jmsSelected","false");
	        model.addAttribute("reportsSelected","false");
	        model.addAttribute("droolsSelected","true");
	        model.addAttribute("activitiSelected","false");
			return "drools/drools";  
		}  
		droolsService.executeRules(drools);
		model.addAttribute("drools",drools);
		model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","true");
        model.addAttribute("activitiSelected","false");
    	return "drools/drools";
    }
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model model) {
    
        model.addAttribute("drools", new MyDomain());
        model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","true");
        model.addAttribute("activitiSelected","false");
        return "drools/drools";
    }

}
