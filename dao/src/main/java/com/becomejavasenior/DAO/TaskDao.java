package com.becomejavasenior.DAO;


import java.util.List;

public interface TaskDao<Task> extends AbstractDao<Task> {
    List<Task> getTasksForList(int id);
}