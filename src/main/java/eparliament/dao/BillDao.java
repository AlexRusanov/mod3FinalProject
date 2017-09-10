package eparliament.dao;

import eparliament.domain.Bill;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
public interface BillDao {

    int getCount();

    Optional<Bill> getById(int billId);

    List<Bill> getBySession(int sessionId, int offset, int limit);

    List<Bill> getAllByUser(int userId);

    Bill save(Bill bill);

    boolean delete(int billId);
}
