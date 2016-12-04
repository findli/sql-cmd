package com.becomejavasenior.DAO;

import com.becomejavasenior.bean.Contact;

import java.util.List;

public interface DealDao<Deal> extends AbstractDao<Deal> {

    List<Deal> getDealsForList();
    List<Contact> getContactsByDealName(String dealName);
}
