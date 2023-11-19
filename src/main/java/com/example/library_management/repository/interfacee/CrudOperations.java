package com.example.library_management.repository.interfacee;

import java.sql.SQLException;
import java.util.List;

public interface CrudOperations<T> {
     List<T> findAll() throws SQLException;
     List<T> saveAll(List<T> toSave)throws SQLException;
     T save(T toSave)throws SQLException;
     void delete(int id)throws SQLException;
}
