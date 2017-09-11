package eparliament.service.impl;

import eparliament.dao.DeputyDao;
import eparliament.domain.Deputy;
import eparliament.dto.DeputySort;
import eparliament.service.DeputyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Deputy> getAll(String surname, DeputySort deputySort) {
        List<Deputy> result = new ArrayList<>();
        switch (deputySort) {
            case SURNAME_ASC:
            case SURNAME_DESC:
                result = this.deputyDao.getAllSortedBySurname(surname, deputySort == DeputySort.SURNAME_DESC);
                break;
        }
        return result;
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
