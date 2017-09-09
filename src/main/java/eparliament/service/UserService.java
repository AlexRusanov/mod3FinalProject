package eparliament.service;

import eparliament.domain.User;

import java.util.Optional;

/**
 * Created by alexandrrusanov on 4/9/17.
 */
public interface UserService {

    User registerNewUser(User user);

    Optional<User> getAuthenticatedUser();
}
