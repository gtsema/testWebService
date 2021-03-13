package ru.example.utils;

import ru.example.model.User;

public class InputChecker {
    /**
     * Проверяет имя пользователя на корректность
     * @param username - имя пользователя
     * @return  - true, если имя пользователя
     * от 1 до 16ти буквенно-цифровых символов.
     */
    public static boolean isUsername(String username) {
        return !username.isEmpty() && username.matches("\\w{1,16}");
    }

    /**
     * Проверяет email на корректность
     * @param email - email адресс
     * @return  - true, если email состоит из:
     * левая от @ часть - от 1 до 16 латинских
     * буквенно-цифровых символов или знака
     * подчеркивания, правая от @ часть - от 1 до 16
     * латинских буквенно-цифровых символов, или знака
     * подчеркивания, точки, от 2 до 3 латинских
     * буквенно-цифровых символов.
     */
    public static boolean isEmail(String email) {
        return !email.isEmpty() && email.matches("^\\w{1,16}@\\w{1,16}[\\.][A-Za-z0-9]{2,3}");
    }

    /**
     * Проверяет email на корректность
     * @param phone - номер телефона
     * @return  - true, если номер телефона
     * удовлетворяет следующему шаблону:
     * +7 (xxx) xxx-xxxx, где x - цифра.
     */
    public static boolean isPhoneNumber(String phone) {
        return !phone.isEmpty() && phone.matches("^\\+7\\s\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}");
    }

    /**
     * Проверяет email на корректность
     * @param status - статус пользователя.
     * @return  - true, если статус пользователя
     * содержится в enum User.Status.
     */
    public static boolean isStatus(String status) {
        if(!status.isEmpty()) {
            try {
                User.Status.valueOf(status);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }
}
