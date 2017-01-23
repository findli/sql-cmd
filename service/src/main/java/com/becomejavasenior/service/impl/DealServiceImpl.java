package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.DAO.StageDao;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "dealService")
public class DealServiceImpl implements DealService {

    private final CompanyDao companyDao;
    private final ContactDao contactDao;
    private final TaskDao taskDao;
    private final DealDao dealDao;
    private final StageDao stageDao;
    private final AddressDao addressDao;
    private final UserDao userDao;
    private final NoteDao noteDao;

    @Autowired
    public DealServiceImpl(CompanyDao companyDao,
                           UserDao userDao,
                           ContactDao contactDao,
                           TaskDao taskDao,
                           DealDao dealDao,
                           StageDao stageDao,
                           AddressDao addressDao,
                           NoteDao noteDao) {
        this.companyDao = companyDao;
        this.userDao = userDao;
        this.contactDao = contactDao;
        this.taskDao = taskDao;
        this.dealDao = dealDao;
        this.stageDao = stageDao;
        this.addressDao = addressDao;
        this.noteDao = noteDao;
    }

    public Deal create (Deal deal) throws DaoException {
        return (Deal) dealDao.create(deal);
    }

    public Deal update(Deal deal) throws DaoException {
        return (Deal) dealDao.update(deal);
    }

    public Deal getById(int id) throws DaoException {
        return (Deal)dealDao.getById(id);
    }

    public void delete(int id) throws DaoException {
        dealDao.delete(id);
    }

    @Override
    public List<Deal> getDealsForList(int id) {
        return dealDao.getDealsForList();
    }

    public List<Deal> getAll() throws DaoException, ClassNotFoundException {
        return dealDao.getAll();
    }

    @Override
    public List<Stage> getAllStage() {
        return dealDao.getAllStage();
    }

    @Override
    public List<Contact> getContactsByDealName(String dealName) {
        return dealDao.getContactsByDealName(dealName);
    }

    @Override
    public List<Deal> getDealsForList() {
        return dealDao.getDealsForList();
    }

    @Override
    public void createNewDeal(Deal deal, Contact contact, Task task, Company company, Note note) throws DaoException, ClassNotFoundException {

        if(!task.getTitle().equals("")) {
            taskDao.create(task);
        }

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        deal.setTasks(tasks);
        contact = contactWithId(contact);
        deal.setPrimaryContact(contact);

        company = (Company) companyDao.getByName(company.getTitle());
        deal.setCompany(company);

        Stage stage;
        stage = (Stage) stageDao.getById(1);
        deal.setStage(stage);

        User user = (User) userDao.getByName(deal.getResponsibleUser().getlName());
        deal.setResponsibleUser(user);

        deal = (Deal) dealDao.create(deal);

        if(!note.getNoteText().equals("")) {
//            deal = (Deal) dealDao.getByName(note.getDeal().getTitle());
            note.setDeal(deal);
            noteDao.create(note);
        }

    }

    @Override
    public List<Deal> getAllDealsByStage(String stage) {
        return dealDao.getDealsByStage(stage);
    }

    // Необходимо править !!!
    public Contact contactWithId(Contact contact) throws ClassNotFoundException, DaoException {
//        List<Contact> contacts = contactDao.getAll();
//        for(int i = 0; i < contacts.size(); i++) {
//            if(contacts.get(i).getlName().equals(contact.getlName())) {
//                contact = contacts.get(i);
//                break;
//            }
//        }
        contact = (Contact) contactDao.getById(1);
        return contact;
    }

    // Возвращает ArrayList где '0' элемент это весь бюджет по сделкам
    //                          '1' элемент это количество сделот со статусом "готово"
    //                          '2' элемент это количество сделок со статусом "закрыто и не реализовано"
    //                          '3' всего сделок
    public List getDealsForDashboard() throws DaoException, ClassNotFoundException{
        int budget = 0;
        int doneDeals = 0;
        int closeDeals = 0;
        List returnList = new ArrayList<>();
        List<Deal> dealList = dealDao.getAll();
        for (int i = 0; i < dealList.size(); i++) {
            budget = budget + dealList.get(i).getBudget();
            if(dealList.get(i).getStage().getTitle().equals("done")){
                doneDeals++;
            }
            if(dealList.get(i).getStage().getTitle().equals("close is not realized")){
                closeDeals++;
            }
        }
        returnList.add(budget);
        returnList.add(doneDeals);
        returnList.add(closeDeals);
        returnList.add(dealList.size());
        return returnList;
    }

    public List<Deal> getListDealWithTask() throws DaoException, ClassNotFoundException{
        List<Deal> dealList = new ArrayList<>();
        dealList = dealDao.getDealWithTask();
        return dealList;
    }

    public List<Deal> getListDealWithNotTask() throws DaoException, ClassNotFoundException{
        List<Deal> dealList = new ArrayList<>();
        dealList = dealDao.getDealWithNotTask();
        return dealList;
    }




//    public Company companyWithId(Company company) throws ClassNotFoundException, DaoException {
//
//        List<Company> companies = companyDao.getAll();
//        for(int i = 0; i < companies.size(); i++) {
//            if(companies.get(i).getTitle().equals(company.getTitle())) {
//                company = companies.get(i);
//                break;
//            }
//        }
//        return company;
//    }
}