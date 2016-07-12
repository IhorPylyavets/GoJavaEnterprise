package com.goit.springproject.operation.dates;

public interface DateOperation {
    DateValue differanceBetweenDates(Date fromDate, Date toDate);
    Date addToDate(Date fromDate, DateValue dateValue);
    Date subFromDate(Date fromDate, DateValue dateValue);
}
