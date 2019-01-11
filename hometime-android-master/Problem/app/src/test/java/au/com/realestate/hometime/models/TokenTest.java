package au.com.realestate.hometime.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * TokenTest is a unit test case for model Token class
 */
public class TokenTest {
    private Token mToken;
    private String testTokenValue = "123456";

    /**
     * Unit test case to test token
     */
    @Test
    public void testValidToken() {
        mToken = new Token();
        mToken.setValue(testTokenValue);
        Assert.assertNotNull(mToken.getValue());
        Assert.assertEquals(testTokenValue, mToken.getValue());
    }

}
