package com.goit.springproject.operation.dates;

public interface DateOperation {
    public Date addDateToData(Date dateStart, Date valueDate);
    public Date addYearToData(Date dateStart, int yearsCount);
    public Date addMonthToData(Date dateStart, int monthsCount);
    public Date addDayToData(Date dateStart, int daysCount);

    public Date subDateWithDate(Date dateStart, Date valueDate);
    public Date subDataWithYears(Date dateStart, int yearsCount);
    public Date subDataWithMonths(Date dateStart, int monthsCount);
    public Date subWithDays(Date dateStart, int daysCount);
}
