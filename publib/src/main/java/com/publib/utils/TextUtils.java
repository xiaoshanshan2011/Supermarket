package com.publib.utils;

public class TextUtils {
    public static boolean isEmpty(String text) {
        if (text == null || text.length() == 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Integer text) {
        if (text == null || text == 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Long text) {
        if (text == null || text == 0)
            return true;
        else
            return false;
    }

    public static boolean isEmpty(Double text) {
        if (text == null || text == 0)
            return true;
        else
            return false;
    }
}
