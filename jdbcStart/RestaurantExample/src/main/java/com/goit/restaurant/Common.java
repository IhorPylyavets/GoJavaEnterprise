package com.goit.restaurant;

import java.sql.Timestamp;

public class Common {

    public static Timestamp stringToTimestamp(String stringTimestamp) {
        return java.sql.Timestamp.valueOf(stringTimestamp);
    }

    public  static java.sql.Date stringToSqlDate(String dateBirthday) {
        return java.sql.Date.valueOf(dateBirthday);
    }

}
