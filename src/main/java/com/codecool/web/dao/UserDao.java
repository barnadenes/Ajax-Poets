package com.codecool.web.dao;

import com.codecool.web.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {

    User findByEmail(String email) throws SQLException;

    User fetchUser(ResultSet resultSet) throws SQLException;
}
