package ru.example.service;

import org.springframework.stereotype.Service;
import ru.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    private static final Map<Integer, User> USER_REPO = new HashMap<>();

    private static final AtomicInteger USER_ID = new AtomicInteger();

    @Override
    public int create(User user) {
        final int userId = USER_ID.incrementAndGet();
        user.setId(userId);
        USER_REPO.put(userId, user);
        return userId;
    }

    @Override
    public User read(int id) {
        return USER_REPO.get(id);
    }
}
