package com.codecool.web.dao;

import com.codecool.web.model.Poem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PoemDao {

    List<Poem> findAllPoem(int userID) throws SQLException;

    Poem findPoemById(int poemID) throws SQLException;

    Poem fetchPoem(ResultSet resultSet) throws SQLException;

}
