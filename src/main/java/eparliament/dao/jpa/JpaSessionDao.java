package eparliament.dao.jpa;

import eparliament.dao.SessionDao;
import eparliament.domain.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 29/8/17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaSessionDao implements SessionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Session> getAll() {
        return entityManager.createQuery("SELECT s FROM Session s", Session.class)
                .getResultList();
    }

    @Override
    public Optional<Session> getById(int sessionId) {
        Session session = entityManager.find(Session.class, sessionId);
        return Optional.ofNullable(session);
    }
}
