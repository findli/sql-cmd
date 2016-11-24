package com.becomejavasenior.DAO;

import java.util.List;

public interface DealDAO<Deal> extends AbstractDAO<Deal> {

    List<Deal> getDealsForList();
}
