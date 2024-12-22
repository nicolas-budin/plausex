package org.louhan.plausex.utils;

public class StringUtils {


    // Helper method to check if a string is valid (not null and not empty)
    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
