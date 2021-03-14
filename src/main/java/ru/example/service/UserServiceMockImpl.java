package ru.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

//@Service
public class UserServiceMockImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceMockImpl.class);

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
    public Optional<User> read(int id) {
        delay();
        return Optional.of(USER_REPO.get(id));
    }

    @Override
    public boolean update(User user, int id) {
        return false;
    }

    private void delay() {
        try { Thread.sleep((int)((Math.random()*5+5)*1000)); }
        catch (InterruptedException e) { /*ignore*/ }
    }
}
