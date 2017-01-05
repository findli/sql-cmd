package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Address;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyDetail {

    private DealService dealService;
    private ContactService contactService;
    private CompanyService companyService;
    private TaskService taskService;
    private FileService fileService;
    private NoteService noteService;
    private AddressService addressService;
    private Address address = new Address();
    private Company company = new Company();

    @RequestMapping(value = "/companyDetail", method = RequestMethod.GET)
    public ModelAndView getDetailCompany(@RequestParam("idCompany") int idCompany) throws ClassNotFoundException, DaoException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("company", companyService.getById(idCompany));
        modelAndView.addObject("contactList", contactService.getContactsForList(idCompany));
        modelAndView.addObject("dealList", dealService.getDealsForList(idCompany));
        modelAndView.addObject("taskList", taskService.getTasksForList(idCompany));
        modelAndView.addObject("fileList", fileService.getFilesForList(idCompany));
        modelAndView.addObject("noteList", noteService.getNotesForList(idCompany));
        modelAndView.setViewName("/pages/companyDetail");
        return modelAndView;
    }


    @RequestMapping(value = "/createUpdateCompany", method = RequestMethod.POST)
    public
    @ResponseBody
    void createUpdateCompany(@RequestBody Company jsonString) throws DaoException, ClassNotFoundException {
        if (jsonString.getTitle().isEmpty()){
            company.setTitle(null);
        }else {
            company.setTitle(jsonString.getTitle());
        }
        company.setPhoneNumber(jsonString.getPhoneNumber());
        company.setWebsite(jsonString.getWebsite());
        company.setEmail(jsonString.getEmail());
        address.setId(jsonString.getAddress().getId());
        address.setZipcode(jsonString.getAddress().getZipcode());
        address.setCountry(jsonString.getAddress().getCountry());
        address.setCity(jsonString.getAddress().getCity());
        address.setStreet(jsonString.getAddress().getStreet());
        address.setBuildNum(jsonString.getAddress().getBuildNum());
        address.setOfficeRoom(jsonString.getAddress().getOfficeRoom());
        company.setAddress(address);
        company.setId(jsonString.getId());
        company.setDeleted(false);
        User user = new User();
        /**
         * Новая компания приходит с id = 0
         */
        if (jsonString.getId() == 0) {
            /**
             * Id юзера взять из сессии
             */
            user.setId(1);
            company.setResponsibleUser(user);
            createCompanyAddress();
        } else {
            user.setId(jsonString.getResponsibleUser().getId());
            company.setResponsibleUser(user);
            updateCompanyAddress();
            getDetailCompany(jsonString.getId());
        }
    }

    @RequestMapping(value = "/createUpdateAddress", method = RequestMethod.POST)
    public
    @ResponseBody
    Address createUpdateAddress(@RequestBody Address jsonString) throws DaoException, ClassNotFoundException {
        address.setId(jsonString.getId());
        address.setZipcode(jsonString.getZipcode());
        address.setCountry(jsonString.getCountry());
        address.setCity(jsonString.getCity());
        address.setStreet(jsonString.getStreet());
        address.setBuildNum(jsonString.getBuildNum());
        address.setOfficeRoom(jsonString.getOfficeRoom());
        return address;
    }

    private void updateCompanyAddress() {
        try {
            addressService.update(address);
            companyService.update(company);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void createCompanyAddress() {
        try {
            address.setId(addressService.create(address).getId());
            company.setAddress(address);
            companyService.create(company);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/delTask", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    void deleteTask(@RequestBody String action) throws DaoException {
        String id = action.replace("\"", "").substring(12);
        taskService.delete(Integer.parseInt(id));
    }

    @RequestMapping(value = "/delNote", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    void deleteNote(@RequestBody String action) throws DaoException {
        String id = action.replace("\"", "").substring(12);
        noteService.delete(Integer.parseInt(id));
    }

    @Autowired
    public void setDealService(DealService dealService) {
        this.dealService = dealService;
    }

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
}
