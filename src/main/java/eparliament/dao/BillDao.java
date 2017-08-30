package eparliament.dao;

import eparliament.domain.Bill;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
public interface BillDao {

    int getCount();

    List<Bill> getBySession(int sessionId, int offset, int limit);

    List<Bill> getByDeputy(int deputyId);

    Bill save(Bill bill);

    boolean delete(int billId);
}
