package au.com.realestate.hometime.utility;

import java.util.Date;

/**
 * CommonUtils class contains common methods
 */
public class CommonUtils {
    /**
     * Convert .NET Date to Date
     *
     * @param dotNetDate Date in .NET format
     * @return date in Date Format
     */
    public static Date dateFromDotNetDate(String dotNetDate) {

        int startIndex = dotNetDate.indexOf("(") + 1;
        int endIndex = dotNetDate.indexOf("+");
        String date = dotNetDate.substring(startIndex, endIndex);

        Long unixTime = Long.parseLong(date);
        return new Date(unixTime);
    }
}
