package eparliament.dao;

import eparliament.domain.Deputy;
import eparliament.domain.Session;

import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
public interface SessionDao {

    List<Session> getAll();

    Optional<Session> getById(int sessionId);
}
