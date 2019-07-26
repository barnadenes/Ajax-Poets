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
        String sql = "select * from poem\n" +
            "where poem.user_id = ?;";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            statement.setInt(1, userID);
            while(resultSet.next()) {
                Poems.add(fetchPoem(resultSet));
            }
        }
        return Poems;
    }

    @Override
    public Poem findPoemById(int poemID) throws SQLException {
        String sql = "select * from poem\n" +
            "where poem.poem_id = 1;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, poemID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return fetchPoem(resultSet);
            }
        }
        return null;
    }

    @Override
    public Poem fetchPoem(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("user_id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        Date date = resultSet.getDate("date");
        return new Poem(id, title, content, date);
    }
}
