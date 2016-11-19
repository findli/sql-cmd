package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.DAO.Imp.StageDAOImpl;
import com.becomejavasenior.DAO.StageDAO;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.service.StageService;

import java.util.List;

public class StageServiceImpl implements StageService {

    private StageDAO<Stage> stageDAO = new StageDAOImpl();

    @Override
    public Stage create(Stage stage) throws DAOException {
        return stageDAO.create(stage);
    }

    @Override
    public void delete(int id) throws DAOException {
        stageDAO.delete(id);

    }

    @Override
    public List<Stage> getAll() throws DAOException, ClassNotFoundException {
        return stageDAO.getAll();
    }

    @Override
    public Stage getById(int id) throws DAOException {
        return stageDAO.getById(id);
    }

    @Override
    public void update(Stage stage) throws DAOException {
        stageDAO.update(stage);
    }
}
