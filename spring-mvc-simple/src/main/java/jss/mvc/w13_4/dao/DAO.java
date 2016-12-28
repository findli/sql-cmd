package jss.mvc.w13_4.dao;

public interface DAO<T> {
    T get(long id);

    List<T> getAll();

    void save(T trans); // create new entity instance in DB and assign its ID

    void update(T detached); // update existing entity instance in DB given detached instance with id field

    void delete(long id);
}
