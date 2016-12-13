package com.becomejavasenior.DAO;

import java.util.List;

public interface ContactDao<Contact> extends AbstractDao<Contact> {
    List<Contact> getContactsForList(int id);
}