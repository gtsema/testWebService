package ru.example.service;

import ru.example.model.User;

public interface UserService {

    /**
     * Создает нового пользователя, возвращает его id
     * @param user - пользователь для создания
     * @return  - id созданного пользователя
     */
    int create(User user);

    /**
     * Возвращает пользователя, по его id
     * @param id - id пользователя
     * @return  - объект пользователя с заданным id
     */
    User read(int id);

}
