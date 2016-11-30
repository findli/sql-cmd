package net.javajoy.jss.w_12_3.dao;

import net.javajoy.jss.w_12_2.orm.personnel.Employee;

/**
 * @author Cyril Kadomsky
 */
public interface AbstractEmployeeDAO {

    Employee getById(long id);

    // ...
}
