package com.becomejavasenior.DAO;

import java.util.List;

public interface ContactDAO<Contact> extends AbstractDAO<Contact> {

    List<Contact> getContactsForList();
}
