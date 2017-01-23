package com.becomejavasenior.DAO;

import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.bean.Stage;

import java.util.List;

public interface DealDao<Deal> extends AbstractDao<Deal> {

    List<Deal> getDealsForList(int id);
    List<Deal> getDealsForList();
    List<Contact> getContactsByDealName(String dealName);
    List<Stage> getAllStage();
    List<Deal> getDealsByStage(String stage);
    List<Deal> getDealWithTask();
    List<Deal> getDealWithNotTask();
}
