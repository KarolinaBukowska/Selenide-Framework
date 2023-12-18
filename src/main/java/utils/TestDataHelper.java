package utils;

import java.util.UUID;
public class TestDataHelper {

    public static String
    generateRandomEmail(String prefix, String suffix) {
        return prefix + UUID.randomUUID() + suffix;
    }
}
