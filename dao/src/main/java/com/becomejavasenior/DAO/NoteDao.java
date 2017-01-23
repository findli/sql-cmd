package com.becomejavasenior.DAO;

import java.util.List;

public interface NoteDao<Note> extends AbstractDao<Note> {

    List<Note> getNotesForList(int id);
}
