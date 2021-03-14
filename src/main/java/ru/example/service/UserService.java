package ru.example.service;

import ru.example.model.User;

import java.util.Optional;

public interface UserService {

    /**
     * Создает нового пользователя, возвращает его id
     * @param user пользователь для создания
     * @return id созданного пользователя
     */
    int create(User user);

    /**
     * Возвращает Optional<User> пользователя, по его id.
     * Если не пользователь не найден - Optional с null.
     * @param id id пользователя
     * @return Optional&lt;User&gt; или Optional с null.
     */
    Optional<User> read(int id);


    /**
     * Обновляет пользователя с заданным ID,
     * в соответствии с переданным клиентом
     * @param user обновлённый пользователь
     * @param id id пользователя, которого нужно обновить
     * @return true если пользователь был обновлен, иначе false
     */
    boolean update(User user, int id);
}
