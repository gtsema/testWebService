package ru.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.User;
import ru.example.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceDbImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int create(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Optional<User> read(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean update(User user, int id) {
        return userRepository.findById(id).map(obj -> {
                                                        user.setId(id);
                                                        userRepository.save(user);
                                                        return true;
                                                       })
                                          .orElse(false);
    }
}
