package com.example.library_management.repository.dao;


import com.example.library_management.model.Topic;

import com.example.library_management.model.book;
import com.example.library_management.repository.interfacee.CrudOperations;

import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookCrudOperations implements CrudOperations <book> {
    private Connection connection;

    public BookCrudOperations (Connection connection){
        this.connection = connection;
    }

    @Override
    public List<book> findAll() throws SQLException {
        List<book> allBooks = new ArrayList<>();
        String sql= " Select * from book";
        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(allBooks, result);
            }
        }
        return allBooks;
    }

    @Override
    public List<book> saveAll(List<book> toSave) {
        String sql = "INSERT INTO book (id_book,book_name,page_number,topic,release_date,id_author) VALUES (?, ?, ?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (book book : toSave) {
                statement.setInt(1, book.getIdBook());
                statement.setString(2,book.getBookName());
                statement.setInt(3, book.getPageNumbers());
                statement.setObject(4, book.getTopic(), java.sql.Types.OTHER);
                statement.setString(5,book.getReleaseDate());
                statement.setInt(6,book.getIdAuthor());

                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error saving book", ex);
        }

        return toSave;
    }


    @Override
    public book save(book toSave) {
        String sql = "INSERT INTO book (id_book,book_name,page_number,topic,release_date,id_author) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, toSave.getIdBook());
                statement.setString(2,toSave.getBookName());
                statement.setInt(3, toSave.getPageNumbers());
                statement.setObject(4, toSave.getTopic().getTopic(),Types.OTHER);
                statement.setString(5,toSave.getReleaseDate());
                statement.setInt(6,toSave.getIdAuthor());

                statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error saving book", ex);
        }

        return toSave;
    }

    @Override
    public void  delete(int id_book) {
        String sql = "DELETE FROM book WHERE id_book = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_book);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting book", ex);
        }
    }

    private void convertToList(List<book> allBooks, ResultSet result) throws SQLException {
        allBooks.add(new book(
                result.getInt("id_book"),
                result.getString("book_name"),
                result.getInt("page_number"),
                new Topic(result.getString("topic")),
                result.getString("release_date"),
                result.getInt("id_author")


        ));
    }








}

