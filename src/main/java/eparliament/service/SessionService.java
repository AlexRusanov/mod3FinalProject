package eparliament.service;

import eparliament.domain.Session;

import java.util.List;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
public interface SessionService {

    List<Session> getAll();

    Session getById(int sessionId);
}
