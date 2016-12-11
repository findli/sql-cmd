package com.becomejavasenior.DAO;


import com.becomejavasenior.bean.File;
import com.becomejavasenior.bean.Note;

import java.util.List;

public interface FileDao extends AbstractDao<File>{

    List<File> getFilesForList(int id);


}
