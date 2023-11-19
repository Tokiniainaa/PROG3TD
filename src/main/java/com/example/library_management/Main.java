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
//USING THE METHOD FINDALL IN EACH TABLE
            System.out.println(bookCrudOperations.findAll());
            System.out.println(authorCrudeOperations.findAll());
            System.out.println(subscribeCrudeOperations.findAll());
 //USING THE METHOD SAVEALL ON THE TABLE BOOK
            Topic topic = new Topic("COMEDY");
            Topic topic1 = new Topic("ROMANCE");
            Topic topic2 = new Topic("OTHER");
          /* List<book> books = new ArrayList<>();
            books.add(new book(12,"blanche neige",200,topic1,"2022-12-11",3));
            books.add(new book(11,"cendrilon",200,topic2,"2022-12-11",3));
            bookCrudOperations.saveAll(books);*/
  //USING THE METHOD DELETE
           /* authorCrudeOperations.delete(6);
            bookCrudOperations.delete(3);
            subscribeCrudeOperations.delete(3);*/

  //USING THE METHOD SAVE IN EACH TABLE

         /*   subscribe subscribe1 = new subscribe(6,"victor","M");
            subscribeCrudeOperations.save(subscribe1);
            author author1 = new author(14,"marc","M");
            authorCrudeOperations.save(author1);
            book book1= new book(15,"Black panther",300,topic,"2013-11-11",1);
            bookCrudOperations.save(book1);
*/
         //  authorCrudeOperations.save(author);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
