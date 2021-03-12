package ru.example.utils;

import ru.example.model.User;

public class InputChecker {
    public static boolean checkUsername(String username) {
        return !username.isEmpty() && username.matches("\\w{1,16}");
    }

    public static boolean checkEmail(String email) {
        return !email.isEmpty() && email.matches("^\\w{1,16}@\\w{1,16}[\\.][A-Za-z0-9]{2,3}");
    }

    public static boolean checkPhone(String phone) {
        return !phone.isEmpty() && phone.matches("^\\+7\\s\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}");
    }

    public static boolean checkStatus(String status) {
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
