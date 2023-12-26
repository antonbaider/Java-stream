package jom.com.softserve.s6.task1;

import java.time.LocalDate;

public class MyUtils {
    public static boolean isLeapYear(int year) {
        LocalDate localDate = LocalDate.of(year, 1, 1);
        return localDate.isLeapYear();
    }
}