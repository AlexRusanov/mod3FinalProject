package eparliament.dao.jpa;

import eparliament.dao.DeputyDao;
import eparliament.domain.Deputy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
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
    public List<Deputy> getAllSortedBySurname(String surname, boolean desc) {
        TypedQuery<Deputy> query = this.entityManager.createQuery("SELECT d FROM Deputy d " +
                "WHERE d.surname LIKE :surname " +
                "ORDER BY d.surname " + (desc ? "DESC " : "ASC "), Deputy.class);

        query.setParameter("surname", StringUtils.isEmpty(surname) ? "%" : "%" + surname + "%");

        return query.getResultList();
    }

    @Override
    public Optional<Deputy> getById(int deputyId) {
        return null;
    }

    @Override
    @Transactional
    public Deputy save(Deputy deputy) {
        return null;
    }

    @Override
    @Transactional
    public boolean delete(int deputyId) {
        return false;
    }
}
