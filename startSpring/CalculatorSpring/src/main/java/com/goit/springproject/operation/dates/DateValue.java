package com.goit.springproject.operation.dates;

public class DateValue {

    private int years;
    private int months;
    private int days;

    public DateValue() {
        this.years = 0;
        this.months = 0;
        this.days = 0;
    }

    public DateValue(int years, int months,int days) {
        validationDateValue(days, months, years);

        this.years = years;
        this.months = months;
        this.days = days;
    }

    private void validationDateValue(int years, int months,int days) {
        if (years < 0 || years > 999) {
            throw new IllegalArgumentException("Your set bad years value");
        }
        if (months < 0 || months > 999) {
            throw new IllegalArgumentException("Your set bad months value");
        }
        if (days < 0 || days > 999) {
            throw new IllegalArgumentException("Your set bad days value");
        }
    }

    public int getYears() {
        return years;
    }

    public int getMonths() {
        return months;
    }

    public int getDays() {
        return days;
    }
}
