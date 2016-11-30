package net.javajoy.jss.mvc.w13_3.controller;

import net.javajoy.jss.mvc.w13_3.domain.Customer;
import net.javajoy.jss.mvc.w13_3.service.CustomerServiceSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
@RequestMapping(value="/w13_3/customer")
@Scope("singleton")
public class CustomerControllerSimple {

    @Autowired
    private CustomerServiceSimple customerService;

    @PostConstruct
    public void postConstruct() {
        System.out.println( "CustomerController : postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println( "CustomerController : preDestroy");
    }


    @RequestMapping(value="/index.htm", method = RequestMethod.GET)
	public String index(Model model) {
        model.addAttribute("customers",customerService.getAll());
		return "w13_3/customer/index";            // Show index view
	}

    @RequestMapping(value="/create.htm", method = RequestMethod.GET)
    public String create(@ModelAttribute("customerAttribute") Customer customer, Model model) {
        return "w13_3/customer/create";           // Show create form view
    }

    @RequestMapping(value="/update/{id}.htm", method = RequestMethod.GET)
    public String update(
            @PathVariable Long id,
            @ModelAttribute("customerAttribute") Customer customer,
            Model model) {
        Customer c = customerService.get(id);
        if (c!=null) {
            customer.setId(c.getId());
            customer.setName(c.getName());
            customer.setRating(c.getRating());
            model.addAttribute("customerAttribute",customer);
        }
        return "w13_3/customer/update";           // Show update form view
    }

    @RequestMapping(value="/delete/{id}.htm", method = RequestMethod.GET)
    public String delete(
            @PathVariable Long id,
            Model model) {
        customerService.delete(id);
        return "redirect:/w13_3/customer/index.htm";           // Redirect to customers list
    }

    @RequestMapping(value="/save.htm", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("customerAttribute") Customer customer,
            Model model) {
        if (customer.getId() == null) {
            customerService.add(customer);
        } else {
            customerService.update(customer);
        }
        return "redirect:/w13_3/customer/index.htm";           // Redirect to customers list
    }

}
