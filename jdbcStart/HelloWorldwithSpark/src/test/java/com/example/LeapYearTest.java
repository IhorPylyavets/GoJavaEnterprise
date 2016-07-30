package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeapYearTest {

    @Test
    public void isLeapYear_forNumberDivisibleByFour_true() throws Exception {
        assertEquals(true, LeapYear.isLeapYear(2012));
    }

    @Test
    public void isLeapYear_forNumberNotDivisibleByFour_false() throws Exception {
        assertEquals(false, LeapYear.isLeapYear(2011));
    }

    @Test
    public void isLeapYear_forMultiplesOfOneHundred_false() throws Exception {
        assertEquals(false, LeapYear.isLeapYear(1900));
    }

    @Test
    public void isLeapYear_forMultiplesOfFourHundred_true() throws Exception {
        assertEquals(true, LeapYear.isLeapYear(2000));
    }
}
