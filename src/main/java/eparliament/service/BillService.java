package eparliament.service;

import eparliament.domain.Bill;

import java.util.List;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
public interface BillService {

    int getCount();

    List<Bill> getBySession(int sessionId, int offset, int limit);

    List<Bill> getByDeputy(int deputyId);

    Bill create(Bill bill);

    void update(Bill bill);

    void delete(Integer billId);
}
