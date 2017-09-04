package eparliament.service;

import eparliament.domain.Voting;

import java.util.List;

/**
 * Created by alexandrrusanov on 31/8/17.
 */
public interface VotingService {

    List<Voting> getByBill(int billId);

    void createNew(Voting voting);
}
