package com.becomejavasenior.DAO;

import com.becomejavasenior.bean.Stage;
import java.util.List;

public interface DealDAO<Deal> extends AbstractDAO<Deal> {
    List<Stage> getAllStage();
    List<Deal> getDealsForList();

}
