package com.becomejavasenior.service.impl;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.DAO.Imp.NoteDaoImpl;
import com.becomejavasenior.DAO.NoteDao;
import com.becomejavasenior.bean.Note;
import com.becomejavasenior.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service(value = "noteService")
public class NoteServiceImpl implements NoteService {

    private final NoteDao noteDao;

    @Autowired
    public NoteServiceImpl(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

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
        noteDao.delete(id);
    }

    @Override
    public List<Note> getNotesForList(int id) {
        return noteDao.getNotesForList(id);
    }

    @Override
    public void createNewNote() throws DaoException, ClassNotFoundException {

    }
}
