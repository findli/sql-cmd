package com.becomejavasenior.DAO;

<<<<<<< HEAD

import com.becomejavasenior.bean.File;
import com.becomejavasenior.bean.Note;

=======
>>>>>>> develop
import java.util.List;

public interface FileDao<File> extends AbstractDao<File>{

    List<File> getFilesForList(int id);


}

