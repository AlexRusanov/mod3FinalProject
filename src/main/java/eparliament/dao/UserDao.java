package eparliament.dao;

import eparliament.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 4/9/17.
 */
public interface UserDao {

    User save(User user);

    List<User> getAll();

    Optional<User> getById(int userId);

    Optional<User> getByEmail(String email);
}
