package com.example.library_management;

import com.example.library_management.model.Topic;
import com.example.library_management.model.author;
import com.example.library_management.model.book;
import com.example.library_management.model.subscribe;
import com.example.library_management.repository.dao.AuthorCrudeOperations;
import com.example.library_management.repository.dao.BookCrudOperations;
import com.example.library_management.repository.dao.SubscribeCrudeOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String Url = System.getenv("Url");
        String  User = System.getenv("User");
        String Password = System.getenv("Password");
        try {
            Connection connection1= DriverManager.getConnection(Url, User, Password);
            System.out.println("connexion reussie");
            AuthorCrudeOperations authorCrudeOperations = new AuthorCrudeOperations(connection1);

            SubscribeCrudeOperations subscribeCrudeOperations = new SubscribeCrudeOperations(connection1);

            BookCrudOperations bookCrudOperations = new BookCrudOperations(connection1);

            System.out.println(bookCrudOperations.findAll());
            System.out.println(authorCrudeOperations.findAll());
            System.out.println(subscribeCrudeOperations.findAll());

           List<book> books = new ArrayList<>();
           books.add(new book(10,"noir",200,new Topic("OTHER"),"2022-12-11",2));
            books.add(new book(11,"blanc",200,new Topic("COMEDY"),"2022-12-11",1));
            books.add(new book(12,"jaune",200,new Topic("ROMANCE"),"2022-12-11",3));
            bookCrudOperations.saveAll(books);
            authorCrudeOperations.delete(6);
            bookCrudOperations.delete(3);
            subscribeCrudeOperations.delete(3);
            subscribe subscribe = new subscribe(4,"victor","M");
           author author = new author(10,"marc","M");
         //  authorCrudeOperations.save(author);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
