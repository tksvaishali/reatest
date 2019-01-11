package au.com.realestate.hometime.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * TramTest is a unit test case for model Tram class
 */
public class TramTest {
    private Tram mTram;
    private String mDestination = "Melbourne";
    private String mPredictedArrival = "10:15 pm";
    private String mRouteNo = "1";

    /**
     * Unit test case to test destination
     */
    @Test
    public void testValidDestination() {
        mTram = new Tram();
        mTram.setDestination(mDestination);
        Assert.assertNotNull(mTram);
        Assert.assertNotNull(mTram.getDestination());
        Assert.assertEquals(mDestination, mTram.getDestination());
    }

    /**
     * Unit test case to test predicted arrival
     */

    @Test
    public void testValidPredictedArrival() {
        mTram = new Tram();
        mTram.setPredictedArrival(mPredictedArrival);
        Assert.assertNotNull(mTram);
        Assert.assertNotNull(mTram.getPredictedArrival());
        Assert.assertEquals(mPredictedArrival, mTram.getPredictedArrival());
    }

    /**
     * Unit test case to test route no
     */
    @Test
    public void testValidRouteNo() {
        mTram = new Tram();
        mTram.setRouteNo(mRouteNo);
        Assert.assertNotNull(mTram);
        Assert.assertNotNull(mTram.getRouteNo());
        Assert.assertEquals(mRouteNo, mTram.getRouteNo());
    }
}