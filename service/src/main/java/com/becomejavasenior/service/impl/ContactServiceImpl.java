package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.*;
import com.becomejavasenior.bean.*;
import com.becomejavasenior.service.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "contactService")
public class ContactServiceImpl implements ContactService {

    public static Logger log = Logger.getLogger(CompanyServiceImpl.class);

    private final ContactDao contactDao;
    private final UserDao userDao;
    private final CompanyDao companyDao;
    private final TaskDao taskDao;
    private final NoteDao noteDao;
    private final StageDao stageDao;

    @Autowired
    public ContactServiceImpl(UserDao userDao, ContactDao contactDao,CompanyDao companyDao,
                              TaskDao taskDao, NoteDao noteDao, StageDao stageDao) {
        this.userDao = userDao;
        this.contactDao = contactDao;
        this.companyDao = companyDao;
        this.taskDao = taskDao;
        this.noteDao = noteDao;
        this.stageDao = stageDao;

    }

    @Override
    public Contact create(Contact contact) throws DaoException {
        return (Contact) contactDao.create(contact);
    }

    @Override
    public void update(Contact contact) throws DaoException {
        contactDao.update(contact);
    }

    @Override
    public List<Contact> getAll() throws DaoException, ClassNotFoundException {
        return contactDao.getAll();
    }

    @Override
    public Contact getById(int id) throws DaoException {
        return (Contact) contactDao.getById(id);
    }

    @Override
    public void delete(int id) throws DaoException {
        contactDao.delete(id);
    }

    @Override
    public List<Contact> getContactsForList(int id) {
        return contactDao.getContactsForList(id);
    }

    @Override
    public void createNewContact(Contact contact, Deal deal, Company company,
                                 Task task, Note note) throws DaoException, ClassNotFoundException {

        if(!task.getDeadlineDate().equals("")) {
            taskDao.create(task);
        }

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        contact.setTasks(tasks);

        List<Company> companies = companyDao.getAll();
        for ( Company comp : companies ) {
            if (company.getTitle() == comp.getTitle()) {
                contact.setCompany(company);
            }
        }
        if (contact.getCompany().equals(null)) {
            contact.setCompany(company);
        }

        Stage stage;
        stage = (Stage) stageDao.getById(1);
        deal.setStage(stage);

        User user = (User) userDao.getByName(contact.getResponsibleUser().getlName());
        contact.setResponsibleUser(user);

        contact = (Contact) contactDao.create(contact);

        if(!note.getNoteText().equals("")) {
            note.setContact(contact);
            noteDao.create(note);
        }
    }

    public User responsibleUserWithId(User user) throws ClassNotFoundException, DaoException {

        List<User> userList = userDao.getAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getlName().equals(user.getlName())){
                user = userList.get(i);
                break;
            }
        }

        return user;
    }

}