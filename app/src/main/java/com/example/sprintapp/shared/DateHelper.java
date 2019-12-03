package com.example.sprintapp.shared;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateHelper {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";


    public static String format(Date date) {
        DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.UK);
        return df.format(date);
    }

    public static String format(int year, int month, int day) {
        Date date = createDate(year, month, day);
        return format(date);
    }

    public static Date createDate(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

}
