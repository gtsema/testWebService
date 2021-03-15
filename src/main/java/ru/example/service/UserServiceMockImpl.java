package ru.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceMockImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceMockImpl.class);

    private static final Map<Integer, User> userRepository = new HashMap<>();

    private static final AtomicInteger USER_ID = new AtomicInteger();

    @Override
    public int create(User user) {
        delay();
        final int userId = USER_ID.incrementAndGet();
        user.setId(userId);
        userRepository.put(userId, user);
        return userId;
    }

    @Override
    public Optional<User> read(int id) {
        delay();
        return Optional.ofNullable(userRepository.get(id));
    }

    @Override
    public boolean update(User user, int id) {
        delay();
        return userRepository.replace(id, userRepository.get(id), user);
    }

    private void delay() {
        try { Thread.sleep((int)((Math.random()*5+5)*1000)); }
        catch (InterruptedException e) {
            logger.error("Interrupt Exception in UserServiceMockImpl.delay() O_o");
        }
    }
}
