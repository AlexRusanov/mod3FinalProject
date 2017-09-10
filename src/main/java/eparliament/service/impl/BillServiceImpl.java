package eparliament.service.impl;

import eparliament.dao.BillDao;
import eparliament.domain.Bill;
import eparliament.domain.User;
import eparliament.service.BillService;
import eparliament.service.UserService;
import eparliament.util.exception.AccessDeniedException;
import eparliament.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by alexandrrusanov on 30/8/17.
 */
@Service
public class BillServiceImpl implements BillService {

    private BillDao billDao;
    private UserService userService;


    @Autowired
    public BillServiceImpl(BillDao billDao, UserService userService) {
        this.billDao = billDao;
        this.userService = userService;
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
    public List<Bill> getAllByAuthUser() {
        User authUser = userService.getAuthenticatedUser()
                .orElseThrow(() -> new AccessDeniedException("User are not authorized"));

        return billDao.getAllByUser(authUser.getId());
    }

    @Override
    public Bill create(Bill bill, User user) {
        bill.setSubmissionDate(LocalDateTime.now());
        bill.setSession(null);
        bill.setUser(user);
        return billDao.save(bill);
    }

    @Override
    public void update(Bill bill) {
        billDao.save(bill);
    }

    @Override
    public void delete(Integer billId) {
        billDao.delete(billId);
    }
}
