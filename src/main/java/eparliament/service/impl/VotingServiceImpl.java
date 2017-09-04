package eparliament.service.impl;

import eparliament.dao.VotingDao;
import eparliament.domain.Voting;
import eparliament.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexandrrusanov on 31/8/17.
 */
@Service
public class VotingServiceImpl implements VotingService {

    private VotingDao votingDao;

    @Autowired
    public VotingServiceImpl(VotingDao votingDao) {
        this.votingDao = votingDao;
    }

    @Override
    public List<Voting> getByBill(int billId) {
        return votingDao.getByBill(billId);
    }

    @Override
    public void createNew(Voting voting) {

    }
}
