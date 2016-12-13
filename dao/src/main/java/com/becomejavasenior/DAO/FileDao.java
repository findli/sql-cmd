package com.becomejavasenior.DAO;

import java.util.List;

public interface FileDao<File> extends AbstractDao<File>{

    List<File> getFilesForList(int id);


}

