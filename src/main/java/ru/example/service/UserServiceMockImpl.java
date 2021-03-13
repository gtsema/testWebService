package ru.example.service;

import org.springframework.stereotype.Service;
import ru.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceMockImpl implements UserService {

    private static final Map<Integer, User> USER_REPO = new HashMap<>();

    private static final AtomicInteger USER_ID = new AtomicInteger();

    @Override
    public int create(User user) {
        delay();
        final int userId = USER_ID.incrementAndGet();
        user.setId(userId);
        USER_REPO.put(userId, user);
        return userId;
    }

    @Override
    public User read(int id) {
        delay();
        return USER_REPO.get(id);
    }

    private void delay() {
        try { Thread.sleep((int)((Math.random()*5+5)*1000)); }
        catch (InterruptedException e) { /*ignore*/ }
    }
}
