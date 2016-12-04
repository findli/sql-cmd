package com.becomejavasenior.DAO;


import com.becomejavasenior.bean.File;

import java.util.List;

public interface FileDao {

    List<File> getFilesForList(int id);

}
