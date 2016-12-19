package jss.mvc.controller;

import jss.mvc.domain.Customer;
import jss.mvc.service.CustomerService;
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
import java.io.IOException;

@Controller
@RequestMapping(value = "customer")
@Scope("singleton")
public class CustomerController {

    @Autowired
    // по типу найдет jss.mvc.service.CustomerServiceImpl because of @Service
    private CustomerService customerService;

    @PostConstruct
    public void postConstruct() {
        System.out.println("CustomerController : postController");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("CustomerController : postConstruct");
    }

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    /*public ModelAndView test(HttpServletResponse response) throws IOException {
        return new ModelAndView("home");
    }*/
    // тут возвзращается имя представления, в которое отобразать Model
    public String index(Model model) throws IOException {
        model.addAttribute("customers", customerService.getAll());

        return "customer/index";
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public String create(@ModelAttribute("customerAttribute") Customer customer, Model model) {
        return "customer/create"; // show create customer form
    }

    @RequestMapping(value = "/update/{id}.htm", method = RequestMethod.GET)
    public String update(@PathVariable Long id,
                         @ModelAttribute("customerAttribute") Customer customer
            , Model model) {
        Customer c = customerService.get(id);
        if (c != null) {
            customer.setId(c.getId());
            customer.setName(c.getName());
            customer.setRating(c.getRating());
            model.addAttribute("customerAttribute", customer);
        }
        return "customer/update"; // show update customer form
    }

    @RequestMapping(value = "/delete/{id}.htm", method = RequestMethod.GET)
    public String create(
            @PathVariable Long id,
            Model model) {
        customerService.delete(id);
        return "redirect:/customer/index.htm"; // Redirect to customers list
    }

    @RequestMapping(value = "/save.htm", method = RequestMethod.POST)
    public String save(@ModelAttribute("customerAttribute") Customer customer, Model model) {
        if (customer.getId() == null) {
            customerService.add(customer);
        } else {
            customerService.update(customer);
        }
        return "redirect:/customer/index.htm";
    }
}
