package com.goit.springproject.operation.dates;

public interface DateOperation {
    public DateValue differanceBetweenDates(Date fromDate, Date toDate);
    public Date addToDate(Date fromDate, DateValue dateValue);
    public Date subFromDate(Date fromDate, DateValue dateValue);
}
