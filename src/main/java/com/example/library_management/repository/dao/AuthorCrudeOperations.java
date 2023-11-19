package com.example.library_management.repository.dao;

import com.example.library_management.connection.dataBaseConnection;
import com.example.library_management.model.author;
import com.example.library_management.repository.interfacee.CrudOperations;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

@Repository
public class AuthorCrudeOperations implements CrudOperations <author> {
    private Connection connection;

    public AuthorCrudeOperations (Connection connection){
        this.connection = connection;
    }

    @Override
    public List<author> findAll() throws SQLException {
        List<author> allAuthor = new ArrayList<>();
        String sql= " Select *from author";
        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(allAuthor, result);
            }
        }
        return allAuthor;
    }

    @Override
    public List<author> saveAll(List<author> toSave) {
        String sql = "INSERT INTO author (id_author, name, sex) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (author author : toSave) {
                statement.setInt(1, author.getId_author());
                statement.setString(2, author.getName());
                statement.setString(3, author.getSex());

                // Exécuter l'instruction pour chaque auteur
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error saving authors", ex);
        }

        return toSave;
    }


    @Override
    public author save(author toSave) {
        String sql = "INSERT INTO author (id_author, name, sex) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, toSave.getId_author());
            statement.setString(2, toSave.getName());
            statement.setString(3, toSave.getSex());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error saving author", ex);
        }

        return toSave;
    }

    @Override
    public  void delete(int id_author) {
        String sql = "DELETE FROM author WHERE id_author = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id_author);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting author", ex);
        }
    }

    private void convertToList(List<author> allAuthor, ResultSet result) throws SQLException {
        allAuthor.add(new author(
                result.getInt("id_author"),
                result.getString("name"),
                result.getString("Sex")


        ));
    }








}
