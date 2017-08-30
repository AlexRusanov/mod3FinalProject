package eparliament.service.impl;

import eparliament.dao.SessionDao;
import eparliament.domain.Session;
import eparliament.service.SessionService;
import eparliament.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
@Service
public class SessionServiceImpl implements SessionService {

    private SessionDao sessionDao;

    @Autowired
    public SessionServiceImpl(SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public List<Session> getAll() {
        return sessionDao.getAll();
    }

    @Override
    public Session getById(int sessionId) {
        return sessionDao.getById(sessionId)
                .orElseThrow(() -> new NotFoundException(String.format("Сессия с id=%d не найдена", sessionId)));
    }
}
