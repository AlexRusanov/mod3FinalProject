package eparliament.dao.jpa;

import eparliament.dao.BillDao;
import eparliament.domain.Bill;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaBillDao implements BillDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int getCount() {
        TypedQuery<Long> query = this.entityManager.createQuery("SELECT COUNT(b) FROM Bill b", Long.class);

        return query.getSingleResult().intValue();
    }

    @Override
    public Optional<Bill> getById(int billId) {
        Bill bill = entityManager.find(Bill.class, billId);
        return Optional.ofNullable(bill);
    }

    @Override
    public List<Bill> getBySession(int sessionId, int offset, int limit) {
        TypedQuery<Bill> query = this.entityManager.createQuery("SELECT b FROM Bill b WHERE b.session.id = :session_id", Bill.class)
                .setParameter("session_id", sessionId);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<Bill> getAllByUser(int userId) {
        return entityManager.createQuery("SELECT b FROM Bill b WHERE b.user.id = :userId", Bill.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    @Transactional
    public Bill save(Bill bill) {
        if (bill.getId() == null) {
            entityManager.persist(bill);
            return bill;
        } else {
            return entityManager.merge(bill);
        }
    }

    @Override
    @Transactional
    public boolean delete(int billId) {
        Query query = entityManager.createQuery("DELETE FROM Bill b WHERE b.id = :bill_id");
        query.setParameter("bill_id", billId);

        return query.executeUpdate() != 0;
    }
}
