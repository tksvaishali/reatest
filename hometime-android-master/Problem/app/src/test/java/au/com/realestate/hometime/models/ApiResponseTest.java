package au.com.realestate.hometime.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ApiResponseTest is a unit test case for model ApiResponse class
 */
public class ApiResponseTest {
    private String mDestination = "Melbourne";
    private String mPredictedArrival = "10:15 pm";
    private String mRouteNo = "1";
    private String mErrorMessage = "NetworkException";

    /**
     * Unit test case to test Response object
     */
    @Test
    public void testValidResponseObject() {
        Tram mTram = new Tram();
        mTram.setDestination(mDestination);
        mTram.setPredictedArrival(mPredictedArrival);
        mTram.setRouteNo(mRouteNo);
        ApiResponse mTramApiResponse = new ApiResponse<>();
        List tramList = new ArrayList();
        tramList.add(mTram);
        mTramApiResponse.setHasResponse(true);
        mTramApiResponse.setResponseObject(tramList);
        Assert.assertNotNull(mTram);
        Assert.assertNotNull(mTramApiResponse);
        Assert.assertTrue(mTramApiResponse.getHasResponse());
        Assert.assertEquals(mTram, mTramApiResponse.getResponseObject().get(0));
    }

    /**
     * Unite test case to test error message
     */
    @Test
    public void testValidErrorMessage() {
        ApiResponse mTramApiResponse = new ApiResponse<>();
        mTramApiResponse.setHasError(true);
        mTramApiResponse.setErrorMessage(mErrorMessage);
        Assert.assertNotNull(mTramApiResponse);
        Assert.assertTrue(mTramApiResponse.getHasError());
        Assert.assertEquals(mErrorMessage, mTramApiResponse.getErrorMessage());
    }
}
