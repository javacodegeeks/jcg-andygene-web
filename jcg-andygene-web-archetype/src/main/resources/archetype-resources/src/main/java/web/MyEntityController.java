#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;



import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import ${package}.domain.MyEntity;
import ${package}.service.MyEntityService;

@RequestMapping("/myentity")
@Controller
public class MyEntityController {
	private Logger log = LoggerFactory.getLogger(MyEntityController.class);
	
	@Autowired 
	private MyEntityService myEntityService;

	@RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("myEntity") @Valid MyEntity myEntity, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {  
			return "myentity/create";  
		}  
        myEntityService.persist(myEntity);
        model.addAttribute("myentity", myEntity);
        model.addAttribute("entitiesSelected","true");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "myentity/show";
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model model) {
    	log.info("Request for new Form");
        model.addAttribute("myEntity", new MyEntity());
        model.addAttribute("entitiesSelected","true");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "myentity/create";
    }
    
    
    
    @RequestMapping(params = "list",method = RequestMethod.GET)
    public String list( Model model) {
    	model.addAttribute("myentitys", myEntityService.findAll());
    	model.addAttribute("entitiesSelected","true");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "myentity/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid MyEntity myEntity, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("myEntity", myEntity);
            return "myentity/update";
        }
        myEntityService.merge(myEntity);
        model.addAttribute("myentity", myEntity);
        model.addAttribute("entitiesSelected","true");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "myentity/show";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("myEntity", myEntityService.find(id));
        model.addAttribute("entitiesSelected","true");
        model.addAttribute("jmsSelected","false");
        model.addAttribute("reportsSelected","false");
        model.addAttribute("droolsSelected","false");
        model.addAttribute("activitiSelected","false");
        return "myentity/update";
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, Model model) {
        myEntityService.remove(myEntityService.find(id));
        return "redirect:/web/myentity?list=";
    }
    
    private String encodeUrlPathSegment(String pathSegment, HttpServletRequest request) {
        String enc = request.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }

}
