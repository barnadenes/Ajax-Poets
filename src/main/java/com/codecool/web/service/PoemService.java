package com.codecool.web.service;

import com.codecool.web.model.Poem;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface PoemService {

    List<Poem> findAllPoemByID(String id) throws SQLException, ServiceException;

    Poem findOneByID(String id) throws SQLException, ServiceException;

}
