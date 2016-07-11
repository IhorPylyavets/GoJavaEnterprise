package com.goit.springproject.operation.dates;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Date {

    private int day;
    private int month;
    private int year;

    private Date(int day, int month, int year) {
        argumentsValidation(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static class DateFactory {
        public static Date fromInts(int day, int month, int year) {
            return new Date(day, month, year);
        }

        public static Date fromString(String date) {
            validateStringDate(date);
            String[] dateValues = splitStringDate(date);
            validateStringValueDate(dateValues);

            return new Date(parseInt(dateValues[0]), parseInt(dateValues[1]), parseInt(dateValues[2]));
        }

        public static Date fromDate(java.sql.Date date) {
            return new Date(date.getDay(), date.getMonth(), date.getYear());
        }
    }

    private static void argumentsValidation(int day, int month, int year) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day should be in range 1..31");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month should be in range 1..12");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Year should be positive value");
        }
        if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            throw new IllegalArgumentException("Months (may, june, september, november) consist of 30 days");
        }
        if (month == 2 && (day == 30 || day == 31)) {
            throw new IllegalArgumentException("Month february consist of 28 or 29 days");
        }
        if (month == 2 && day == 29 && year%4 != 0) {
            throw new IllegalArgumentException("Month february consist of 29 days only in leap year");
        }
    }

    private static void validateStringDate(String date) {
        char[] chars = date.toCharArray();

        for (char c : chars) {
            if (!isDigit(c)) {
                throw new IllegalArgumentException("Bad string date value");
            }
        }
    }

    private static boolean isDigit(final char c) {
        return "0123456789.".indexOf(c) != -1;
    }

    private static String[] splitStringDate(String date) {
        return date.split(Pattern.quote("."));
    }

    private static void validateStringValueDate(String[] dateArray) {
        if (dateArray.length != 3) {
            throw new IllegalArgumentException("Date should consist of 3 values");
        }
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

    @Override
    public String toString() {
        String stringDay = Integer.toString(day);
        String stringMonth = Integer.toString(month);

        if (day < 10) {
            stringDay = "0".concat(stringDay);
        }
        if (month < 10) {
            stringMonth = "0".concat(stringMonth);
        }

        return String.format("%s.%s.%s", stringDay, stringMonth, year);
    }

}
