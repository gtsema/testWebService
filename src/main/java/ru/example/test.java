package ru.example;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<Integer, String> mmm = new HashMap<>() {{
            put(1, "a");
            put(2, "b");
            put(3, "c");
        }};

        int key = 4;

        boolean rse = mmm.replace(key, mmm.get(key), "жопа");

        System.out.println(rse);
        System.out.println(mmm);
    }
}
