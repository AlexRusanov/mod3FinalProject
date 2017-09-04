package eparliament.service.impl;

import eparliament.dao.BillDao;
import eparliament.domain.Bill;
import eparliament.service.BillService;
import eparliament.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
@Service
public class BillServiceImpl implements BillService {

    private BillDao billDao;

    @Autowired
    public BillServiceImpl(BillDao billDao) {
        this.billDao = billDao;
    }

    @Override
    public int getCount() {
        return billDao.getCount();
    }

    @Override
    public Bill getById(int billId) {
        return billDao.getById(billId).
                orElseThrow(() -> new NotFoundException(String.format("Законопроект с id=%d не найден", billId)));
    }

    @Override
    public List<Bill> getBySession(int sessionId, int offset, int limit) {
        return billDao.getBySession(sessionId, offset, limit);
    }

    @Override
    public List<Bill> getByDeputy(int deputyId) {
        return null;
    }

    @Override
    public Bill create(Bill bill) {
        return null;
    }

    @Override
    public void update(Bill bill) {

    }

    @Override
    public void delete(Integer billId) {

    }
}
