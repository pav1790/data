package models;

import java.time.Month;
import java.time.Year;

public class DateOfBirth {

    private int day;
    private Month month;
    private int year;

    public DateOfBirth(String day, String month, String year) {
        this(Integer.getInteger(day), month, Integer.getInteger(year));
    }

    public DateOfBirth(int day, String month, int year) {
        if (day < 1 || day > 30) {
            throw new RuntimeException();
        } else {
            this.day = day;
        }

        this.month = Month.valueOf(month.toUpperCase());
        int monthValue = this.month.getValue();
        if (monthValue < 1 || monthValue > 12) {
            throw new RuntimeException();
        }

        if (year < 1900 || (Year.now().isBefore(Year.of(year)))) {
            throw new RuntimeException();
        } else {
            this.year = year;
        }
    }

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
