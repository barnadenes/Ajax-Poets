package com.codecool.web.service.simple;

import com.codecool.web.dao.PoemDao;
import com.codecool.web.model.Poem;
import com.codecool.web.service.PoemService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimplePoemService implements PoemService {
    private final PoemDao poemDao;

    public SimplePoemService(PoemDao poemDao) {
        this.poemDao = poemDao;
    }

    @Override
    public List<Poem> findAllPoemByID(String id) throws SQLException, ServiceException {
        try {
            return poemDao.findAllPoem(Integer.parseInt(id));
        }  catch (NumberFormatException e) {
            throw new ServiceException("Must be an Integer");
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Poem findOneByID(String id) throws SQLException, ServiceException {
        try {
            return poemDao.findPoemById(Integer.parseInt(id));
        }  catch (NumberFormatException e) {
            throw new ServiceException("Must be an Integer");
        } catch (IllegalArgumentException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
