package com.becomejavasenior.DAO;

import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.Stage;

import java.util.List;

public interface DealDao<Deal> extends AbstractDao<Deal> {

    List<Deal> getDealsForList();
    List<Contact> getContactsByDealName(String dealName);
    public List<Stage> getAllStage();
    public List<Deal> getDealsByStage(String stage);
}
