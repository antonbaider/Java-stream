package jom.com.softserve.s6.task1;

import java.time.Year;

public class MyUtils {
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }
}