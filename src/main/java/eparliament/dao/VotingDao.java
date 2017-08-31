package eparliament.dao;

import eparliament.domain.Voting;

import java.util.List;

/**
 * Created by alexandrrusanov on 31/8/17.
 */
public interface VotingDao {

    List<Voting> getByBill(int billId);

    Voting save(Voting voting);
}
