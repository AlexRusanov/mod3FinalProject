package eparliament.dao;

import eparliament.domain.Deputy;

import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 25/8/17.
 */
public interface DeputyDao {

    List<Deputy> getAll();

    List<Deputy> getAllSortedBySurname(String surname, boolean desc);

    Optional<Deputy> getById(int deputyId);

    Deputy save(Deputy deputy);

    boolean delete(int deputyId);
}
