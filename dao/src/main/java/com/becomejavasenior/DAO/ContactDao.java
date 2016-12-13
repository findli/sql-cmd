package com.becomejavasenior.DAO;

import com.becomejavasenior.bean.Contact;

import java.util.List;

public interface ContactDao<Contact> extends AbstractDao<Contact> {
    List<Contact> getContactsForList(int contactId);
}
