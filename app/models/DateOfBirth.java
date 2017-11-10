package models;

import java.time.Month;
import java.time.Year;

public class DateOfBirth {

    private int day;
    private int month;
    private int year;

    public DateOfBirth(int day, int month, int year) {
        if (day < 1 || day > 30 || month < 1 || month > 12 || year < 1900 || (Year.now().isBefore(Year.of(year)))) {
            throw new RuntimeException();
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
