package eparliament.dao.jpa;

import eparliament.dao.VotingDao;
import eparliament.domain.Voting;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexandrrusanov on 31/8/17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaVotingDao implements VotingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Voting> getByBill(int billId) {
        return entityManager.createQuery("SELECT v FROM Voting v WHERE v.bill.id = :bill_id", Voting.class)
                .setParameter("bill_id", billId)
                .getResultList();
    }

    @Override
    @Transactional
    public Voting save(Voting voting) {
        if (voting.getId() == null) {
            entityManager.persist(voting);
            return voting;
        } else {
            return entityManager.merge(voting);
        }
    }
}
