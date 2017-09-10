package eparliament.service;

import eparliament.domain.Bill;
import eparliament.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
public interface BillService {

    int getCount();

    Bill getById(int billId);

    List<Bill> getBySession(int sessionId, int offset, int limit);

    List<Bill> getAllByAuthUser();

    Bill create(Bill bill, User user);

    void update(Bill bill);

    void delete(Integer billId);
}
