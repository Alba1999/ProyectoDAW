package petopia_todo_ult.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petopia_todo_ult.models.User;
import petopia_todo_ult.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean isUserExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User registerUser(User userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public User saveUserData(User userDto) {
        return userRepository.save(userDto);
    }

//    @Override
//    public User saveUserData(User userDto) {
//        ;
//    }
}
