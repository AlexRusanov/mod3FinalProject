package eparliament.service.impl;

import eparliament.dao.SessionDao;
import eparliament.domain.Session;
import eparliament.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
@Service
public class SessionServiseImpl implements SessionService {

    private SessionDao sessionDao;

    @Autowired
    public SessionServiseImpl(SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public List<Session> getAll() {
        return sessionDao.getAll();
    }

    @Override
    public Session getById(int sessionId) {
        return null;
    }
}
