package by.bsuir.semenchik.logic.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T get(String name);

    List<T> getAll();

    void save(T t);

    void update();

    void delete(T t);
}
