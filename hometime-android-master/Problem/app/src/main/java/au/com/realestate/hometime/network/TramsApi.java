package au.com.realestate.hometime.network;

import au.com.realestate.hometime.models.ApiResponse;
import au.com.realestate.hometime.models.Token;
import au.com.realestate.hometime.models.Tram;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * TramsApi is an interface to make service calls
 */
public interface TramsApi {
    @GET("/TramTracker/RestService/GetDeviceToken/?aid=TTIOSJSON&devInfo=HomeTimeAndroid")
    Call<ApiResponse<Token>> token();

    @GET("/TramTracker/RestService//GetNextPredictedRoutesCollection/{stopId}/78/false/?aid=TTIOSJSON&cid=2")
    Call<ApiResponse<Tram>> trams(
            @Path("stopId") String stopId,
            @Query("tkn") String token
    );
}