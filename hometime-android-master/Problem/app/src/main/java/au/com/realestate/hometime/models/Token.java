package au.com.realestate.hometime.models;

import com.squareup.moshi.Json;

/**
 * Model class Token
 */
public class Token {
    @Json(name = "DeviceToken")
    public String value;

    /**
     * Get Method
     *
     * @return return the value string
     */
    public String getValue() {
        return value;
    }

    /**
     * Set Method
     *
     * @return sets the value string
     */
    public void setValue(String value) {
        this.value = value;
    }
}
