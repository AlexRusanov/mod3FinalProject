package eparliament.dao.jpa;

import eparliament.dao.BillDao;
import eparliament.domain.Bill;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

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
    public List<Bill> getBySession(int sessionId, int offset, int limit) {
        TypedQuery<Bill> query = this.entityManager.createQuery("SELECT b FROM Bill b WHERE b.session.id = :session_id", Bill.class)
                .setParameter("session_id", sessionId);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<Bill> getByDeputy(int deputyId) {
        return null;
    }

    @Override
    public Bill save(Bill bill) {
        return null;
    }

    @Override
    public boolean delete(int billId) {
        return false;
    }
}
