package ru.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputChecker {

    private static final Logger logger = LoggerFactory.getLogger(InputChecker.class);

    /**
     * Проверяет имя пользователя на корректность
     * @param username - имя пользователя
     * @return  - true, если имя пользователя
     * от 1 до 16ти буквенно-цифровых символов.
     */
    public static boolean isUsername(String username) {
        boolean result = !username.isEmpty() && username.matches("\\w{1,16}");
        if(!result) logger.info("Username does not match the pattern or is empty");
        return result;
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
        boolean result = !email.isEmpty() && email.matches("^\\w{1,16}@\\w{1,16}[\\.][A-Za-z0-9]{2,3}");
        if(!result) logger.info("Email does not match the pattern or is empty");
        return result;
    }

    /**
     * Проверяет email на корректность
     * @param phone - номер телефона
     * @return  - true, если номер телефона
     * удовлетворяет следующему шаблону:
     * +7 (xxx) xxx-xxxx, где x - цифра.
     */
    public static boolean isPhoneNumber(String phone) {
        boolean result = !phone.isEmpty() && phone.matches("^\\+7\\s\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}");
        if(!result) logger.info("Phone number does not match the pattern or is empty");
        return result;
    }
}
