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
}


