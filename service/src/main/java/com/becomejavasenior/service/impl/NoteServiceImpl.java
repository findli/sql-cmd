package com.becomejavasenior.service.impl;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.NoteDaoImpl;
import com.becomejavasenior.DAO.NoteDao;
import com.becomejavasenior.bean.Note;
import com.becomejavasenior.service.NoteService;

import java.util.List;

public class NoteServiceImpl implements NoteService {

    private final NoteDao noteDao = new NoteDaoImpl();

    @Override
    public Note create(Note t) throws DaoException {
        return null;
    }

    @Override
    public void update(Note t) throws DaoException {

    }

    @Override
    public List<Note> getAll() throws DaoException, ClassNotFoundException {
        return null;
    }

    @Override
    public Note getById(int id) throws DaoException {
        return null;
    }

    @Override
    public void delete(int id) throws DaoException {

    }

    @Override
    public List<Note> getNotesForList(int id) {
        return noteDao.getNotesForList(id);
    }

    @Override
    public void createNewNote() throws DaoException, ClassNotFoundException {

    }
}
