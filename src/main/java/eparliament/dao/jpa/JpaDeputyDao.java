package eparliament.dao.jpa;

import eparliament.dao.DeputyDao;
import eparliament.domain.Deputy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 25/8/17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaDeputyDao implements DeputyDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Deputy> getAll() {
        return entityManager.createQuery("SELECT d FROM Deputy d", Deputy.class)
                .getResultList();
    }

    @Override
    public Optional<Deputy> getById(int deputyId) {
        return null;
    }

    @Override
    public Deputy save(Deputy deputy) {
        return null;
    }

    @Override
    public boolean delete(int deputyId) {
        return false;
    }
}
