package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.LanguageDaoImpl;
import com.becomejavasenior.DAO.LanguageDao;
import com.becomejavasenior.bean.Language;
import com.becomejavasenior.service.LanguageService;

import java.util.List;

public class LanguageServiceImpl implements LanguageService{

    LanguageDao<Language> languageDao = new LanguageDaoImpl();

    @Override
    public Language create(Language language) throws DaoException {
        return languageDao.create(language);
    }

    @Override
    public void delete(int id) throws DaoException {
        languageDao.delete(id);
    }

    @Override
    public List<Language> getAll() throws DaoException, ClassNotFoundException {
        return languageDao.getAll();
    }

    @Override
    public Language getById(int id) throws DaoException {
        return languageDao.getById(id);
    }

    @Override
    public void update(Language language) throws DaoException {
        languageDao.update(language);
    }
}
