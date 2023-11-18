package com.example.library_management.repository.dao;


import com.example.library_management.model.subscribe;
import com.example.library_management.repository.interfacee.CrudOperations;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public class SubscribeCrudeOperations implements CrudOperations <subscribe> {
    public List<subscribe> ListOfSubscribe;
    @Override
    public List<subscribe> findAll() throws SQLException {
        return ListOfSubscribe;
    }

    @Override
    public List<subscribe> saveAll(List<subscribe> toSave) {
        ListOfSubscribe.addAll(toSave);
        return ListOfSubscribe;
    }

    @Override
    public subscribe save(subscribe toSave) {
        ListOfSubscribe.add(toSave);
        return toSave;
    }

    @Override
    public subscribe delete(subscribe toDelete) {
      ListOfSubscribe.remove(toDelete);
      return toDelete;
    }
}
