package au.com.realestate.hometime.models;

import java.util.List;

/**
 * Model class for ApiResponse
 *
 * @param <T>
 */
public class ApiResponse<T> {
    public String errorMessage;
    public Boolean hasError;
    public Boolean hasResponse;
    public List<T> responseObject;

    /**
     * Get Error Message
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Set ErrorMessage
     *
     * @param errorMessage the error messsage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Get Has Error Value
     *
     * @return boolean value which determines whether error message is there
     */
    public Boolean getHasError() {
        return hasError;
    }

    /**
     * Set Has Error Value
     *
     * @param hasError boolean value to set if error message is there
     */
    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    /**
     * Get Has Response Value
     *
     * @return boolean value which determines whether response is there
     */
    public Boolean getHasResponse() {
        return hasResponse;
    }

    /**
     * Set Has Response value
     *
     * @param hasResponse boolean value to set if response is there
     */
    public void setHasResponse(Boolean hasResponse) {
        this.hasResponse = hasResponse;
    }

    /**
     * Get Response object
     *
     * @return the list of response object
     */
    public List<T> getResponseObject() {
        return responseObject;
    }

    /**
     * Set Response object
     *
     * @param responseObject the list of response object
     */
    public void setResponseObject(List<T> responseObject) {
        this.responseObject = responseObject;
    }
}