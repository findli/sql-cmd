package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Language;

import java.util.List;

public interface LanguageService {
    Language create(Language language) throws DaoException;
    void update(Language language) throws DaoException;
    List<Language> getAll() throws DaoException, ClassNotFoundException;
    Language getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
}
