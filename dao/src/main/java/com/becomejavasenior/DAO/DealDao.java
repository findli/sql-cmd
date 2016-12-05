package com.becomejavasenior.DAO;

import java.util.List;

public interface DealDao<Deal> extends AbstractDao<Deal> {

    List<Deal> getDealsForList(int id);
    List<Deal> getDealsForList();
}
