package com.codecool.web.dao.database;

import com.codecool.web.dao.PoemDao;
import com.codecool.web.model.Poem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabasePoemDao extends AbstractDao implements PoemDao {

    public DatabasePoemDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Poem> findAllPoem(int userID) throws SQLException {
        List<Poem> Poems = new ArrayList<>();
        String sql = "select user_id, poem_id, content, title, date from poem " +
            "where poem.user_id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Poems.add(fetchPoem(resultSet));
            }
        }
        return Poems;
    }

    @Override
    public Poem findPoemById(int poemID) throws SQLException {
        String sql = "select poem_id, title, content, date from poem " +
        "where poem_id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, poemID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Poem poem = new Poem(resultSet.getInt("poem_id"),
                                     resultSet.getString("content"),
                                     resultSet.getString("title"),
                                     resultSet.getString("date"));
                return poem;
            }
        }
        return null;
    }

    @Override
    public Poem fetchPoem(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("user_id");
        int poem_id = resultSet.getInt("poem_id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        String date = resultSet.getString("date");
        return new Poem(poem_id, content, title, date);
    }
}
