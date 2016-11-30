package com.becomejavasenior.service;

import com.becomejavasenior.DAO.DAOException;

import java.util.List;

public interface DealService {
    List getAll() throws DAOException, ClassNotFoundException;
}
