package au.com.realestate.hometime.utility;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Date;

/**
 * CommonUtilsTest is a unit test case for CommonUtils model class
 */
public class CommonUtilsTest {
    private String dotNetDate = "/Date(1547183694000+1100)/";

    /**
     * Unit test case to test dot net date
     */
    @Test
    public void testDateFromDotNetDate() {
        Date date = CommonUtils.dateFromDotNetDate(dotNetDate);
        Assert.assertNotNull(date);
    }

    /**
     * Unit test case to test difference in minutes method
     */
    @Test
    public void testDifferenceInMinutes() {
        Date date = CommonUtils.dateFromDotNetDate(dotNetDate);
        String minutes = CommonUtils.getDifferenceInMinutes(date);
        Assert.assertNotNull(date);
        Assert.assertNotNull(minutes);
    }
}
