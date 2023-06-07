package petopia_todo_ult.services;

import petopia_todo_ult.models.User;

import java.util.Optional;

public interface UserService {
    Boolean isUserExists(String email);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    User registerUser(User userDto);

    User saveUserData(User userDto);
}
