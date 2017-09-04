package eparliament.service;

import eparliament.domain.Deputy;

import java.util.List;

/**
 * Created by alexandrrusanov on 26/8/17.
 */
public interface DeputyService {

    List<Deputy> getAll();

    Deputy getById(int deputyId);

    Deputy create(Deputy deputy);

    void update(Deputy deputy);

    void delete(Integer deputyId);
}
