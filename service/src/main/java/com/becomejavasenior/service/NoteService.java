package com.becomejavasenior.service;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Note;

import java.util.List;

public interface NoteService {

    Note create(Note t) throws DaoException;
    void update(Note t) throws DaoException;
    List<Note> getAll() throws DaoException, ClassNotFoundException;
    Note getById(int id) throws DaoException;
    void delete(int id) throws DaoException;
    List<Note> getNotesForList(int id);
    public void createNewNote() throws DaoException, ClassNotFoundException;
}
