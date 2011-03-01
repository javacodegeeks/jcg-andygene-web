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

import ${package}.jms.MyQueueSender;
import ${package}.util.JMSUtil;

@RequestMapping("/jms")
@Controller
public class JMSController {
		
	@Autowired
	private MyQueueSender myQueueSender;
	
	@RequestMapping(method = RequestMethod.POST)
    public String createForm(@ModelAttribute("jmsUtil") @Valid JMSUtil jmsUtil,BindingResult result,Model model,HttpServletRequest request) {
		if (result.hasErrors()) { 
			jmsUtil.setReply("");
			model.addAttribute("jmsUtil",jmsUtil);
			model.addAttribute("entitiesSelected","false");
	        model.addAttribute("jmsSelected","true");
	        model.addAttribute("reportsSelected","false");
	        model.addAttribute("droolsSelected","false");
	        model.addAttribute("activitiSelected","false");
			return "jms/jms";  
		}  
		myQueueSender.sendMessage(jmsUtil.getMessage());
		jmsUtil.setReply("Message Send Success Check Catalina logs");
		model.addAttribute("jmsUtil",jmsUtil);
		model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","true");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
    	return "jms/jms";
    }
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model model) {
    
        model.addAttribute("jmsUtil", new JMSUtil());
        model.addAttribute("entitiesSelected","false");
        model.addAttribute("jmsSelected","true");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "jms/jms";
    }

}
