package com.example.library_management.repository.dao;

import com.example.library_management.model.author;
import com.example.library_management.repository.interfacee.CrudOperations;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public class AuthorCrudeOperations implements CrudOperations <author> {
    public List<author> ListOfAuthor;
    @Override
    public List<author> findAll() throws SQLException {
        return ListOfAuthor;
    }

    @Override
    public List<author> saveAll(List<author> toSave) {
         ListOfAuthor.addAll(toSave);
         return ListOfAuthor;
    }

    @Override
    public author save(author toSave) {
        ListOfAuthor.add(toSave);
        return toSave;
    }

    @Override
    public author delete(author toDelete) {
       ListOfAuthor.remove(toDelete);
       return toDelete;
    }
}
