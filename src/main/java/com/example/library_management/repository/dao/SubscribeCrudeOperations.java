package com.example.library_management.repository.dao;


import com.example.library_management.model.subscribe;
import com.example.library_management.repository.interfacee.CrudOperations;

import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class SubscribeCrudeOperations implements CrudOperations <subscribe> {
    private Connection connection;

    public SubscribeCrudeOperations (Connection connection){
        this.connection = connection;
    }

    @Override
    public List<subscribe> findAll() throws SQLException {
        List<subscribe> allSubscribe = new ArrayList<>();
        String sql= " Select * from subscribes";
        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)) {

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){

                convertToList(allSubscribe, result);
            }
        }
        return allSubscribe;
    }

    @Override
    public List<subscribe> saveAll(List<subscribe> toSave) {
        String sql = "INSERT INTO subscribes (id, name, gender) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (subscribe subscribe : toSave) {
                statement.setInt(1, subscribe.getId());
                statement.setString(2, subscribe.toString());
                statement.setString(3,subscribe.getGender());

                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error saving subscribes", ex);
        }

        return toSave;
    }


    @Override
    public subscribe save(subscribe toSave) {
        String sql = "INSERT INTO subscribes (id, name, gender) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, toSave.getId());
            statement.setString(2, toSave.getName());
            statement.setString(3, toSave.getGender());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error saving subscribe", ex);
        }

        return toSave;
    }

    @Override
    public  void delete(int id_subcribe) {
        String sql = "DELETE FROM subscribes WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_subcribe);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting subscribe", ex);
        }

    }

    private void convertToList(List<subscribe> allSubscribe, ResultSet result) throws SQLException {
        allSubscribe.add(new subscribe(
                result.getInt("id"),
                result.getString("name"),
                result.getString("gender")


        ));
    }








}
