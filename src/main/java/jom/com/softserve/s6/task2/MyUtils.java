package jom.com.softserve.s6.task2;

import java.time.LocalDate;
import java.time.Period;

class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plus(Period.of(years, months, days));
        return futureDate.toString();
    }
}

