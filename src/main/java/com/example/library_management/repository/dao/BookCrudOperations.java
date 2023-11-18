package com.example.library_management.repository.dao;

import com.example.library_management.repository.interfacee.CrudOperations;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {
    public List<Book> ListOfBook;
    @Override
    public List<Book> findAll() throws SQLException {
        return ListOfBook;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        ListOfBook.addAll(toSave);
        return ListOfBook;
    }

    @Override
    public Book save(Book toSave) {
        ListOfBook.add(toSave);
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        ListOfBook.remove(toDelete);
        return toDelete;
    }
}
