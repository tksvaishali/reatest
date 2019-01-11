package au.com.realestate.hometime.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * CommonUtils class contains common methods
 */
public class CommonUtils {
    public static final String DATE_TIMEZONE = "Australia/Melbourne";

    /**
     * Method to convert .NET Date to Date
     *
     * @param dotNetDate Date in .NET format
     * @return date in Date Format
     */
    public static Date dateFromDotNetDate(String dotNetDate) {
        int startIndex = dotNetDate.indexOf("(") + 1;
        int endIndex = dotNetDate.indexOf("+");
        String date = dotNetDate.substring(startIndex, endIndex);
        Long unixTime = Long.parseLong(date);
        Date tramDate = new Date(unixTime);
        return tramDate;
    }

    /**
     * Method to get difference between dates in minutes
     *
     * @param date Date
     * @return date difference in minutes
     */
    public static String getDifferenceInMinutes(Date date) {
        long minutes = 0;
        Calendar calendar = new GregorianCalendar();
        TimeZone timeZone = TimeZone.getTimeZone(DATE_TIMEZONE);
        calendar.setTimeZone(timeZone);
        Date currentTime = calendar.getTime();

        Long diff = date.getTime() - currentTime.getTime();

        long seconds = diff / 1000;
        minutes = seconds / 60;
        return "" + minutes;
    }
}