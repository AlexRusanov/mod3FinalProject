package eparliament.service.impl;

import eparliament.dao.DeputyDao;
import eparliament.domain.Deputy;
import eparliament.service.DeputyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexandrrusanov on 26/8/17.
 */
@Service
public class DeputyServiceImpl implements DeputyService {

    private DeputyDao deputyDao;

    @Autowired
    public DeputyServiceImpl(DeputyDao deputyDao) {
        this.deputyDao = deputyDao;
    }

    @Override
    public List<Deputy> getAll() {
        return deputyDao.getAll();
    }

    @Override
    public Deputy getById(int deputyId) {
        return null;
    }

    @Override
    public Deputy create(Deputy deputy) {
        return null;
    }

    @Override
    public void update(Deputy deputy) {

    }

    @Override
    public void delete(Integer deputyId) {

    }
}
