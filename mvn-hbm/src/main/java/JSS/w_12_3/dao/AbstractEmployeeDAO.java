package JSS.w_12_3.dao;

import JSS.w_12_2.orm.personnel.Employee;

public interface AbstractEmployeeDAO {
    Employee getById(long id);
}
