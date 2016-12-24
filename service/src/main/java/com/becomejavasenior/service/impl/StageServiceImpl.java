package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.StageDaoImpl;
import com.becomejavasenior.DAO.StageDao;
import com.becomejavasenior.bean.Stage;
import com.becomejavasenior.service.StageService;

import java.util.List;

public class StageServiceImpl implements StageService {

    private StageDao<Stage> stageDAO = new StageDaoImpl();

    @Override
    public Stage create(Stage stage) throws DaoException {
        return stageDAO.create(stage);
    }

    @Override
    public void delete(int id) throws DaoException {
        stageDAO.delete(id);

    }

    @Override
    public Stage getByName(String str) throws DaoException, ClassNotFoundException {
        return stageDAO.getByName(str);
    }

    @Override
    public List<Stage> getAll() throws DaoException, ClassNotFoundException {
        return stageDAO.getAll();
    }

    @Override
    public Stage getById(int id) throws DaoException {
        return stageDAO.getById(id);
    }

    @Override
    public void update(Stage stage) throws DaoException {
        stageDAO.update(stage);
    }
}
